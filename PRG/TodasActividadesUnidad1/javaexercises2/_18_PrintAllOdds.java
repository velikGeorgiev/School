package javaexercises2;

/**
 *
 * @author velko
 */
public class _18_PrintAllOdds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Incrementamos con 2, asi reducimos los loops en 1/2
        for(int i = 2; i <= 100; i += 2) {
            System.out.println(i);
        }
    }
}
