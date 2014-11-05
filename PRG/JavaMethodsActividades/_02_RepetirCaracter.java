package EjercicionsTema04;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _02_RepetirCaracter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Caracter: ");
        char caracter = scan.nextLine().charAt(0);
        
        System.out.print("Repetir: ");
        int repetir = Integer.parseInt(scan.nextLine());
        
        System.out.println(repetirCaracter(caracter, repetir));
    }

    public static String repetirCaracter(char caracter, int repetir) {
        StringBuilder resultado = new StringBuilder(repetir);
        
        for(int i = 0; i < repetir; i++) {
            resultado.append(caracter);
        }
        
        return resultado.toString();
    }
}
