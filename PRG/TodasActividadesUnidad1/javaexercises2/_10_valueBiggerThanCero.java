package javaexercises2;

/**
 *
 * @author vesprada
 */
public class _10_valueBiggerThanCero {

    public static void main(String[] args) {
        
        // "Simulacion" de entrada de varios numeros
        int[] numbers = {-1, 0, 3, 6, 8, -9, -105, 654, -789, -26, 98};
        
        for(int currentNumber : numbers) {
            if(currentNumber < 0) {
                System.out.println(currentNumber + " es menor que 0.");
            } else if (currentNumber > 0) {
                System.out.println(currentNumber + " es mayor que 0.");
            } else {
                System.out.println(currentNumber + " es igual a 0.");
            }
        }
    }
}
