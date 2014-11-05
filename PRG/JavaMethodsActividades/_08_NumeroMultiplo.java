
package JavaMethodExample;

import java.util.Scanner;

/**
 * El programa comprueba si una serie de numeros introducidos
 * por el usuario en el terminal son multiplos de un numero divisor 
 * indicando al final el numero total de numeros multiplos introducidos.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _08_NumeroMultiplo {

    public static final int NUMERO_DIVISOR = 5;
    
    public static final int NUMERO_ENTRADAS = 10;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int entradas = 0; // Contador de entradas realizadas por el usuario
        int entradaUsuario = 0; // Valor introducido por el usuario en el terminal
        int totalNumerosMultiplos = 0; // Contador de los numeros multiplos introducidos
        Scanner scan = new Scanner(System.in);
        
        /**
         * Leemos una serie de numeros y comprobamos si son
         * multiplos del divisor indicado.
         */
        do {
            System.out.print("Introduce un numero: ");
            entradaUsuario = Integer.parseInt(scan.nextLine());
            
            if(esMultiplo(entradaUsuario)) {
                System.out.printf("El numero %d es multiplo de %d\n", entradaUsuario, NUMERO_DIVISOR);
                
                // Si el numero es multiplo entonces incrementamos el valor del contador.
                totalNumerosMultiplos++;
            }
            
        } while (++entradas < NUMERO_ENTRADAS);
        
        // Imprimimos el total de los numeros multiplos introducidos
        System.out.println("Total numeros multiplos de 5 introducidos: " + totalNumerosMultiplos);
    }

    /**
     * Comprueba si un numero es multiplo de otro.
     * 
     * @param numero Numero a comprobar si es multiplo del divisor indicado
     * @return Si el numero es multiplo del divisor indicado devolvera true, en caso contrario devolvera false
     */
    public static boolean esMultiplo(int numero) {
        return ((numero % NUMERO_DIVISOR) == 0);
    }
}
