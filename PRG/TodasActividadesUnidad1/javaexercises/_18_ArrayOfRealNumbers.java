package javaexercises;

/**
 *
 * @author velko
 */
public class _18_ArrayOfRealNumbers {

    public static void main(String[] args) {
        float[] numbers = new float[]{1.2f, 2.2f, 3.2f, 4.2f};
        float medium = 0;
        float total = 0;

        for (float currentNumber : numbers) {
            total += currentNumber;
        }

        medium = total / numbers.length;

        System.out.println("La media es: " + medium);

        for (float currentNumber : numbers) {
            if (currentNumber <= medium) {
                continue;
            }

            System.out.println(currentNumber);
        }
    }
}
