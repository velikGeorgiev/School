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
        
        System.out.println("Introduce dos numeros separados por coma:");
        // Separamos los numeros por coma introducidos por el usuario y los guardamos en un vector
        String[] sequenciaDeNumeros = scan.nextLine().split(",");
        
        System.out.println("El orden de los numeros es " + ordenDeNumeros(sequenciaDeNumeros));
    }
    
    /**
     * Comprueba si dos numeros son ordenados en orden ascendente o descendente.
     * 
     * @param numeros Los dos numeros en un vector ( el vector no puede tener una capacidad diferente a 2)
     * @return Una cadena con el orden de los numeros o si son iguales devuelve "Iguales"
     */
    public static String ordenDeNumeros(String[] numeros) {
        if(numeros.length != 2) {
            return "*** Error ***";
        }
            
        if(Integer.parseInt(numeros[0]) < Integer.parseInt(numeros[1])) {
            return "Ascendente";
        } else if (Integer.parseInt(numeros[0]) > Integer.parseInt(numeros[1])) {
            return "Descendente";
        }
        
        return "Iguales";
    }
}
