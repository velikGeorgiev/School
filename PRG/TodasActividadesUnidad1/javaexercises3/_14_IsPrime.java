
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _14_IsPrime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number;
        boolean isPrime = true;
        
        // Leer el numero
        System.out.print("Introducir numero: ");
        number = Integer.parseInt(scan.nextLine());
                
        for(int i=2; i < Math.sqrt(number); i++) {
            if((number % i) == 0) {
                isPrime = false;
                break;
            }
        }
        
        if(isPrime == false) {
            System.out.println("No es primo.");
        } else { 
            System.out.println("Es primo.");
        }
    }
}
