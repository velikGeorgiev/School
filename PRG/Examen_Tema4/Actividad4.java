package Examen_T4_VelikGeorgiev;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class Actividad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] cadenaEjemplos = {"Ana", "Anna", "test", "blabla", "ama", "RadAr"};

        // La primera version
        System.out.println("==== Version 1 ====");
        for (String cadena : cadenaEjemplos) {
            if (esPalendorma(cadena)) {
                System.out.println("La palabra " + cadena + " es palindroma");
            } else {
                System.out.println("La palabra " + cadena + " no es palindroma");
            }
        }
        
        // La segunda version
        System.out.println("\n\n==== Version 2 ====\n\n");
        for (String cadena : cadenaEjemplos) {
            if (esPalindromo(cadena)) {
                System.out.println("La palabra " + cadena + " es palindroma");
            } else {
                System.out.println("La palabra " + cadena + " no es palindroma");
            }
        }
    }

    /**
     * Comprueba si una palabra es palindroma o no.
     *
     * @param palabra La palbra que hay que comprobar
     * @return TRUE si es palindroma y FALSE en caso contrario
     */
    public static boolean esPalindromo(String palabra) {
        // Invertimos la palabra
        String palabraInvertida = invertir(palabra);

        // Comprobamos si la palabra invertida y la palabra original son iguales
        if (palabraInvertida.toLowerCase().equals(palabra.toLowerCase())) {
            return true;
        }

        return false;
    }

    /**
     * Invierte una palabra.
     *
     * @param palabra La palabra a invertir
     * @return La palabra invertida
     */
    public static String invertir(String palabra) {
        return invertir(palabra, 0);
    }

    /**
     * Invierte una palabra.
     *
     * @param palabra La palabra a invertir
     * @param index El caracter actual
     * @return La palabra invertida
     */
    private static String invertir(String palabra, int index) {
        if (index >= palabra.length() - 1) {
            return String.valueOf(palabra.charAt(palabra.length() - 1));
        }

        return invertir(palabra, index + 1) + palabra.charAt(index);
    }

    /**
     * Comprueba si una palabra es palindroma o no.
     * A diferencia del otro metodo en este todo ocurre en el.
     * No se invierte la palabra si no se comprueba si la letra actual
     * es la misma con la otra de atras ... :D 
     * 
     * En Radar por ejemplo
     * Primero se comprobara si R == r si a == a y la letra "d" es la base de 
     * la recursion que es TRUE.
     * 
     * En caso de que la palabra es Anna
     * A == a
     * n == n
     * 
     * Como el siguiente Index no es valido ( vacio ) devolvemos TRUE con que esto es la base
     * 
     * @param palabra La palbra que hay que comprobar
     * @return TRUE si es palindroma y FALSE en caso contrario
     */
    public static boolean esPalendorma(String palabra) {
        return esPalendorma(palabra, 0);
    }
    
    
    /**
     * Comprueba si una palabra es palindroma o no.
     * A diferencia del otro metodo en este todo ocurre en el.
     * No se invierte la palabra si no se comprueba si la letra actual
     * es la misma con la otra de atras ... :D 
     * 
     * En Radar por ejemplo
     * Primero se comprobara si R == r si a == a y la letra "d" es la base de 
     * la recursion que es TRUE.
     * 
     * En caso de que la palabra es Anna
     * A == a
     * n == n
     * 
     * Como el siguiente Index no es valido ( vacio ) devolvemos TRUE con que esto es la base
     * 
     * @param palabra La palbra que hay que comprobar
     * @param index letra actual
     * @return TRUE si es palindroma y FALSE en caso contrario
     */
    private static boolean esPalendorma(String palabra, int index) {
        if ((index == (palabra.length() - 1 - index)) ||
            index < 0 || index >= palabra.length()) {
            return true;
        }

        return ((Character.toLowerCase(palabra.charAt(index)) == Character.toLowerCase(palabra.charAt(palabra.length() - 1 - index))) && esPalendorma(palabra, index + 1));
    }
}
