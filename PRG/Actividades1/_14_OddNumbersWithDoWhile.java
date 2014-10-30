package javaexercises;

/**
 *
 * @author velko
 */
public class _14_OddNumbersWithDoWhile {

    public static void main(String[] args) {

        int num = 20;

        do {
            System.out.println(num);
            num -= 2;
        } while (num >= 2);
    }
}
