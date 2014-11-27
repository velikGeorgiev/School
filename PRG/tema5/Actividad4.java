package tema5;

import java.util.Random;

/**
 *
 * @author velko
 */
public class Actividad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matriz = generarMatriz(2, 3);
        int[][] matrizInvertida = new int[matriz[0].length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matrizInvertida[j][i] = matriz[i][j];
            }
        }

        imprimirMatriz(matriz);
        imprimirMatriz(matrizInvertida);
    }
    
    public static int[][] generarMatriz(int x, int y) {
        int[][] matriz = new int[x][y];
        Random rand = new Random();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matriz[i][j] = rand.nextInt(101);
            }
        }

        return matriz;
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
