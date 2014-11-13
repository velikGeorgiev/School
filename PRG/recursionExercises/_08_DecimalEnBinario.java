
package recursionExercises;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _08_DecimalEnBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(convertirEnBinario(42));
    }
    
    public static String convertirEnBinario(int num) {
        if(num <= 1) {
            return "1";
        }
        
        int bit = (num % 2 == 0) ? 0 : 1;
        
        return convertirEnBinario(num / 2) + bit;
    }
}
