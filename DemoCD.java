/**
 *
 * Clase de prueba del CD
 */
public class DemoCD
{
    /**
     *
     *
     */
    public static void main(String[] args)
    {
        // Aceptar argumentos a través del main
        if (args.length != 3) {
            System.out.println("Error en nº argumentos, Sintaxis: java DemoCD <n> <titulo> <artista>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        String titulo = args[1];
        String artista = args[2];

        // Crear el CD
        CD cd = new CD(n, titulo, artista);

        // Añadir varias canciones al CD (al final del CD)
        cd.addCancion("Ave María", 3.45);
        cd.addCancion("Lloraré tus penas", 2.34);
        cd.addCancion("Lucía", 4.55);
        cd.addCancion("Ella", 4.21);
        cd.addCancion("Esclavo de tus besos", 4.23);
        cd.addCancion("Bulería Bulería", 3.72);

        // Mostrar el CD
        System.out.println(cd.toString());
        System.out.println("---------------------------------------------");

        // Mostrar la duración del CD
        System.out.println("Duración total: " + cd.duracionTotal() + "'");
        System.out.println("---------------------------------------------");

        // Mostrar el total de canciones en el CD
        System.out.println("Total de canciones: " + cd.totalCanciones());
        System.out.println("---------------------------------------------");

        // Mostrar los títulos de las canciones
        String[] titulos = cd.getTitulos();
        System.out.println("Títulos de canciones:");
        for (String tituloCancion : titulos) {
            System.out.println(tituloCancion);
        }
        System.out.println("---------------------------------------------");

        // Mostrar una canción aleatoria
        System.out.println("Canción aleatoria: " + cd.getAleatoria().getTitulo());
        System.out.println("---------------------------------------------");

        // Mostrar cuántas canciones contienen "Bulería" en el título
        System.out.println("Canciones que contienen 'Bulería': " + cd.cancionesQueContienen("Bulería"));
        System.out.println("---------------------------------------------");

        // Borrar canciones que empiezan con "Es"
        String[] borradas = cd.borrarCancionesQueEmpiezan("Es");
        if (borradas != null) {
            System.out.println("Canciones borradas:");
            for (String cancionBorrada : borradas) {
                System.out.println(cancionBorrada);
            }
        } else {
            System.out.println("No se borraron canciones.");
        }
        System.out.println("---------------------------------------------");

        // Mostrar el CD después de borrar canciones
        System.out.println(cd.toString());
        System.out.println("---------------------------------------------");

        // Crear un nuevo CD con canciones ordenadas por título
        CD nuevoCD = cd.crearNuevoCD();
        System.out.println("Nuevo CD con canciones ordenadas por título:");
        System.out.println(nuevoCD.toString());
    }
}
