
package javaexercises3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _19_NamesByLetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String currentName, keyWord = "";
        StringBuilder names = new StringBuilder();
        String[] nameList;
        
        do {
            // Leer los nombres 
            System.out.print("Nombre: ");
            currentName = scan.nextLine().trim();
            
            // Si el nombre esta vacio creamos el vector con los nombres
            // e interumpimos el bucle.
            if(currentName.equals("")) {
                nameList = names.toString().split(",");
                break;
            }
            
            // Si no es el primer nombre agregamos una coma
            // para poder despues separar los nombres
            if(names.length() > 0) {
                names.append(',');
            }
            
            // Agregar el nombre a la lista
            names.append(currentName);
        } while (true);
        
        /**
         * Mostrar Nombres segun la primera letra
         */
        do {
            // Leer la letra
            System.out.print("Letra: ");
            keyWord = scan.nextLine().trim();
            
            // si la palabra introducida es FIN interumpimos el bucle y termina el programa
            if(keyWord.equalsIgnoreCase("fin")) {
                break;
            }
            
            // Buscar en la matriz
            for(String name: nameList) {
                // Si el primer caracter en las dos cadenas 
                // es el mismo imprimimos el nombre
                if(name.charAt(0) == keyWord.charAt(0)) {
                    System.out.println("--> [" + name + "]");
                }
            }
        } while (true);
    }
}

