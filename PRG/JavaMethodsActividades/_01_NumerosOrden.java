package EjercicionsTema04;

import java.util.Scanner;

/**
 * El programa indica si dos numeros definidos por el usuario ( mediante el terminal )
 * son en orden ascendente o descendente.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _01_NumerosOrden {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Introduce dos numeros separados por coma: ");
        // Separamos los numeros por coma introducidos por el usuario y los guardamos en un vector
        String[] sequenciaDeNumeros = scan.nextLine().split(",");
        
        int numA = Integer.parseInt(sequenciaDeNumeros[0]);
        int numB = Integer.parseInt(sequenciaDeNumeros[1]);
        
        System.out.println("El orden de los numeros es " + ordenDeNumeros(numA, numB));
    }
    
    /**
     * Comprueba si dos numeros son ordenados en orden ascendente o descendente.
     * 
     * @param numA El primer numero
     * @param numB El segundo numero
     * @return Una cadena con el orden de los numeros o si son iguales devuelve "Iguales"
     */
    public static String ordenDeNumeros(int numA, int numB) {            
        if(numA < numB) {
            return "Ascendente";
        } else if (numA > numB) {
            return "Descendente";
        }
        
        return "Iguales";
    }
}
