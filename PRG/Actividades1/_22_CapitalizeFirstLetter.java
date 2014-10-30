package javaexercises;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _22_CapitalizeFirstLetter {
    public static void main(String[] args) {
        System.out.println("Nombre: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine(); // We trust that the input is valid, so no validation will be made
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        
        System.out.println(name);
    }
}
