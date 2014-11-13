
package recursionExercises;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _01_ReverseNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(reverseNumber(123));
    }

    public static int reverseNumber(int number) {
        return reverseNumber(number, (String.valueOf(number).length() - 1));
    }
    
    private static int reverseNumber(int number, int index) {
        String numberString = String.valueOf(number);
        
        if(index == 0) {
            return Integer.parseInt(String.valueOf(numberString.charAt(index)));
        }
        
        return Integer.parseInt(String.valueOf(numberString.charAt(index)) + reverseNumber(number, index - 1));
    }
}
