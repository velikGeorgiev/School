
package recursionExercises;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _03_MultiplicarElementosDeVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(multiplicarNumerosEnVector(nums));
    }

    public static int multiplicarNumerosEnVector(int[] numeros) {
        return multiplicarNumerosEnVector(numeros, 0);
    }

    private static int multiplicarNumerosEnVector(int[] numeros, int index) {
        if (index >= numeros.length) {
            return 1;
        }
        
        return numeros[index] * multiplicarNumerosEnVector(numeros, (index + 1));
    }

}
