package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _13_ArmstrongNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number, exp, temp, sum;

        do {
            // valores predeterminados/iniciales
            sum = 0;
            
            // Leer el numero
            System.out.print("Numero: ");
            number = Math.abs(Integer.parseInt(scan.nextLine())); // Nos aseguramos de que es un valor positivo
            exp = String.valueOf(number).length(); // Contamos los digitos

            // Variable temporal. Copia del numero para poder manipular lo, sin perder el valor original
            temp = number;

            // Calcular armstrong
            while (temp > 0) {
                int lastDigit = temp % 10;
                sum += Math.pow(lastDigit, exp);
                temp /= 10;
            }

            // Comprobamos si es un numero Armstrong e imprimimos el resultado.
            if (sum == number) {
                System.out.println("El numero " + number + " es un numero Armstrong.");
            } else {
                System.out.println("El numero " + number + " no es un numero Armstrong.");
            }
        } while (sum != number);
    }
}
