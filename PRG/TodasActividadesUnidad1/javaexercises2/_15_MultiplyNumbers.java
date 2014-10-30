package javaexercises2;

/**
 *
 * @author velko
 */
public class _15_MultiplyNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "Simulacion" de entrada de varios numeros
        int[] numbers = {4, 2, 9, 8, 9, 1, 3, -6, 5, 2};
        int result = 1;
        
        for(int currentNumber: numbers) {
            // Si el numero es negativo interumpimos el bucle
            if(currentNumber < 0) {
                break;
            }
            
            result *= currentNumber;
        }
        
        // Imprimiendo el resultado de la multiplicacion realizada previamente
        System.out.println("El resultado es: " + result);
    }
}
