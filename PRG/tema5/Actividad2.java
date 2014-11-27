package tema5;

import java.util.Random;

/**
 *
 * @author velko
 */
public class Actividad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] suma = new int[5][5];
        
        for (int i = 0; i < suma.length; i++) {
            for (int j = 0; j < suma[i].length; j++) {
                suma[i][j] = i + j;
            }
        }
        
        imprimirMatriz(suma);
    }
        
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }

            System.out.println("");
        }
    }
}
