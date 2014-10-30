
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _16_ReverseNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[5];
        
        // Leer los 5 numeros e introducir los en un vector.
        for(int i = 0; i < 5; i++) {
            System.out.print("Numero (" + (i + 1) + "): ");
            numbers[i] = Integer.parseInt(scan.nextLine());
        }
        
        // Imprimir los numeros en orden contrario.
        for(int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
        }
    }
}
