package Examen_Tema3_VelikGeorgiev;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class Ejercicio3_VelikGeorgiev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /**
         * El numero total de entradas introducidas por el usuario.
         */
        int totalEntradas = 0;
        
        /**
         * Entrada actual del usuario.
         */
        int entradaUsuario = 0;
        
        /**
         * Un vector que guardara temporalmente las dos ultimas entradas
         * introducidas por el usuario.
         */
        int[] entradasTemporales = new int[2];
        
        /**
         * La resta de las dos ultimas entradas.
         */
        int resta = 0; 
        
        do {
            try {
                entradaUsuario = Integer.parseInt(scan.nextLine());
            } catch(Exception ex) {
                System.out.println("*** Valor no valido ***");
                continue;
            }
            
            /**
             * Calculamos la resta de los dos numeros anteriores
             */
            if(totalEntradas >= 1) {
                if(totalEntradas % 2 == 1){
                    resta = entradasTemporales[1] - entradasTemporales[0];
                }else {
                    resta = entradasTemporales[0] - entradasTemporales[1];
                }
            }
            
            /**
             * Si la cantidad de entradas en mayor a 2 ( es decir ya tenemos una resta )
             * comprobamos si la resta de los dos numeros anteriores es menor que el
             * numero introducido
             */
            if(totalEntradas >= 2) {
                if(entradaUsuario < resta) {
                    break;
                }
            }
            
            /**
             * Asignamos el numero a una variable temporal
             */
            if(totalEntradas % 2 == 0){
                entradasTemporales[0] = entradaUsuario;
            } else {
                entradasTemporales[1] = entradaUsuario;
            }
            
            // Aumentamos las entradas
            totalEntradas++;
        }while(true);
        
        /**
         * Imprimimos la salida del programa.
         */
        System.out.println("\n****************\n");
        System.out.println("Total entradas: " + (totalEntradas + 1));
        System.out.println("Valores que no cumplen la condicion: ");
        System.out.println("Valor 1: " + entradasTemporales[0]);
        System.out.println("Valor 2: " + entradasTemporales[1]);
        System.out.println("Valor 3: " + entradaUsuario);
    }
}
