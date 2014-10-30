/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTests;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class Actividad3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int temp1 = 0, temp2 = 0, input = 0, resta = 0, entradas = 0;
        
        do {
            temp1 = temp2;
            temp2 = input;
            
            input = Integer.parseInt(scan.nextLine());
            
            resta = temp1 - temp2;
            
            entradas++;
        }while(resta < input);
        
        System.out.println("Total entradas: " + entradas + "\nValores NO validos:");
        System.out.println("Valor 1: " + temp1);
        System.out.println("Valor 2: " + temp2);
        System.out.println("Valor 3: " + input);
    }
}