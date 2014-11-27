package tema5;

import java.util.Random;

/**
 *
 * @author velko
 */
public class Actividad6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matriz = generarMatriz(4, 5);

        float media = media(matriz, 0);
        
        System.out.println("La media es: " + media);
    }

    public static float media(int[][] matriz, int columna) {
        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][columna];
        }

        return ((float)suma / (float)matriz.length);
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
