
package javaexercises3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _19_NamesByLetterGrowthArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nameList = new String[5];
        int currentName = 0;
        String inputName, keyWord = "";
        
        do {
            // Leer el nombre
            System.out.print("Nombre: ");
            inputName = scan.nextLine().trim();
                
            // Si el nombre esta vacion salimos del bucle 
            // y continuamos con el programa
            if(inputName.equals("")) {
                break;
            }
            
            // ASEGURAR CAPACIDAD
            // Comprobamos si el array es lo suficientemente
            // grande. Si no lo ampliamos. Ampliamos el tamaño actual por 2.
            if(currentName >= nameList.length - 1) {
                nameList = Arrays.copyOf(nameList, nameList.length << 1);
            }
            
            // Agregamos el nombre al array
            nameList[currentName++] = inputName;
        } while(true);
        
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
                
                // Si llegamos un elemento nulo interumpimos el bucle 
                // ya que es el ultimo elemento
                if(name == null) {
                    break;
                }
                
                // Si el primer caracter en las dos cadenas 
                // es el mismo imprimimos el nombre
                if(name.charAt(0) == keyWord.charAt(0)) {
                    System.out.println("--> [" + name + "]");
                }
            }
        } while (true);
    }
}
