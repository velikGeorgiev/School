package EjercicionsTema04_02;

import java.util.Scanner;

/**
 * El programa comprueba si en una cadena introducida por el
 * usuario en el terminal contiene un numero entero (sea positivo o negativo)
 * 
 * @author Velik Georgiev Chelebiev
 */
public class _04_ComprobarEntero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Leemos una cadena de texto introducida por el usuario
        System.out.print("Introduce una cadena de texto: ");
        String entradaUsuario = scan.nextLine();
        
        if (contieneNumero(entradaUsuario)) {
            System.out.println("La cadena contiene numero.");
        } else {
            System.out.println("La cadena NO contiene numero.");
        }
    }

    /**
     * Comprueba si una cadena de texto contiente algun numero.
     * 
     * @param str La cadena a comprobar
     * @return True si contiene numero y False en caso contrario.
     */
    public static boolean contieneNumero(String str) {
        int numeroCaracter = -1;
        
        while(++numeroCaracter < str.length()) {
            char caracter = str.charAt(numeroCaracter);
            
            if(Character.isDigit(caracter)) {
                return true;
            }
        }
        
        return false;
    }
}
