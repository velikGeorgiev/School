
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _18_IsPalindromeStringBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word;
        StringBuilder sb;
        
        // Leer la palabra
        word = scan.nextLine();
        sb = new StringBuilder(word).reverse();
        
        if(word.equals(sb.toString())) {
            System.out.println("La palabra es palindroma");
        } else {
            System.out.println("La palabra no es palindroma");
        }
    }

}
