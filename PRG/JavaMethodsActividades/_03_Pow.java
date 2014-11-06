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
    
    /**
     * Lee una cadena de texto introducida en el terminal por el usuario la parsea
     * convertiendo la en un DOUBLE.
     * 
     * El metodo seguira pediendo un numero al usuario hasta que ingrese un numero
     * menor que el indicado.
     *
     * @param textoAMostrar Texto que se mostrara al usuario para indicale que
     * le pedimos
     * @param maximo El numero maximo permitido
     * @return Devuelve el numero real ( double ) introducido por el usuario
     */
    public static double leerDoubleDelTerminal(String textoAMostrar, double maximo) {
        double numero = 0;
        
        scan = new Scanner(System.in);
        
        do {
            System.out.print(textoAMostrar); 
            numero = Double.parseDouble(scan.nextLine());
        } while(maximo < numero);

        
        return numero;
    }
    
    /**
     * El metodo calcula el resultado de elevar un numero a un exponente.
     * 
     * @param base La base numerica
     * @param exp El exponente
     * @return Resultado
     */
    public static int power(int base, int exp){
        int result = 1;
        
        for(int i = 0; i < exp; i++) {
            result *= base;
        }
        
        return result;
    }
}
