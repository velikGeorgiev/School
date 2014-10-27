package unitOneFinal;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _01_NumeroMasCercano {

    /**
     * El numero de entradas que tendra que introducir el usuario.
     */
    private static final int CANTIDAD_ENTRADAS = 5;

    /**
     * @param args Los argumentos pasados por el terminal
     */
    public static void main(String[] args) {
        /**
         * Definimos un vector que almacenara las entradas del usuario
         */
        int[] vectorDeNumeros = new int[CANTIDAD_ENTRADAS];

        /**
         * Distancia entre los dos numeros. Se guardara el resultado absoluto de
         * su resta. Como valor inicial se le asigna el numero entero mas grande
         * posible.
         */
        int distancia = Integer.MAX_VALUE;

        /**
         * En esta variable se guardara el numero mas cercano. Esta variable
         * puede ser actualizada en cada interacion del bucle.
         */
        int numeroMasCercano = 0;

        /**
         * Leemos los numeros
         */
        try (Scanner scan = new Scanner(System.in)) {
            for (int i = 0; i < CANTIDAD_ENTRADAS; i++) {
                try {
                    System.out.print("Introduce un numero " + (i + 1) + "/" + CANTIDAD_ENTRADAS + ": ");
                    vectorDeNumeros[i] = Integer.parseInt(scan.nextLine());
                } catch (Exception ex) {
                    // Si el valor introducido no es valido imprimimos un mensaje de error
                    // y le volvemos a pedir que introduzca un numero.
                    System.out.println("*** El valor introducido no es valido ***");
                    i--;
                }
            }
        }
        
        /**
         * Guardamos el primer numero introducido en una variable para poder
         * comparar con mas facilidad y claridad.
         */
        int numero = vectorDeNumeros[0];

        /**
         * Buscando el numero mas cercano al primero. Pasando por cada uno de
         * los numeros introducidos comprobamos su distancia (la resta) del
         * primer numero.
         */
        for (int i = 1; i < vectorDeNumeros.length; i++) {
            int distanciaActual = Math.abs(numero - vectorDeNumeros[i]);

            if (distanciaActual < distancia) {
                distancia = distanciaActual;
                numeroMasCercano = vectorDeNumeros[i];
            }
        }

        /**
         * Imprime el resultado del programa
         */
        System.out.println("El numero mas cercano al " + numero + " es " + numeroMasCercano + " con una distancia de " + distancia);
    }
}
