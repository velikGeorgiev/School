
package recursionExercises;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _07_BaseExp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(calcExp(3, 3));
    }

    public static int calcExp(int base, int exp) {
        if(exp <= 1) {
            return base;
        }
        
        return base * calcExp(base, exp - 1);
    }
}
