package tema5;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class OrdenarYBuscarNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numerosQueSeIntruduciran = 0, numero = 0;
        
        // Leemos los numeros que se van a introducir por parte del usuario
        System.out.print("Cuantos numeros se introduciran: ");
        numerosQueSeIntruduciran = Integer.parseInt(scan.nextLine());
        
        // creamos la matriz
        int[] matriz = new int[numerosQueSeIntruduciran];
        
        for (int i = 0; i < numerosQueSeIntruduciran; i++) {
            
            // Leemos el numero
            System.out.print("Numero: ");
            numero = Integer.parseInt(scan.nextLine());
            
            // Insertamos el numero
            for (int j = 0; j < numerosQueSeIntruduciran; j++) {
                if(matriz[j] == 0) {
                    matriz[j] = numero;
                    break;
                }
            }
            
            ordenarMatrizBubbleSort(matriz);
            imprimirMatriz(matriz);
        }
        
        System.out.print("Buscar valor en el array: ");
        int buscarNumero = Integer.parseInt(scan.nextLine());
        
        if(buscarNumero(matriz, buscarNumero)) {
            System.out.println("El numero esta en el array");
        } else {
            System.out.println("El numero no esta en el array");
        }
    }
    
    public static boolean buscarNumero(int[] matriz, int numero) {
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[i] > numero) {
                return false;
            } else if (matriz[i] == numero) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void ordenarMatrizBubbleSort(int[] matriz) {
        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = (i + 1); j < matriz.length; j++) {
                if(matriz[i] > matriz[j]) {
                    int temp = matriz[i];
                    matriz[i] = matriz[j];
                    matriz[j] = temp;
                }
            }
        }
    }
    
    public static void imprimirMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            // Ignoramos los ceros ya que se consideran valores vacios
            if(matriz[i] == 0) {
                continue;
            }
            System.out.print(matriz[i] + " ");
        }        
        System.out.println("");
    }
}
