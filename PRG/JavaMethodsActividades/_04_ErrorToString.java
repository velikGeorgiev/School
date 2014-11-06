package EjercicionsTema04;

import java.util.Scanner;

/**
 * El programa muestra la descripcion del errir de un codigo numerico.
 * 
 * @author Velik Georgiev Chelebiev
 */
public class _04_ErrorToString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Leemos el codigo del error
        System.out.print("Codigo error: ");
        int error = Integer.parseInt(scan.nextLine());
        
        /**
         * Cogemos su respectivo valor.
         */
        String errorCadena = errorCadena(error);
        
        // Imprimimos la descripcion del error en el terminal del usuario
        System.out.println(errorCadena);
    }
    
    /**
     * Devuelve la descripcion del un codigo numerico que representa un error.
     * 
     * OJO: Una forma recomendable de hacer esto es el uso de Diccionarios como HashMap.
     * 
     * @param error El codigo numerico del error
     * @return Devuelve la descripcion del un codigo numerico que representa un error.
     * @see HashMap
     */
    public static String errorCadena(int error) {
        switch(error) {
            case 1: return "Error en memoria";
            case 2: return "Papel atascado en impresora";
            case 3: return "Disco defectuoso";
        }
        
        // Si el codigo no existe se devolvera "Error indefinido"
        return "Error indefinido";
    }
}
