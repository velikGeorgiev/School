/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_t4_pablo_perez;

/**
 *
 * @author vesprada
 */
public class Ejercicio2_Pablo_Perez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(palindromoRec("abcdudcba"));
        System.out.println(palindromoRec("ana"));
        System.out.println(palindromoRec("casa"));
        System.out.println(palindromoRec("pablo"));
        System.out.println(palindromoRec("la casa asac al"));
    }
    static Boolean palindromoRec(String palabra){      
        if(palabra.length() < 2) return true;
        return palabra.charAt(0) == palabra.charAt(palabra.length()-1) 
                && palindromoRec(palabra.substring(1, palabra.length()-1));
    }
    
    static Boolean palindromo(String palabra){
        Boolean res = true;
        for (int i = 0; i < palabra.length()/2; i++) {
            if (palabra.charAt(i) != palabra.charAt(palabra.length()-i-1)){
                res = false;
                break;
            }
        }
        return res;
    }
}
