package javaexercises2;

/**
 *
 * @author velko
 */
public class _13_ValueExchange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "Simulacion" de entrada por teclado con arrays
        // El tamaño de las matrizes debe de ser el mismo. 
        int[] firstNumber = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] secondNumber = new int[]{5, 1, 2, 6, 2, 8, 1, 10, 0, 50, 9, 19, 8, 54};

        for (int i = 0; i < firstNumber.length; i++) {
            try {
                int a = firstNumber[i];
                int b = secondNumber[i];
                int temp = 0;

                // Imprimir los valores actuales
                System.out.print("A = " + a + " B = " + b);
                
                // Si a es mayor que b intercambiamos los valores 
                // utilizando una varable temporal
                if (a > b) {
                    temp = a;
                    a = b;
                    b = temp;
                }
                
                // Imprimir los valores nuevos
                System.out.print(" >> A = " + a + " B = " + b + "\n");
            } catch (Exception ex) {
                
                // Si ocurre algun error con las matrizes interumpimos el bucle 
                // e imprimimos un mensaje de error.
                System.out.println("Simulacion de entrada mediante matrizes incorrecta.");
                break;
            }
        }
    }
}
