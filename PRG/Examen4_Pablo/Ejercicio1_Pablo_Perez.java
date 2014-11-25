/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_t4_pablo_perez;

import java.util.Scanner;

/**
 *
 * @author vesprada
 */
public class Ejercicio1_Pablo_Perez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Boolean fin = false;
        String frase;
        do{
            System.out.println("Introduzca una frase: ");
            frase = entrada.nextLine();
            if ("fin".equals(frase)) fin = true;
            maxVocal(frase);
        }while(!fin);
        
    }
    
    static int numVocal(String palabra){
        int res = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == 'a' ||
                palabra.charAt(i) == 'e' ||
                palabra.charAt(i) == 'i' ||
                palabra.charAt(i) == 'o' ||
                palabra.charAt(i) == 'u' ||
                palabra.charAt(i) == 'A' ||
                palabra.charAt(i) == 'E' ||
                palabra.charAt(i) == 'I' ||
                palabra.charAt(i) == 'O' ||
                palabra.charAt(i) == 'U') {
                    res++;
                   // System.out.println(palabra + " " + res);
            }
        }
        return res;
    }
    static void maxVocal(String frase){
        String[] palabras = frase.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }
        int letras;
        int max = 0;
        int p = 0;
        for (int i = 0; i < palabras.length; i++) {
            letras = numVocal(palabras[i]);
            if (letras > max){
                max = letras;
                p = i;
            }
        }
        if ("fin".equals(palabras[0])) System.out.println(""); 
        else if (max != 0) System.out.println("La palabra con más vocales es " + palabras[p]);
        else if (max == 0)  System.out.println("No hay palabras con vocales");

    }
    
}
