package javaexercises;

/**
 *
 * @author velko
 */
public class _16_MultiplicationTableOfFiveWithFor {
    public static void main(String[] args) {
        int numInitial = 1;
        int numEnd = 10;
        int multiplyBy = 5;
        
        for(int i = numInitial; i <= numEnd; i++) {
            System.out.printf("%d * %d = %d \n", i, multiplyBy, i * multiplyBy);
        }
    }
}
