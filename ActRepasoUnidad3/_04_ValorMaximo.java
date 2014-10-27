import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _04_ValorMaximo {

    /**
     * El numero de entradas que tendra que introducir el usuario.
     */
    private static final int CANTIDAD_ENTRADAS = 3;

    /**
     * @param args Los argumentos pasados por el terminal
     */
    public static void main(String[] args) {
        /**
         * Definimos un vector que almacenara las entradas del usuario
         */
        double[] vectorDeNumeros = new double[CANTIDAD_ENTRADAS];

        /**
         * El numero mas alto introducido. Este numero ira cambiando dentro de
         * un bucle. Le asignamos el valor minimo de un double como valor inicial.
         */
        double maxNumber = Double.MIN_VALUE;

        /**
         * La posicion del numero mas grande. Ira cambiando en el bucle.
         */
        int posicion = 0;

        /**
         * Leemos las entradas del usuario.
         */
        try (Scanner scan = new Scanner(System.in)) {
            for (int i = 0; i < CANTIDAD_ENTRADAS; i++) {
                try {
                    System.out.print("Introduce un numero " + (i + 1) + "/" + CANTIDAD_ENTRADAS + ": ");
                    vectorDeNumeros[i] = Double.parseDouble(scan.nextLine());
                } catch (Exception ex) {
                    // Si el valor introducido no es valido imprimimos un mensaje de error
                    // y le volvemos a pedir que introduzca un numero.
                    System.out.println("*** El valor introducido no es valido ***");
                    i--;
                }

                // Si el numero introducido es mas grande que el actual
                // cambiamos el valor de la posicion
                if (vectorDeNumeros[i] > maxNumber) {
                    maxNumber = vectorDeNumeros[i];
                    posicion = i;
                }
            }
        }

        // Imprimimos el valor mas alto y su posicion
        System.out.println("El valor mas alto introducido es: "
                            + vectorDeNumeros[posicion] 
                            + " en la posicion " + posicion);
    }
}
