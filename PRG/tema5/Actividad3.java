package tema5;

import java.util.Random;

/**
 *
 * @author velko
 */
public class Actividad3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matriz = generarMatriz(10, 10);
        
        int[] fila = new int[10];
        int[] columna = new int[10];
     
        for(int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                columna[i] += matriz[i][j];
                fila[i] += matriz[j][i];
            }
        }        
        
        for(int i = 0; i < columna.length; i++) {
            System.out.println("Columna " + i + ": " + columna[i]);
            System.out.println("Fila " + i + ": " + fila[i]);
        }
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
}
