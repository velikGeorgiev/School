
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _04_NumberBetween100and1000 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number;
        
        // Leer el numero
        System.out.print("Introducir numero: ");
        number = Integer.parseInt(scan.nextLine());
        
        // comprobar si el numero esta entre 100 y 1000
        if(number >= 100 && number <= 1000) {
            System.out.println("El numero " + number + " esta entre 100 y 1000");
        } else {
            System.out.println("El numero " + number + " no esta entre 100 y 1000");
        }
    }

}
