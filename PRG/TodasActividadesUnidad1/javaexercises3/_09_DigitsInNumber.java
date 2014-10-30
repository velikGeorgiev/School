
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _09_DigitsInNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long number; // Utilizamos long, ya que el numero puede contener mas de 32 bits o 2 147 483 647
        int sum = 0;
        
        // Leer el numero. Nos aseguramos de que es un valor positivo
        System.out.print("Introducir el numero: ");
        number = Math.abs(Long.parseLong(scan.nextLine()));
        
        // Podemos convertir el numero en String y sacar su tamaño
        System.out.println(String.valueOf(number).length());
        
        //usando while y %
        while(number > 0) {
            sum++;
            number /= 10;
        }
        
        System.out.println(sum);
    }
}
