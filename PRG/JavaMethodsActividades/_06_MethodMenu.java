
package JavaMethodExample;

import java.util.Scanner;

/**
 * El programa muestra una serie de opciones predefinidas
 * pediendo le al usuario que eliga una y realiza su respectiva
 * accion.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _06_MethodMenu {

    /**
     * En este StringBuilder se guardaran las opciones disponibles.
     */
    private static StringBuilder listaDeOpciones = new StringBuilder();
    
    /**
     * Un scanner de texto que usaremos para leer 
     * datos introducidos en el terminal por el usuario.
     */
    private static Scanner scan = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * Las variables que se usaran para guardar
         * los datos introducidos por el usuarion.
         */
        float number = 0, base = 0, exp = 0;
        
        /**
         * Esta variable indica si el programa se debe de
         * terminar.
         */
        boolean exit = false;
        
        /**
         * Definimos las operaciones.
         */
        agregarOpcion(1, "Calcula el cuadro");
        agregarOpcion(2, "Calcula el cubo");
        agregarOpcion(3, "Calcula la potencia");
        agregarOpcion(4, "Salir");
        
        /**
         * Imprimimos las opciones
         */
        imprimir();
        
        do {
            /**
             * Leemos la opcion seleccionada por el usuario
             */
            int opcion = leerEnteroDelTerminal("Opcion: ");

            /**
             * Ejecutamos la opcion elegida
             */
            switch(opcion) {
                case 1: 
                    number = leerFloatDelTerminal("Numero: ");
                    System.out.println(calcularCuadrado(number));
                break;

                case 2:
                    number = leerFloatDelTerminal("Numero: ");
                    System.out.println(calcularCubo(number));
                break;

                case 3:
                    base = leerFloatDelTerminal("Base: ");
                    exp = leerFloatDelTerminal("Exponente: ");

                    // En teoria ya tenemos un metodo para esto.
                    System.out.println(Math.pow(base, exp));
                break;

                case 4: 
                    exit = true;
                break;
                    
                default:
                    System.out.println("\n*** La opcion introducida no es valida. ***\n");
                break;
            }
        } while(!exit);
    }
    
    /**
     * Calcula el cuadrado de un numero.
     * 
     * @param num El numero al cual necesitamos calcular el cuadrado
     * @return El resultado de la operacion ( el cuadrado del numero indicado )
     */
    public static float calcularCuadrado(float num) {
        return num * num;
    }
    
    /**
     * Calcular el cubo de un numero.
     * 
     * @param num El numero al cual necesitamos calcular su valor cubico.
     * @return El resultado de la operacion ( el valor cubico del numero indicado )
     */
    public static float calcularCubo(float num) {
        return calcularCuadrado(num) * num;
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
     * Lee un numero real ( float ) introducido por el usuario en el terminal.
     * 
     * @param textoAMostrar Texto que se mostrar al usuario para indicarle que datos tiene que introducir
     * @return El numero introducido por el usuario
     */
    public static float leerFloatDelTerminal(String textoAMostrar) {
        /**
         * Si la variable scan no esta inicializada, la inicializamos.
         */
        if(scan == null) {
            scan = new Scanner(System.in);
        }
        
        float entradaUsuario = 0f;
        
        try {
            System.out.print(textoAMostrar);
            entradaUsuario = Float.parseFloat(scan.nextLine());
        } catch(Exception ex ) { };
        
        return entradaUsuario;
    }
    
    /**
     * Imprime la lista de opciones definida.
     */
    public static void imprimir() {
        System.out.println(opciones());
    }
    
    /**
     * Agrega una nueva opcion a la lista de opciones.
     * 
     * @param numeroDeLaOperacion El codigo/numero que corresponde a la opcion
     * @param opcion Descripcion de la operacion
     */
    public static void agregarOpcion(int numeroDeLaOperacion, String opcion) {
        listaDeOpciones.append("Opcion ");
        listaDeOpciones.append(numeroDeLaOperacion);
        listaDeOpciones.append(" ");
        listaDeOpciones.append(opcion);
        listaDeOpciones.append("\n");
    }
    
    /**
     * Devuelve una cadena de texto con las opciones disponibles.
     * 
     * @return Las opciones disponibles
     */
    public static String opciones() {
        return listaDeOpciones.toString();
    }
}
