package javaexercises2;

/**
 *
 * @author velko
 */
public class _16_GetMaxValue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "Simulacion" de entrada de varios numeros
        int[] numbers = {4, 2, 9, 8, 9, 1, 3, -6, 5, 2};
        
        // A max le asignamos -1 ya que un numero negativo significa "fin"
        // si esto no fuera asi a 'max' se le asignara Integer.MIN_VALUE
        int max = -1;
        
        for(int currentNumber: numbers) {
            // Si el numero es negativo interumpimos el bucle
            if(currentNumber < 0) {
                break;
            }
            
            // Si max es menor que el valor actual le asignamos el valor introducido
            if(max < currentNumber) {
                max = currentNumber;
            }
        }
        
        System.out.println("El mayor numero introducido es: " + max);
    }
}
