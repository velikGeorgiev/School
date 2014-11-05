package EjercicionsTema04;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _01_NumerosOrden {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduce dos numeros separados por coma:");
        String[] sequenciaDeNumeros = scan.nextLine().split(",");
        
        System.out.println("El orden de los numeros es " + ordenDeNumeros(sequenciaDeNumeros));
    }
    
    public static String ordenDeNumeros(String[] numeros) {
        if(numeros.length > 2) {
            return "*** Error ***";
        }
            
        if(Integer.parseInt(numeros[0]) < Integer.parseInt(numeros[1])) {
            return "Ascendente";
        }
        
        return "Descendente";
    }
}
