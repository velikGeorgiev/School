package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _19_StringBuffer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer().append("|");
        Scanner scan = new Scanner(System.in);
        
        do {
            System.out.print("Nombre: ");
            String nombre = scan.nextLine();
            
            if(nombre.equals("fin")){    
                break;
            }
            
            sb.append(nombre + "|");
            
        } while(true);
        
        String resultado = sb.toString().toLowerCase();
        String buscar = "";
        System.out.println(sb.toString());
        
        do {
            System.out.print("Buscar: ");
            buscar = scan.nextLine();
            
            if(buscar.equalsIgnoreCase("fin")) {
                break;
            }
            
            if(resultado.indexOf("|" + buscar + "|") > -1) {
                System.out.println("Encontrado");
            } else {
                System.out.println("No encontrado");
            }
        } while(true);
    }

}
