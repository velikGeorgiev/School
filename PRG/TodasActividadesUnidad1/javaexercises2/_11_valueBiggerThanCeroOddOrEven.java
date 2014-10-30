package javaexercises2;

/**
 *
 * @author velko
 */
public class _11_valueBiggerThanCeroOddOrEven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "Simulacion" de entrada de varios numeros
        int[] numbers = {-1, 0, 3, 6, 8, -9, -105, 654, -789, -26, 98};
        
        for(int currentNumber : numbers) {
            if(currentNumber < 0) {
                System.out.print(currentNumber + " es menor que 0.");
            } else if (currentNumber > 0) {
                System.out.print(currentNumber + " es mayor que 0.");
            } else {
                System.out.print(currentNumber + " es igual a 0.");
            }
            
            if((currentNumber % 2) == 0) {
                System.out.println(" Es par.");
            } else {
                System.out.println(" Es impar.");
            }
        }
    }

}
