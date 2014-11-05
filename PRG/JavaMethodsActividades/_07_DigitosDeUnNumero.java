package JavaMethodExample;

import java.util.Scanner;

/**
 * Programa que muestra los digitos por
 * los que esta compuesto un numero.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _07_DigitosDeUnNumero {
    /**
     * En este vector se gurdaran los numeros en su
     * forma textual.
     */
    public static String[] numerosEnCadena;
    
    /**
     * Numero minimo valido
     */
    public static final int NUMERO_MINIMO = 9999;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Numero introducido por el usuario
        int numero = Integer.MIN_VALUE;
        
        Scanner scan = new Scanner(System.in);
        
        /**
         * Lee un numero introducido por el usuario.
         * El bucle se ira repetiendo mientras que el numero es menor que NUMERO_MINIMO
         */
        do {
            System.out.print("Numero: ");
            numero = Integer.parseInt(scan.nextLine());
        } while(numero < NUMERO_MINIMO);
        
        /**
         * Coger los digitos por los que esta compuesto el numero.
         */
        int[] digitos = separarNumeroEnDigitos(numero);

        /**
         * Imprimir los digitos en forma numerica y en cadena
         */
        for (int dig : digitos) {
            System.out.printf("(%d) %s\n", dig, convertirNumeroEnCadena(dig));
        }
    }

    /**
     * Separa un numero en los digitos que lo componen.
     * 
     * @param numero El numero que deseamos descomponer
     * @return Un vector. Cada elemento contiene un digito del numero
     */
    public static int[] separarNumeroEnDigitos(int numero) {
        // Convertimos el numero en cadena. Esta cadena la definimos como
        // final para asegurarnos de que no sera deteriorada posteriormente.
        final String numeroEnFormaDeCadena = String.valueOf(numero);
        
        // Vector en el cual gurdaremos un digito por posicion
        // El vector tiene el tamaño del numero de digitos por los
        // que esta compuesto el numero.
        int[] resultado = new int[numeroEnFormaDeCadena.length()];

        /**
         * Convertimos los caracteres de la cadena en digitos
         * y los asignamos al vector.
         */
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = Character.getNumericValue(numeroEnFormaDeCadena.charAt(i));
        }

        return resultado;
    }

    /**
     * Convierte un digito en cadena.
     * 
     * @param digito El digito cuyo valor sera convertido en un texto
     * @return El digito en forma de texto
     */
    public static String convertirNumeroEnCadena(int digito) {
        /**
         * Para no asignar cada vez los valores del array
         * hemos definido el vector "numerosEnCadena" como global, por lo 
         * tanto sera necesario asignarle los valores tan solo 1 vez.
         */
        if (numerosEnCadena == null) {
            numerosEnCadena = new String[]{"Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve"};
        }

        // Si el digito esta fuera del vector devolvemos un valor vacio
        if (digito < 0 || digito > numerosEnCadena.length) {
            return "";
        }
            
        // Devolvemos la forma textual del digito.
        return numerosEnCadena[digito];
    }
}
