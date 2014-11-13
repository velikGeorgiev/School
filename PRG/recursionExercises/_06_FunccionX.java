
package recursionExercises;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _06_FunccionX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(calcFunccionX(4));
    }

    public static int calcFunccionX(int num) {
        if(num > 2) {
            return calcFunccionX(num - 3) + 2 * calcFunccionX(num - 2) + calcFunccionX(num - 1);
        } else {
            return num;
        }
    }
}
