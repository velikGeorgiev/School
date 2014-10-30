
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _18_IsPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word, reversedWord = "";
        
        // Leer la palabra
        word = scan.nextLine();
        
        // La palabra al reves
        for(int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        
        if(word.equals(reversedWord)) {
            System.out.println("La palabra es palindroma.");
        } else {
            System.out.println("La palabra no es palindroma.");
        }
    }

}
