package javaexercises;

/**
 *
 * @author velko
 */
public class _09_OddOrEvenSecondExample {
    public static void main(String[] args) {
        int number = 371;
        String strResult = ((number % 2) == 0) ? "par" : "impar";
        
        System.out.println("El numero " + number + " es " + strResult);
        
        
    }
}
