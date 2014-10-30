package javaexercises;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _25_IsMultiple {
    public static void main(String[] args) {
        int firstNumber = nextNumber("Primer Numero: ");
        int secondNumber = nextNumber("Segundo Numero: ");
        
        if((firstNumber % secondNumber) == 0) {
            System.out.printf("%d es multiplo de %d\n", firstNumber, secondNumber);
        } else {
            System.out.printf("%d NO es multiplo de %d\n", firstNumber, secondNumber);
        }
    }
    
    public static int nextNumber(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.print(str);
        
        return Integer.parseInt(scan.nextLine());
    }
}
