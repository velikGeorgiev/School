
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _17_NameExists {

    /** Cantidad de nombres **/
    private final static int TOTAL_NAMES = 10;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = new String[TOTAL_NAMES];
        String keyWord = "";
        boolean found = false; // Si el nombre es encontrado True en caso contrario False
        
        // Leer los 10 nombres
        for(int i = 0; i < TOTAL_NAMES; i++) {
            System.out.print("Nombre (" + (i + 1) + "): ");
            names[i] = scan.nextLine().trim();
        }
        
        do {
            // Leer el nombre que hay que buscar.
            System.out.print("Buscar: ");
            keyWord = scan.nextLine().trim();
            
            // Si la palabra es FIN interumpimos el bucle
            if(keyWord.equalsIgnoreCase("fin")) {
                break;
            }
            
            // Buscar el nombre en la matriz
            for(String currentName : names) {
                if(currentName.equalsIgnoreCase(keyWord)) {
                    found = true;
                    break;
                }
            }
            
            // Mostramos si el nombre esta en la lista o no 
            if(found == true) {
                System.out.println("Encontrado.");
                found = false; // Valor inicial
            } else {
                System.out.println("No encontrado.");
            }
        } while(true);
    }

}
