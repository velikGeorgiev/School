/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_t4_pablo_perez;

/**
 *
 * @author vesprada
 */
public class Ejercicio3_Pablo_Perez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dibujaFlecha(9);
    }
    public static void dibujaFlecha(int num){
        if (!valida(num)){
            System.out.println("Número no correcto! Introduce otro");
            return;
        }
        int ast = num/2;
        int esp = 1;
        dibujalinea(num);
        for (int i = 0; i < (num/2)-1; i++) {
            dibujalinFle(ast, esp);
            ast--;
            esp += 2;
        }
        dibujalinea(num);
        dibujaBase((num-3)/2);
    }
    public static void dibujalinea(int num){
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
    public static void dibujalinFle(int ast, int esp){
        for (int i = 0; i < ast; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < esp; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < ast; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
    public static void dibujaBase(int esp){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < esp; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 3; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < esp; j++) {
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
    public static Boolean valida(int num){
        if (num <= 3) return false;
        if (num%2 == 0) return false;
        return true;
    }
}
