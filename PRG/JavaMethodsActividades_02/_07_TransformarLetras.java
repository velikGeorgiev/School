package EjercicionsTema04_02;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _07_TransformarLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Leemos la entrada del usuario
        System.out.print("Introduce una cadena: ");
        String entradaUsuario = scan.nextLine();

        // Invertimos todas las letras de la cadena,
        // es decir, las letras mayuscula en minusculas y viceversa
        String caracteresInvertidos = invertirCaracteres(entradaUsuario);
        
        // Calculamos la diferencia entre la cadena introducida y la cadena
        // invertida para saber cuantos caracteres se han cambiado
        int diferencia = diferenciaEntreCadenas(entradaUsuario, caracteresInvertidos);
        
        // Imprimimos el resultado
        System.out.println("Nueva cadena: " + caracteresInvertidos + "\nCambios realizados: " + diferencia);
    }

    /**
     * Invierte todas las letras latinas.
     * Convierte la letras mayusculas en minusculas y viceversa.
     * 
     * @param str La cadena cuyos caracteres seran invertidos
     * @return La cadena invertida 
     */
    public static String invertirCaracteres(String str) {
        StringBuilder resultado = new StringBuilder(str.length());

        for (int i = 0; i < str.length(); i++) {
            char caracter = str.charAt(i);
            
            if (caracter >= 'a' && caracter <= 'z') {
                resultado.append((char)(caracter - 32));
            } else if (caracter >= 'A' && caracter <= 'Z') {
                resultado.append((char)(caracter + 32));
            } else {
                resultado.append(caracter);
            }
        }
        
        return resultado.toString();
    }
    
    /**
     * Calcula la diferencia entre dos cadenas de caracteres.
     * Por 1 diferencia se entiende dos caracteres a la misma posicion
     * que no son lexicamente iguales.
     * 
     * @param strOriginal El primera cadena 
     * @param str La segunda cadena
     * @return El numero de diferencias que existe entre anbas cadenas.
     */
    public static int diferenciaEntreCadenas(String strOriginal, String str) {
        // Cogemos el tamaño de la cadena mas corta 
        // de esta forma nos aseguramos de que no nos vamos a salir de los
        // limites si alguna es mas larga que la otra.
        int cadenaMasCorta = (strOriginal.length() < str.length()) ? strOriginal.length() : str.length();
        
        // Si el tamaño de las cadenas es distinto todas las letras
        // de la cadena mas larga son automaticamente contados como una diferencia.
        // Por ejemplo las cadenas: 
        // "Hola" y "Hola!!!" Tendras 3 diferencias automaticamente.
        int diferencia = Math.abs(strOriginal.length() - str.length());
        
        /**
         * Comprobamos si los caracteres de la misma posicion
         * de ambas cadenas coinciden. Si no es asi
         * incrementamos la diferencia con 1.
         */
        for(int i = 0; i < cadenaMasCorta; i++) {
            if(strOriginal.charAt(i) != str.charAt(i)) {
                diferencia++;
            }
        }
        
        return diferencia;
    }
}
