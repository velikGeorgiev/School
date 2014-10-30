
package javaexercises3;

import java.math.BigInteger;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _11_NumbersCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum = 0;
        BigInteger product = new BigInteger("1");
        
        for(int i = 20; i <= 400; i += 2) {
            sum += i;
            product = product.multiply(new BigInteger(String.valueOf(i)));
        }
        
        System.out.printf("Suma: %d\nProducto: %d\n", sum, product);
    }

}
