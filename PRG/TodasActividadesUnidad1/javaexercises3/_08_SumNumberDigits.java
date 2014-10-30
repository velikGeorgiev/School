
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _08_SumNumberDigits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number, sum = 0;
        
        // Leer el numero. Nos aseguramos de que es un valor positivo
        System.out.print("Introducir el numero: ");
        number = Math.abs(Integer.parseInt(scan.nextLine()));
        
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        
        System.out.println(sum);
    }
}
