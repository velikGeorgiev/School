package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class TestMe {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ejemplo 1: ");
        example1();
        
        System.out.println("\nEjemplo 2: ");
        example2();
        
        System.out.println("\nEjemplo 3: ");
        example3();
    }

    public static void example1(){
        System.out.print("Insertar numero: ");
        int number = input.nextInt();
        System.out.print("Texto: ");
        String text1 = input.next();
        System.out.print("Texto2: ");
        String text2 = input.next();
    }
    
    public static void example2() {
        System.out.print("Insertar numero: ");
        int number = input.nextInt();
        System.out.print("Texto: ");
        String text1 = input.nextLine();
        System.out.print("Texto2: ");
        String text2 = input.nextLine();
    }
    
    public static void example3() {
        System.out.print("Insertar numero: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.print("Texto: ");
        String text1 = input.nextLine();
        System.out.print("Texto2: ");
        String text2 = input.nextLine();
    }
}
