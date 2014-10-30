package javaexercises;

/**
 *
 * @author velko
 */
public class _19_MinAndMax {

    public static void main(String[] args) {
        int[] numbers = {54, 6, 7, 324, 56, 2, 2345, 234, 5234, 5324, 523, 45, 2345, 554, 5, 64, 5, 7756};
        int min = Integer.MAX_VALUE; // o bien int min = numbers[0]
        int max = Integer.MIN_VALUE; // o bien int max = numbers[0]
        
        for(int currentNumber: numbers) {
            if(min > currentNumber) {
                min = currentNumber;
            }
            
            if(max < currentNumber) {
                max = currentNumber;
            }
        }
        
        System.out.println("Valor minimo: " + min + " \nValor maximo: " + max + "\n");
    }
}
