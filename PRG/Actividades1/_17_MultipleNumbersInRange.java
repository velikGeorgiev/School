package javaexercises;

/**
 *
 * @author velko
 */
public class _17_MultipleNumbersInRange {

    public static void main(String[] args) {
        for (int i = 21; i <= 100; i++) {
            if((i % 3) == 0 && (i % 7) == 0) {
                System.out.println(i);
            }
        }
    }
}
