package recursionExercises;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _02_SumArrayNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(sumarNumerosEnVector(nums));
    }

    public static int sumarNumerosEnVector(int[] numeros) {
        return sumarNumerosEnVector(numeros, 0);
    }

    private static int sumarNumerosEnVector(int[] numeros, int index) {
        if (index >= numeros.length) {
            return 0;
        }
        
        return numeros[index] + sumarNumerosEnVector(numeros, (index + 1));
    }
}
