package Examen_T4_VelikGeorgiev;

import java.util.Scanner;

/**
 *
 * @author  Velik Georgiev Chelebiev
 */
public class Actividad3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        /**
         * La Frase introducida por el usuario
         */
        String frase = null;
        
        /**
         * La palabra que contenga mas vocales.
         * Esta ira cambiando hasta encontrar la correcta.
         */
        String palabraMasVocales = "";
        
        /**
         * Los contadores.
         * contadorMaxVocales guardara la palabra que contenga mas vocales
         * contadorVocales guardara los vocales de la palabra actual
         * 
         * Ambas variables iran cambiando a lo largo de un bucle.
         */
        int contadorMaxVocales = 0, contadorVocales = 0;
        
        do {
            // Pedimos al usuario que introduzca una frase
            System.out.print("Introduzca una frase: ");
            frase = scan.nextLine();
            
            // Si la frase es "fin" el programa termina
            if(frase.toLowerCase().trim().equals("fin")) {
                break;
            }
            
            // Separamos las palabra unas de otras guardando las en un vector
            String[] palabras = frase.split("[, !.;\\?-]+");
                        
            /**
             * Recorremos el vector de palabras
             * para poder comparar las y buscar la palabra con mas vocales.
             */
            for (int i = 0; i < palabras.length; i++) {
                // Contamos las vocales en la palabra actual
                contadorVocales = contarVocales(palabras[i]);
                
                // Si tiene mas vocales que la que tenemos ahora
                // se reemplazaran
                if(contadorVocales > contadorMaxVocales) {
                    contadorMaxVocales = contadorVocales;
                    palabraMasVocales = palabras[i];
                }
            }
            
            /**
             * Si palabraMasVocales es vacia entonces 
             * ninguna de las palabras introducidas contiene una vocal
             */
            if(palabraMasVocales.equals("")) {
                System.out.println("NO se encuentran palabras con vocales.");
            } else {
                System.out.println("La palabra con mas vocales es " + palabraMasVocales);
            }
        } while(true);
    }
    
    /**
     * El metodo se dedica a contar las vocales de una palabra.
     * 
     * @param palabra La palabra cuyos vocales hay que contar
     * @return La cantidad de vocales que contiene la palabra
     */
    public static int contarVocales(String palabra) {
        // El contador de vocales
        int contador = 0;
        
        // Un vector que contenga todas la vocales
        char[] vocales = {'a', 'o', 'u', 'e', 'i'};
        
        /**
         * Recorremos los caracteres de la palabra y comprobamos si es una vocal o no .
         * Si se trata de una vocal aumentamos el contador con 1.
         */
        for (int i = 0; i < palabra.length(); i++) {
            if(buscarCaracterEnVector(vocales, palabra.charAt(i))){
                contador++;
            }
        }
        
        return contador;
    }
    
    /**
     * Comprueba si un caracter dado esta dentro de un array de caracteres.
     * 
     * @param vector El array en el cual buscaremos el caracter 
     * @param caracter El caracter que hay que buscar
     * @return TRUE si el caracter esta y FALSE en caso contrario
     */
    public static boolean buscarCaracterEnVector(char[] vector, char caracter) {
        for (int i = 0; i < vector.length; i++) {
            if(Character.toLowerCase(vector[i]) == Character.toLowerCase(caracter)) {
                return true;
            }
        }
        
        return false;
    }
}
