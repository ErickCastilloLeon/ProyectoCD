
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
        // aceptar argumentos a través del main
        
        
        
        // crear el CD
        
        
        
        // añadir varias canciones al CD (al final del CD
        cd.addCancion("Ave María", 3.45);
        cd.addCancion("Lloraré tus penas", 2.34);
        cd.addCancion("Lucía", 4.55);
        cd.addCancion("Ella", 4.21);
        cd.addCancion("Esclavo de tus besos ", 4.23);
        cd.addCancion("Bulería Bulería ", 3.72);
        
        
        //  Mostar el CD
        System.out.println(cd.toString());
        System.out.println("---------------------------------------------");
        
        
        // Mostar la duración del CD
        System.out.println("Duración total. " + cd.duracionTotal() + "'");
        System.out.println("---------------------------------------------");
        
      
        
        
        
        
        
        
    }
}
