
package JavaMethodsActividades_02;

import java.util.Scanner;

/**
 * Programa que imprime una serie de opciones y realiza
 * una accion determinada segun la opcion elegina por el
 * usuario.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _10_Menu {

    /**
     * En la variable de tipo StringBuilder
     * guardaremos todas la opciones del menu 
     * disponibles.
     */
    private static StringBuilder listaDeOpciones = new StringBuilder();
    
    private static Scanner scan;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Crear la lista de opciones.
         */
        agregarOpcion(1, "Vector 1: Numero impar de numeros primos");
        agregarOpcion(2, "Vector 2: Numeros NO primos");
        agregarOpcion(3, "Vector 3: Numero min. max. y media.");
        
        int opcion = 0;
        int[] vectorDeEntradas;
        
        do {
            // Imprimimos el menu entero en la pantalla del usuario
            imprimirOpciones();
            
            // Le pedimos que eliga una opcion
            opcion = leerEnteroDelTerminal("Elige una opcion: ");
            
            switch(opcion) {
                /**
                 * Si elige la opcion 1 tendra que rellenar un vector con
                 * 7 numeros. El vector sera correctamente rellenado si 
                 * la cantidad de numero primos es impar.
                 */
                case 1:
                    vectorDeEntradas = rellenarVectorDeEntradas(7);
                    imprimirValidacion((contarPrimos(vectorDeEntradas) % 2 == 0));
                break;
                
                /**
                 * Si elige la opcion 2 tendra que rellenar un vector con
                 * 5 numeros. El vector sera correctamente rellenado si 
                 * no contiene numeros primos.
                 */
                case 2:
                    vectorDeEntradas = rellenarVectorDeEntradas(5);
                    imprimirValidacion((contarPrimos(vectorDeEntradas) == 0));
                break;
                    
                /**
                 * Si elige la opcion 3 tendra que rellenar un vector con
                 * 5 numeros. Luego se imprimira el numero maximo, el minimo
                 * y el valor medio del vector creado.
                 */
                case 3:
                    vectorDeEntradas = rellenarVectorDeEntradas(5);
                    System.out.println("Minimo: " + valorMinimo(vectorDeEntradas));
                    System.out.println("Maximo: " + valorMaximo(vectorDeEntradas));
                    System.out.println("Media: " + mediaDeVector(vectorDeEntradas));
                break;
                
                default:
                    System.out.println("\n*** Opcion no valida ***\n");
            }
            
            System.out.println("");
        } while(true);
    }
    
    /**
     * Devuelve la media de todos los numeros en un vector.
     * 
     * @param numeros Vector al cual se le calculara la media.
     * @return El valor medio del vector.
     */
    public static double mediaDeVector(int[] numeros) {        
        return ((double)sumarNumerosDeVector(numeros) / (double)numeros.length);
    }
    
    /**
     * Suma todos los numeros de un vector.
     * 
     * @param numeros Vector cuyos numeros seras sumados.
     * @return La suma de todos los numeros en el vector
     */
    public static int sumarNumerosDeVector(int[] numeros) {
        int resultado = 0;
        
        for(int num: numeros) {
            resultado += num;
        }
        
        return resultado;
    }
    
    /**
     * Devuelve el numero minimo de un vector.
     * 
     * Dificultad para encontrar el elemento: O(n)
     * 
     * @param numeros Un vector de numeros, en el cual se buscara el numero minimo
     * @return El numero minimo del vector dado.
     */
    public static int valorMinimo(int[] numeros) {
        int min = Integer.MAX_VALUE;
        
        for(int num: numeros) {
            if (num < min) {
                min = num;
            }
        }
        
        return min;
    }
    
    /**
     * Devuelve el numero maximo de un vector.
     * 
     * Dificultad para encontrar el elemento: O(n)
     * 
     * @param numeros Un vector de numeros, en el cual se buscara el numero maximo
     * @return El numero maximo del vector dado.
     */
    public static int valorMaximo(int[] numeros) {
        int max = Integer.MIN_VALUE;
        
        for(int num: numeros) {
            if (num > max) {
                max = num;
            }
        }
        
        return max;
    }
    
    /**
     * Le pide al usuario ingresar una cantidad predeterminada
     * de numeros enteros en el terminal.
     * 
     * Los numeros se guardan en un vector de numeros enteros y se devuelve.
     * 
     * @param totalNumeros La cantidad de numeros a ingresar que se le debe de pedir al usuario.
     * @return Un vector que contendra todas las entradas del usuario
     */
    public static int[] rellenarVectorDeEntradas(int totalNumeros) {
        int[] vectorDeEntradas = new int[totalNumeros];
        
        for(int i = 0; i < totalNumeros; i++) {
            vectorDeEntradas[i] = leerEnteroDelTerminal("Numero " + (i+1) + "/" + totalNumeros + ": ");
        }
        
        return vectorDeEntradas;
    }
    
    /**
     * Cuenta cuantos numeros primos hay en un vector.
     * 
     * @param numeros Vector de numeros
     * @return La cantidad de numeros primos que contiene el vector
     */
    public static int contarPrimos(int[] numeros) {
        int contador = 0;
        
        for(int numero: numeros) {
            if(esPrimo(numero)) {
                contador++;
            }
        }
        
        return contador;
    }
    
    /**
     * Comprueba si un numero es primo o no.
     * 
     * @param numero El numero a comprobar
     * @return TRUE si el numero es primo y FALSE en caso contrario
     */
    public static boolean esPrimo(int numero) {
        
        for(int i = 2; i <= Math.sqrt(numero); i++){
            if(numero % i == 0){
                return false;
            }
        }
   
        return true;
    }
    
    /**
     * Agrega una nueva opcion a la lista de opciones que compone el menu
     * del programo.
     * 
     * @param codigo Codigo de la operacion
     * @param descripcion Descripcion de la operacion
     */
    public static void agregarOpcion(int codigo, String descripcion) {
        listaDeOpciones.append(codigo).append(": ").append(descripcion).append("\n");
    }
    
    /**
     * Imprime todas la opciones actuales en la pantalla en 
     * forma de menu.
     */
    public static void imprimirOpciones() {
        System.out.println(listaDeOpciones.toString());
    }
    
    /**
     * Lee un numero entero introducido por el usuario en el terminal.
     * 
     * @param textoAMostrar Texto que se mostrar al usuario para indicarle que datos tiene que introducir
     * @return El numero introducido por el usuario
     */
    public static int leerEnteroDelTerminal(String textoAMostrar) {
        /**
         * Si la variable scan no esta inicializada, la inicializamos.
         */
        if(scan == null) {
            scan = new Scanner(System.in);
        }
        
        int entradaUsuario = 0;
        
        try {
            System.out.print(textoAMostrar);
            entradaUsuario = Integer.parseInt(scan.nextLine());
        } catch(Exception ex ) { };
        
        return entradaUsuario;
    }
    
    /**
     * Imprime en pantalla si un vector es valido o no.
     * 
     * @param esValido True si el vector es valido en caso contrario false
     */
    public static void imprimirValidacion(boolean esValido) {
        if(!esValido) {
            System.out.println("El vector no es valido.");
        } else {
            System.out.println("El vector es valido.");
        }
    }
}
