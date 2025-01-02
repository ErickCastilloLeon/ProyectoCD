import java.util.Arrays;

/**
 *
 * Representa a un CD
 */
public class CD
{
    private String titulo;
    private String artista;
    private Cancion[] canciones;
    private int pos; // total canciones en el CD

    /**
     * Constructor
     */
    public CD(int n, String titulo, String artista)
    {
        this.titulo = titulo;
        this.artista = artista;
        this.canciones = new Cancion[n];
        this.pos = 0;
    }

    /**
     *  añade una canción al CD  solo si no está completo
     *
     * @param  c la canción a añadir
     *
     */
    public void addCancion(Cancion c)
    {
        if (!estaCompleto()) {
            canciones[pos++] = c;
        }
    }

    /**
     *  añade una canción al CD  solo si no está completo
     *
     * @param  titulo el título de  la canción a añadir
     * @param  duracion la duración de  la canción a añadir
     *
     */
    public void addCancion(String titulo, double duracion)
    {
        if (!estaCompleto()) {
            canciones[pos++] = new Cancion(titulo, duracion);
        }
    }

    /**
     * devuelve true si el cd está lleno
     */
    public  boolean estaCompleto()
    {
        return pos >= canciones.length;
    }

    /**
     * devuelve el total de canciones en el CD
     */
    public  int totalCanciones()
    {
        return pos;
    }

    /**
     * Duración total del CD
     */
    public  double duracionTotal()
    {
        double total = 0;
        for (int i = 0; i < pos; i++) {
            total += canciones[i].getDuracion();
        }
        return total;
    }

    /**
     * Devuelve una canción aleatoria del CD
     */
    public  Cancion getAleatoria()
    {
        if (pos == 0) return null;
        int index = (int) (Math.random() * pos);
        return canciones[index];
    }

    /**
     * Devuelve un  array con los títulos de las canciones en mayúsculas
     */
    public  String[] getTitulos()
    {
        String[] titulos = new String[pos];
        for (int i = 0; i < pos; i++) {
            titulos[i] = canciones[i].getTitulo().toUpperCase();
        }
        return titulos;
    }

    /**
     * Devuelve cuántas canciones contienen en el título una cadena
     */
    public  int cancionesQueContienen(String str)
    {
        int count = 0;
        for (int i = 0; i < pos; i++) {
            if (canciones[i].getTitulo().toLowerCase().contains(str.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Borra las canciones que empiezan por una cadena devolviendo los títulos
     * que se han borrado. Si no hay ninguna se devuelve null
     */
    public String[] borrarCancionesQueEmpiezan(String str)
    {
        String[] borradas = new String[pos]; // Array para almacenar las canciones borradas
        int borradasCount = 0; // Contador para las canciones borradas
        for (int i = 0; i < pos; i++) {
            // Comprobar si el título de la canción empieza con la cadena proporcionada
            if (canciones[i].getTitulo().toLowerCase().startsWith(str.toLowerCase())) {
                borradas[borradasCount] = canciones[i].getTitulo(); // Almacenar el título
                borrarCancion(i); // Eliminar la canción
                borradasCount++; // Incrementar el contador de borradas
                i--;  // Ajustar el índice después de la eliminación
            }
        }

        // Si no se borraron canciones, devolver null
        if (borradasCount == 0) {
            return null;
        }

        // Crear un array con el tamaño adecuado y copiar las canciones borradas
        String[] resultado = new String[borradasCount];
        for (int i = 0; i < borradasCount; i++) {
            resultado[i] = borradas[i];
        }

        return resultado;
    }


    /**
     * Borra una canción, la que está en la posición p
     */
    private  void borrarCancion(int p)
    {
        for (int i = p; i < pos - 1; i++) {
            canciones[i] = canciones[i + 1];
        }
        canciones[--pos] = null;
    }

    /**
     * Obtener un array con las canciones ordenadas por título
     * Método de selección directa
     */
    public  Cancion[] cancionesOrdenadasPorTitulo()
    {
        Cancion[] ordenadas = Arrays.copyOf(canciones, pos);
        for (int i = 0; i < ordenadas.length - 1; i++) {
            for (int j = i + 1; j < ordenadas.length; j++) {
                if (ordenadas[i].getTitulo().compareToIgnoreCase(ordenadas[j].getTitulo()) > 0) {
                    Cancion temp = ordenadas[i];
                    ordenadas[i] = ordenadas[j];
                    ordenadas[j] = temp;
                }
            }
        }
        return ordenadas;
    }

    /**
     *  Crea  y devuelve un nuevo CD con las canciones ordenadas por título
     *
     */
    public CD crearNuevoCD()
    {
        CD nuevoCD = new CD(canciones.length, this.titulo, this.artista);
        Cancion[] ordenadas = cancionesOrdenadasPorTitulo();
        for (Cancion cancion : ordenadas) {
            nuevoCD.addCancion(cancion);
        }
        return nuevoCD;
    }

    /**
     * Representación textual del CD
     * De forma eficiente usando StringBuilder
     */
    public  String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("CD: ").append(titulo).append("\n");
        sb.append("Artista: ").append(artista).append("\n");
        sb.append("Total Canciones: ").append(pos).append("\n");
        sb.append("Duración Total: ").append(duracionTotal()).append("\n");
        sb.append("Canciones: \n");
        for (int i = 0; i < pos; i++) {
            sb.append(i + 1).append(". ").append(canciones[i].getTitulo()).append(" - ").append(canciones[i].getDuracion()).append(" mins\n");
        }
        return sb.toString();
    }
}
