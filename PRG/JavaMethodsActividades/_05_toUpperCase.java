package EjercicionsTema04;

import java.util.Scanner;

/**
 * Convierte un serie de letras latinas introducidas en el terminal
 * por el usuario en mayuscula hasta leer la letra -s- que es cuando
 * el programa terminara.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _05_toUpperCase {

    /**
     * Definimos scan como una variable global para no predefinirla cada vez que
     * pasamos por el bucle.
     */
    public static Scanner scan = null;

    /**
     * Inicio del programa.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // caracter introducido por el usuario
        char caracter;

        /**
         * Bucle que lee caracteres introducidos 
         * por el usuario en el terminal. 
         * 
         * El bucle se interumpe al introducir la letra 's'
         */
        do {
            // Leemos el caracter introducido por el usuario
            caracter = leerPrimerCaracterDelTerminal("Caracter: ");

            // Si el caracter es la letra -s- interumpimos el bucle y el programa termina
            if (caracter == 's') {
                break;
            }
            
            // Imprimimos la letra en mayuscula
            System.out.println(convertirEnMayuscula(caracter));
        } while (true);
    }

    /**
     * Lee un caracter (el primer caracter) del terminal.
     *
     * @param textoAMostrar Texto que se mostrara al usuario para indicale que
     * le pedimos
     * @return El primer caracter de la cadena introducida por el usuario.
     */
    public static char leerPrimerCaracterDelTerminal(String textoAMostrar) {
        /**
         * Leemos la linea entera introducida por el usuario.
         */
        String entradaUsuario = leerLineaDelTerminal(textoAMostrar);

        // Devolvemos solo el primer caracter de la cadena leida.
        return entradaUsuario.charAt(0);
    }

    /**
     * Lee una cadena de texto introducida en el terminal por el usuario y la
     * devuelve.
     *
     * @param textoAMostrar Texto que se mostrara al usuario para indicale que
     * le pedimos
     * @return Devuelve una cadena de texto introducida en el terminal por el
     * usuario
     */
    public static String leerLineaDelTerminal(String textoAMostrar) {
        /**
         * Mostramos el texto al usuario que le indicara que es lo que se le
         * pide.
         */
        System.out.print(textoAMostrar);

        // SI scan no se ha inicializado la inicializamos
        if (scan == null) {
            scan = new Scanner(System.in);
        }

        return scan.nextLine();
    }

    /**
     * Convierte una letra LATINA en mayuscula. Si la letra es mayuscula el
     * metodo no hace nada.
     *
     * Confiamos de que el caracter es una letra latina y no hacemos otras
     * validaciones.
     *
     * @param caracter El caracter que se desea convertir
     * @return El caracter en mayuscula
     */
    public static char convertirEnMayuscula(char caracter) {
        /**
         * Utilizaremos la mascara para poder realizar a nivel de bit convertir
         * un caracter de minuscula a mayuscula.
         *
         * Esto funcionara solo con letras latinas. No aconsajable en proyecto
         * comercial. Usar toUpperCase.
         *
         * Como se convierte la letra: 01000001 01100001 & 11011111 & 11011111
         * ----------- ------------ 01000001 01000001
         */
        int mascara = 0xDF; // o 2 elevado a 8 menos 32
        char nuevoCaracter = (char) (caracter & mascara);

        return nuevoCaracter;
    }
}
