package javaexercises;

/**
 *
 * @author velko
 */
public class _08_OddOrEven {
    public static void main(String[] args) {
        int number = 371;
        
        if((number % 2) == 0) {
            System.out.printf("El numero %d es par\n", number); // odd
        } else { 
            System.out.printf("El numero %d es impar\n", number); // even
        }
    }
}
 