package Examen_Tema3_VelikGeorgiev;

import java.util.Scanner;

/**
 *
 * @author  Georgiev Chelebiev //Te parecerá bonito apropiarte de mi trabajo D: //A no!! que este es el tuyo XD
 */
public class Ejercicio1_VelikGeorgiev {

    private static final int CANTIDAD_ENTRADAS = 2;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        int[] numeros = new int[CANTIDAD_ENTRADAS];
        
        /**
         * Leemos los valores introducidos por el usuario.
         */
        try(Scanner scan = new Scanner(System.in)){
            for(int i = 0; i < CANTIDAD_ENTRADAS; i++) {
                try {
                    System.out.print("Introduzca un numero " + (i + 1) + "/" + CANTIDAD_ENTRADAS + ": ");
                    numeros[i] = Integer.parseInt(scan.nextLine());
                } catch(Exception ex) {
                    System.out.println("*** El valor introducido no es valido. ***");
                    i--;
                }
            }
        }
        
        System.out.println("\nMostrando numeros que empiezen por 2 y terminen en 2,4 o 6\n");
        
        for(int num: numeros) {
            /**
             * Convertimos el numero en cadena de caracteres
             * para poder trabajar mas facilmente y con menos
             * interacciones, bocles etc.
             */
            String numeroCadena = String.valueOf(num);
            
            /**
             * En primer caracter de la cadena sera el primer digito del numero.
             */
            char primerNumero = numeroCadena.charAt(0);
            
            /**
             * El ultimo caracter de la cadena sera el ultimo digito del numero.
             */
            char ultimoNumero = numeroCadena.charAt(numeroCadena.length() - 1);
            
            /**
             * Comprobamos si el numero introducido cumple las 
             * condiciones deseadas.
             * Si las cumple lo imprimimos, en caso contrario pasamos al siguiente.
             */
            if(primerNumero == '2' && (ultimoNumero == '2' || ultimoNumero == '4' || ultimoNumero == '6')) {
                System.out.println(num);
            }
        }
    }
}
