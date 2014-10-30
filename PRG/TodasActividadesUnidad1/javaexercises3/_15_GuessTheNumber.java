
package javaexercises3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _15_GuessTheNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int guess, trys = 1;
        
        // Generamos un numero del 1 al 100
        int min = 1;
        int max = 100;
        int number = new Random().nextInt((max - min) + 1) + min;
        
        do {
            // Leer el numero. Nos aseguramos de que el numero es positivo
            System.out.print("Numero (" + trys + "): ");
            guess = Math.abs(Integer.parseInt(scan.nextLine()));
            
            if(guess == number) {
                System.out.println("CORRECTO !!!");
                break;
            } else if (guess < number) {
                System.out.println("Te has quedado corto.");
            } else {
                System.out.println("Te has pasado.");
            }
            
            //Si se pasa de los 6 intentos interumpimos el bucle
            if(trys++ >= 6) {
                System.out.println("El numero era: " + number);
                break;
            } 
        }while(true);
    }
}
