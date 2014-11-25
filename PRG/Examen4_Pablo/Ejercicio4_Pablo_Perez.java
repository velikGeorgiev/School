/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_t4_pablo_perez;

import java.util.Scanner;

/**
 *
 * @author vesprada
 */
public class Ejercicio4_Pablo_Perez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Apuesta €uro Milones: ");
        ver_fila_numeros(selecciona_numeros(5, 50));
    }
     public static int numero_aleatorio(int max){
         return (int)(Math.random()*max+1);
     }
     public static Boolean esta_en_seleccion(int num, int[] arr){
         for (int i = 0; i < arr.length; i++) {
             if (num == arr[i]) return true;
         }
         return false;
     }
     public static int[] anadir_a_seleccion(int num, int[] arr){
         int[] seleccion = new int[arr.length+1];
         for (int i = 0; i < arr.length; i++) {
             seleccion[i] = arr[i];
         }
         seleccion[arr.length] = num;
         return seleccion;
     }
     public static void ver_fila_numeros(int[] arr){
         for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
     }
     public static int[] selecciona_numeros(int cant, int max){
         int[] arr = new int[0];
         int i = 0;
         int alea;
         while (i < cant){
             alea = numero_aleatorio(max);
             if (!esta_en_seleccion(alea, arr)){
                 arr = anadir_a_seleccion(alea, arr);
                 i++;
             }
         }
         return arr;
     }
}
