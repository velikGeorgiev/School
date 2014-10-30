
package javaexercises3;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _11_Actualizado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum = 0;
        long product = 1L;
        
        /**
         *  A partir de 49 se necesitara el objeto BigInteger
         */
        for(int i = 20; i <= 40; i += 2) {
            sum += i;
            product *= i;
        }
        
        System.out.printf("Suma: %d\nProducto: %d\n", sum, product);
    }

}
