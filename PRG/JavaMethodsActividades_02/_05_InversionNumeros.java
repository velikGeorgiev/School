package EjercicionsTema04_02;

import java.util.Scanner;

/**
 * Invierte un numero introducidos por el usuario. 
 * 
 * @author Velik Georgiev Chelebiev
 */
public class _05_InversionNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Leemos el numero del usuario
        System.out.print("Introduce un numero: ");
        int entradaUsuario = Integer.parseInt(scan.nextLine());
        
        // Invertimos el numero
        int numeroInvertido = invertirNumero(entradaUsuario);
        
        // Imprimimos el numero invertido en pantalla
        System.out.println("El numero invertido: " + numeroInvertido);
    }

    /**
     * Invierte un numero.
     * Convierte el numero en cadena asignando lo como valor 
     * de un StringBuilder. Invertimos el StringBuilder y devolvemos
     * su valor parseado en integer.
     * 
     * @param numero El numero a invertir
     * @return  El numero invertido
     */
    public static int invertirNumero(int numero) {
        // Convertimos el numero en StringBuilder
        StringBuilder sbNumero = new StringBuilder(numero + "");
        
        // Invertimos los caracteres en el StringBuilder
        sbNumero.reverse();
        
        // Devolvemos el numero invertido
        return Integer.parseInt(sbNumero.toString());
    }
}
