package EjercicionsTema04;

import java.util.Scanner;

/**
 * Lee un numero entero y un caracter del terminal introducidos por el usuario.
 * Repite el caracter tantas veces como se le indico.
 * 
 * @author velko
 */
public class _02_RepetirCaracter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Leemos el caracter que deseamos repetir
        System.out.print("Caracter: ");
        char caracter = scan.nextLine().charAt(0);
        
        // Leemos un numero entero que indicara las veces que se debe de
        // repetir el caracter.
        System.out.print("Repetir: ");
        int repetir = Integer.parseInt(scan.nextLine());
        
        // Imprimimos el caracter tantas veces como se indico en la 
        // pantalla del usuario.
        System.out.println(repetirCaracter(caracter, repetir));
    }

    /**
     * Repite un caracter una serie de veces (indicada).
     * 
     * @param caracter El caracter a repetir
     * @param repetir Cuantas veces se tiene que repetir el caracter
     * @return Una cadena con el caracter repatido las veces indicadas
     */
    public static String repetirCaracter(char caracter, int repetir) {
        StringBuilder resultado = new StringBuilder(repetir);
        
        for(int i = 0; i < repetir; i++) {
            resultado.append(caracter);
        }
        
        return resultado.toString();
    }
}
