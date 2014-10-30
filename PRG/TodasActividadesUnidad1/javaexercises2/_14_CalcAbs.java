package javaexercises2;

/**
 *
 * @author velko
 */
public class _14_CalcAbs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "Simulacion" de entrada de varios numeros
        int[] numbers = {-1, 2, -9, -8, 9, 1, 3, -6};
        
        // Manual
        for(int currentNumber : numbers) {
            int abs = (currentNumber < 0) ? -currentNumber : currentNumber;
            
            System.out.println("Valor absoluto de " + currentNumber + ": " + abs);
        }
    }
}
