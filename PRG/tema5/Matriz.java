package tema5;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author velko
 */
public class Matriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 3, opcion = 0;
        
        // Leemos el tamaño del array
        //System.out.print("Tamaño del vector: ");
        //n = Integer.parseInt(scan.nextLine());
        
        // creamoz la matriz
        int[][] matriz = generarMatriz(n, n);
        /*
        do {
            System.out.println("1: Ver matriz");
            System.out.println("2: Sumar matrices");
            System.out.println("3: ");
            System.out.println("4: ");
            System.out.println("5: ");
            System.out.println("6: ");
            System.out.println("7: ");
            System.out.println("8: ");
            
        } while(true);*/
        
        //imprimirMatriz(matriz);
        int[][] nMatriz = {
            {-8,-1,3},
            {-1,7,4},
            {3,4,9},
        };
        System.out.println("");
        esSimetrica(nMatriz);        
    }

    /** D **/
    public static int[][] matrizIdentidad(int size) {
        int[][] matriz = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = 1;
                }
            }
        }
        
        return matriz;
    }
    
    /** A **/
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

    /** B **/
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }

            System.out.println("");
        }
    }

    /** C **/
    public static int[][] sumaMatrices(int[][] matrizUno, int[][] matrizDos) {
        int[][] matrizResultado = new int[matrizUno.length][matrizUno[0].length];

        for (int i = 0; i < matrizUno.length; i++) {
            for (int x = 0; x < matrizUno[i].length; x++) {
                matrizResultado[i][x] = matrizUno[i][x] + matrizDos[i][x];
            }
        }

        return matrizResultado;
    }

    /** F **/
    public static int[][] matrizInvertida(int[][] matriz) {
        int[][] resultado = new int[matriz[0].length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resultado[j][i] = matriz[i][j];
            }
        }

        return resultado;
    }
    
    /** G **/
    public static int[][] matrizTranspuesta(int[][] matriz) {
        int[][] resultado = new int[matriz[0].length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resultado[i][j] = matriz[j][i];
            }
        }

        return resultado;
    }
    
    /** E **/ 
    public static boolean esSimetrica(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[i].length != matriz.length){
                return false;
            }
        }
        
        int[][] matrizTranspuesta = matrizTranspuesta(matriz);
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] != matrizTranspuesta[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
