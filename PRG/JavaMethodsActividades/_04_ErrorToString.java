package EjercicionsTema04;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _04_ErrorToString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Codigo error: ");
        int error = Integer.parseInt(scan.nextLine());
        String errorCadena = errorCadena(error);
        
        System.out.println(errorCadena);
    }
    
    public static String errorCadena(int error) {
        switch(error) {
            case 1: return "Error en memoria";
            case 2: return "Papel atascado en impresora";
            case 3: return "Disco defectuoso";
        }
        
        return "Error indefinido";
    }
}
