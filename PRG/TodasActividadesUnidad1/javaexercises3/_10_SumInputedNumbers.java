package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _10_SumInputedNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long sum = 0;
        int number;

        do {
            // Leer el numero
            System.out.print("Numero: ");
            number = Integer.parseInt(scan.nextLine());
            
            // Si el numero es 0 salimos del bucle
            if (number == 0) break;
            
            System.out.println("-> " + number + ". Suma parcial: " + (sum + number));
            sum += number;
        } while (true);
    }
}
