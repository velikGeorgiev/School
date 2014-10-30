package javaexercises;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _24_DivideTwoNumbers {
    public static void main(String[] args) {
        int firstNumber = nextNumber("Primer Numero: ");
        int secondNumber = nextNumber("Segundo Numero: ");
        
        System.out.printf("Division: %d\nResto: %d\n", (firstNumber / secondNumber), (firstNumber % secondNumber));
    }
    
    public static int nextNumber(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.print(str);
        
        return Integer.parseInt(scan.nextLine());
    }
}
