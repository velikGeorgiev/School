package Examen_T4_VelikGeorgiev;

import java.util.Scanner;

/**
 *
 * @author  Velik Georgiev Chelebiev
 */
public class Actividad1 {
    public static Scanner scan = new Scanner(System.in);
    public static final char CARACTER_DIBUJAR = '*';
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int baseArbol = leerNumero("Numero mayor que 3 e impar: ", 3);
        dibujarArbol(baseArbol);
    }
    
    /**
     * Dinuja un arbol de navidad.
     * 
     * @param anchuraBase La anchura de la base del arbol
     */
    public static void dibujarArbol(int anchuraBase) {
        for (int i = 1; i <= anchuraBase; i += 2) {
            System.out.print(repetirCaracter(' ', (anchuraBase - i) / 2));
            System.out.println(repetirCaracter(CARACTER_DIBUJAR, i));
        }
        
        // Utilizaremos el parametro paddingLeft para poder posicionar el 
        // tronco del arbol en el medio
        int paddingLeft = (int)Math.floor((anchuraBase - 3) / 2);
        dibujarBaseTronco(2, 3, paddingLeft);
    }
    
    /**
     * Dibuja el tronco de un arbol de navidad.
     * 
     * @param altura La altura del tronco
     * @param anchura La anchura del tronco 
     * @param paddingIzquierdo El relleno izquierdo 
     */
    public static void dibujarBaseTronco(int altura, int anchura, int paddingIzquierdo) {
        for(int i = 0; i < altura; i++) {
            System.out.print(repetirCaracter(' ', paddingIzquierdo));
            System.out.print(repetirCaracter(CARACTER_DIBUJAR, anchura));
            System.out.print('\n');
        }
    }
    
    /**
     * Repite un caracter una serie de veces indicada.
     * 
     * @param caracter El caracter que se debe de repetir
     * @param veces Las veces que se debe de repetir el caracter indicado
     * @return Una cadena que contiene el caracter repatido las veces indicadas
     */
    public static String repetirCaracter(char caracter, int veces) {
        StringBuilder resultado = new StringBuilder(veces);
        
        for(int i = 0; i < veces; i++) {
            resultado.append(caracter);
        }
        
        return resultado.toString();
    }
    
    /**
     * Lee un numero que se debe de introducir por el usuario mediante el terminal.
     * El numero debe de respetar una serie de condiciones: 
     * Ser mayor que un numero indicado y que sea impar.
     * Si estas condiciones no se cumplen se volvera a pedir un numero.
     * 
     * @param texto El texto que se le mostrara al usuario para indicar le que es lo que debe de
     *              introducir
     * @param valorMinimo El valor minimo que debe de cumplir el numero
     * @return El numero introducido por el usuario
     */
    public static int leerNumero(String texto, int valorMinimo) {
        int numero = 0;
        
        do {
            System.out.print(texto);
            numero = Integer.parseInt(scan.nextLine());
        } while(numero <= 3 || esPar(numero));
        
        return numero;
    }
    
    public static boolean esPar(int numero) {
        return ((numero % 2) == 0);
    }
}
