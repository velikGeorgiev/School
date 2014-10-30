
package javaexercises3;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _19_NamesByLetterHashSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Utilizaremos HashSet ya que no quiero que los nombres en la lista 
        // se repitan. Si queremos que los nobres se repitan podemos reemplazar
        // el HashSet con ArrayList.
        // ArrayList<String> names = new ArrayList<String>();
        HashSet<String> names = new HashSet<>();
        String inputName; // Nombre Introducido
        
        String keyWord = ""; // letra por buscar
        
        // Leer los nombres y agregar los a la lista
        do {
            // Leer el nombre
            System.out.print("Nombre: ");
            inputName = scan.nextLine().trim();
                
            // Si el nombre esta vacion salimos del bucle 
            // y continuamos con el programa
            if(inputName.equals("")) {
                break;
            }
            
            // Agregamos el nombre al HashSet ( a la lista )
            names.add(inputName);            
        } while(true);
        
        /**
         * Mostrar los nombres segun su primera letra
         */
        do {
            // Leer la letra
            System.out.print("Letra: ");
            keyWord = scan.nextLine().trim();
            
            // Si la palabra introducida es FIN, terminamos el bucle
            // y nos salimos del programa
            if(keyWord.equalsIgnoreCase("fin")) {
                break;
            }
            
            // Buscamos y mostramos todos los nombres
            // que empiezan por la letra introducida
            for(String name: names) {
                if(name.charAt(0) == keyWord.charAt(0)) {
                    System.out.println("--> [" + name + "]");
                }
            }
        } while (true);
    }
}
