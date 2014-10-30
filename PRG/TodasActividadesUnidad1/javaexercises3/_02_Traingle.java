
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _02_Traingle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int base, height;
        
        // Leer el numero A
        System.out.print("Base: ");
        base = Integer.parseInt(scan.nextLine());
        
        // Leer numero B
        System.out.print("Altura: ");
        height = Integer.parseInt(scan.nextLine());
        
        System.out.println("Area: " + (base * height) / 2 + "\nPerimetro: " + 3  * base);
    }

}
