
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _05_IsNDivByM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numN, numM;
        
        // Leer el primer numero N
        System.out.print("Introducir numero (N): ");
        numN = Integer.parseInt(scan.nextLine());
        
        // Leer el segundo numero M
        System.out.print("Introducir numero (M): ");
        numM = Integer.parseInt(scan.nextLine());
        
        // Comprobar si N es divisible por M utilizando el modulo
        if((numN % numM) == 0) {
            System.out.println(numN + " es divisible por " + numM);
        } else {
            System.out.println(numN + " no es divisible por " + numM);
        }
    }

}
