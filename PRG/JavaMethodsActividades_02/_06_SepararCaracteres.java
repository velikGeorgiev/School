package EjercicionsTema04_02;

import java.util.Scanner;


/**
 * Separa los caracteres de una cadena introducida por el usuario
 * en nuevas lineas.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _06_SepararCaracteres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leemos la entrada del terminal
        System.out.print("Introduce una palabra o texto: ");
        String entradaUsuario = scan.nextLine();

        // Separamos los caracteres
        String entradaConCaracteresSeparados = separarCaracteres(entradaUsuario, "\n");

        // Imprimimos el resultado
        System.out.println(entradaConCaracteresSeparados);
    }

    /**
     * El metodo introduce una cadena entre cada caracter de la cadena indicada.
     *
     * @param str La cadena en la que se agregara la nueva cadena entre cada caracter
     * @param separador la cadena a agregar
     * @return La cadena modificada
     */
    public static String separarCaracteres(String str, String separador) {
        StringBuilder texto = new StringBuilder(str.length());
        
        /**
         * Agregamos el separador despues de cada caracter.
         */
        for (int i = 0; i < str.length(); i++) {
            texto.append(str.charAt(i));
            texto.append(separador);
        }

        return texto.toString();
    }
}
