package tema5;

import java.util.Random;

/**
 *
 * @author velko
 */
public class Actividad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] arrUno = generarMatriz(3, 3);
        int[][] arrDos = generarMatriz(3, 3);
        int[][] arrTres = new int[3][3];

        for (int i = 0; i < arrUno.length; i++) {
            for (int x = 0; x < arrUno[i].length; x++) {
                arrTres[i][x] = arrUno[i][x] + arrDos[i][x];
            }
        }
        
        imprimirMatriz(arrTres);
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
