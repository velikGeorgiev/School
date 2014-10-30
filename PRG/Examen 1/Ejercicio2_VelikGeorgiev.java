package Examen_Tema3_VelikGeorgiev;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class Ejercicio2_VelikGeorgiev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        int entradaUsuario = -1;
        
        do {
            String[] opciones = { "Tabla del 3", "Tabla del 4", "Tabla del 5" };
            
            /**
             * Mostrando el menu de opciones.
             */
            System.out.println("TABLAS DE MULTIPLICAR");
            System.out.println("*********************************");
            
            for(int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ".- " + opciones[i]);
            }
            
            // Opcion de salir
            System.out.println("0.- Salir");
            
            // Leemos la entrada del usuario
            try {
                System.out.print("\nIntroduce opcion: ");
                entradaUsuario = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                System.out.println("*** Operacion no valida. ***");
            }
            
            // Si la entrada del usuario es 0 nos salimos del bucle y 
            // el programa termina
            if(entradaUsuario == 0) {
                break;
            }
            
            System.out.println("");
            
            switch(entradaUsuario) {
                case 1:
                    System.out.println("Tabla del 3");
                    for(int i = 1; i <= 10; i++) {
                        System.out.printf("%d * %d = %d\n", i, 3, (i * 3));
                    }
                break;
                    
                case 2:
                    System.out.println("Tabla del 4");
                    for(int i = 1; i <= 10; i++) {
                        System.out.printf("%d * %d = %d\n", i, 4, (i * 4));
                    }
                break;
                    
                case 3:
                    System.out.println("Tabla del 5");
                    for(int i = 1; i <= 10; i++) {
                        System.out.printf("%d * %d = %d\n", i, 5, (i * 5));
                    }
                break;
                    
                default: 
                    System.out.println("Opcion no valida.");
                    break;
            }
            
            System.out.println("");
            
        }while(true);
    }
}
