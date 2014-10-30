package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _03_ExchangeValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numA, numB, temp;
        
        // Leer el primer numero
        System.out.print("Introducir numero (A): ");
        numA = Integer.parseInt(scan.nextLine());
        
        // Leer el segundo numero
        System.out.print("Introducir numero (B): ");
        numB = Integer.parseInt(scan.nextLine());
        
        // Mostrar valores iniciales
        System.out.println("A: " + numA + ", B: " + numB);
        
        // Almacenar el valor de A en una variable temporal
        temp = numA;
        numA = numB; // Asignar a A el B
        numB = temp; // Asignar a B el A mediante la variable temporal (temp)
        
        // Mostrar valores despues del intercambio
        System.out.println("A: " + numA + ", B: " + numB);
    }
}
