package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _20_MenuImplementation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] options = {"saludar", "salir"};
        String selectedOption = "";
        
        do {
            /**
             * Mostrar las opciones
             */            
            for(String opt: options){
                System.out.println("> " + opt);
            }
            
            // Leemos la opcion deseada
            System.out.print("Opcion: ");
            selectedOption = scan.nextLine().trim();
            
            /**
             * Acciones de las opciones
             */
            switch(selectedOption) {
                case "saludar":
                    System.out.println("Hola!");
                    break;
                case "salir": break;
                default: 
                    System.out.println("Opcion no encontrada.");
            }
        } while (!selectedOption.equalsIgnoreCase("salir"));
    }
}
