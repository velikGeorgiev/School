package javaexercises;

/**
 *
 * @author velko
 */
public class _12_MultiplicationTableOfFive {
    public static void main(String[] args) {
        int numInitial = 1;
        int numEnd = 10;
        int multiplyBy = 5;
        
        while (numInitial <= numEnd) {
            System.out.printf("%d * %d = %d \n", numInitial, multiplyBy, (numInitial++) * multiplyBy);
        }
    }
}
