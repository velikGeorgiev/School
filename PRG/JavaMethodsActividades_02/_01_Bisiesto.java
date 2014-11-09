package EjercicionsTema04_02;

import java.util.Scanner;

/**
 * El programa comprueba si un año es bisiesto o no.
 * Imprime el resultado por la pantalla del terminal.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _01_Bisiesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // El año introducido por el usuario
        System.out.print("Introduce un año: ");
        int year = Integer.parseInt(scan.nextLine());
        
        // Comprobamos si es bisiesto e imprimimos en el terminal
        if(esBisiesto(year)) {
            System.out.println("El año " + year + " es bisiesto");
        } else {
            System.out.println("El año " + year + " NO es bisiesto");
        }
    }
    
    public static boolean esBisiesto(int year) {
        return ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
    } 
}
