package EjercicionsTema04;

import java.util.Scanner;

/**
 * Calcula el power de un numero.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _03_Pow {

    private static Scanner scan = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Lee dos numeros reales del terminal.
         * Uno para indicar la base y otro para indicar el
         * exponente.
         */
        double base = leerDoubleDelTerminal("Base: ", 50);
        double exp = leerDoubleDelTerminal("Exponente: ", 10);
        
        /**
         * Calcula el power de un numero.
         * Ya que Java nos proporciona un metodo
         * lo utilizamos.
         */
        System.out.println("Resultado: " + Math.pow(base, exp));
    }
    
    public static double leerDoubleDelTerminal(String textoAMostrar, double maximo) {
        double numero = 0;
        
        scan = new Scanner(System.in);
        
        do {
            System.out.print(textoAMostrar); 
            numero = Double.parseDouble(scan.nextLine());
        } while(maximo < numero);

        
        return numero;
    }
}
