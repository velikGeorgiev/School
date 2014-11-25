package Examen_T4_VelikGeorgiev;

import java.util.Random;

/**
 *
 * @author  Velik Georgiev Chelebiev
 */
public class Actividad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numeros;
        
        // Imprimimos 5 series de 6 numeros aleatorios
        for (int i = 0; i < 5; i++) {
            numeros = selecciona_numeros(6, 49);
            ver_fila_numeros(numeros);
        }
    }
    
    /**
     * Genera un numero aleatorio.
     * Se le debe de indicar el numero maximo.
     * 
     * @param max El numero maximo a generar
     * @return Numero aleatorio generado
     */
    public static int numero_aleatorio(int max) {
        // Al numero maximo le sumamos 1 para que se incluye
        int numeroAleatorio = new Random().nextInt((max + 1));
        
        return numeroAleatorio;
    }
    
    /**
     * Comprueba si un numero esta dentro de un vector.
     * Si el numero esta devuelve TRUE en caso contrario FALSE.
     * 
     * @param num El numero que se buscara
     * @param arr El vector en el que buscaremos el numero
     * @return TRUE si el numero esta en el vector y FALSE en caso contrario
     */
    public static boolean esta_en_seleccion(int num, int[] arr) {        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Imprime los elementos de un vecotr en el terminal.
     * Los elementos se separan por un espacio
     * 
     * @param arr El vector cuyos elementos hay que imprimir
     */
    public static void ver_fila_numeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println("");
    }
    
    /**
     * Agrega un numero en un vector.
     * Ya que en la loteria el numero 0 no se utiliza ( el numero minimo es 1 ) 
     * y el valor iniciar de un elemento en un vector de tipo int es 0, consideramos
     * que el 0 significa elemento vacio ( se tiene que rellenar )
     * 
     * @param num El numero que queremos introducir
     * @param arr El vector en el cual lo queremos introducir
     * @return El vector modificado. 
     */
    public static int[] anadir_a_seleccion(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                arr[i] = num;
                
                // Interumpimos el bucle para no ingresar el numero 
                // en otras posiciones
                break;
            }
        }
        
        return arr;
    }
    
    /**
     * El metodo genera una serie de numeros aleatorios NO repetidos ( unicos ).
     * 
     * @param cant Cantidad de los numeros aleatorios que querremos generar
     * @param max El numero maximo que se pueda generar
     * @return Un vector que contendra los numeros generados
     */
    public static int[] selecciona_numeros(int cant, int max) {
        int[] arr = new int[cant];
        int numeroAleatorio;
        
        for(int i = 0; i < max; i++) {
            do {
                numeroAleatorio = numero_aleatorio(max);
            } while(esta_en_seleccion(numeroAleatorio, arr));
            
            anadir_a_seleccion(numeroAleatorio, arr);
        }
        
        return arr;
    }
}
