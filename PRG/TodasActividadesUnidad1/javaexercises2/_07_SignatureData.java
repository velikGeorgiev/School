package javaexercises2;

/**
 *
 * @author velko
 */
public class _07_SignatureData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           int suspended = 3;
           int pass = 10;
           int remarkable = 3;
           int outstanding = 2;
           
           int total = outstanding + remarkable + pass + suspended;
           
           System.out.println("Han aprobado " + ( ( 100 * (total - suspended) ) / total ) + "% de los alumnos");
           
           System.out.println("Suspendidos: " + ( ( 100 * suspended) / total ) + "%");
           System.out.println("Aprobados: " + ( ( 100 * pass) / total ) + "%");
           System.out.println("Notables: " + ( ( 100 * remarkable) / total ) + "%");
           System.out.println("Sobresalientes: " + ( ( 100 * outstanding) / total ) + "%");
    }

}
