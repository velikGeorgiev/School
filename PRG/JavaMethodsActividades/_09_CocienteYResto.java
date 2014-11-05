
package JavaMethodExample;

import java.util.Scanner;

/**
 * El programa lee 2 numeros introducidos por el usuario y mustra
 * el cociente y el resto producidos por la division de ambos.
 * 
 * El segundo numero introducido ha de ser mayor que el primero.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _09_CocienteYResto {

    public static Scanner scan = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Los numeros indtroducidos por el usuario
        int[] numeros = new int[2];
        
        /**
         * Leemos 2 numeros.
         * El bucle se repetira hasta que el segundo sea mayor que el primero
         */
        do {
            numeros[0] = leerEnteroDelTerminal("Introduce el primer numero: ");
            numeros[1] = leerEnteroDelTerminal("Introduce el segundo numero: ");
        }while(numeros[1] < numeros[0]);
        
        /**
         * Calculamos el cociente y el resto de los dos numeros introducidos.
         */
        int cociente = calcularCociente(numeros[0], numeros[1]);
        int resto = calcularResto(numeros[0], numeros[1]);
        
        // Imprimimos por pantalla el resultado
        System.out.printf("Cociente: %d\nResto: %d\n", cociente, resto);
    }
    
    /**
     * Calcula el resto de dos numeros enteros.
     * 
     * @param numA El primer numero
     * @param numB El segundo numero
     * @return El resto de la division de los dos numeros indiacados
     */
    public static int calcularResto(int numA, int numB) {
        return (numA % numB);
    }
    
    /**
     * Calcula el cociente de dos numeros enteros.
     * 
     * @param numA El primer numero
     * @param numB El segundo numero
     * @return El cociente de la division de los dos numeros indiacados
     */
    public static int calcularCociente(int numA, int numB) {
        return (numA / numB);
    }
    
    /**
     * Lee un numero entero introducido por el usuario en el terminal.
     * 
     * @param textoAMostrar Texto que se mostrar al usuario para indicarle que datos tiene que introducir
     * @return El numero introducido por el usuario
     */
    public static int leerEnteroDelTerminal(String textoAMostrar) {
        /**
         * Si la variable scan no esta inicializada, la inicializamos.
         */
        if(scan == null) {
            scan = new Scanner(System.in);
        }
        
        int entradaUsuario = 0;
        
        try {
            System.out.print(textoAMostrar);
            entradaUsuario = Integer.parseInt(scan.nextLine());
        } catch(Exception ex ) { };
        
        return entradaUsuario;
    }
}
