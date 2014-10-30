package javaexercises;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _23_AddSpaceBetweenChars {
    public static void main(String[] args) {
        System.out.println("Nombre: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine(); // We trust that the input is valid, so no validation will be made
        
        for(int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i) + " ");
        }
        
        System.out.println("");
        
        System.out.println(name.replace("", " ").trim());
    }
}
