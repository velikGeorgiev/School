package unitOneFinal;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _02_AsciiTable {
    
    /**
     * @param args Los argumentos pasados por el terminal
     */
    public static void main(String[] args) {
        /**
         * Definimos el numero inicial y el numero final.
         */
        int numeroInicial = 32;
        int numeroFinal = 126;
        
        /**
         * Definimos los borders de la tabla.
         */
        String border = "+--------------+--------------+";
        char borderFrontal = '|';
        
        // Imprimimos el border superior de la tabla.
        System.out.println(border);
        
        // Imprimimos las cabeceras de la tabla
        System.out.println(borderFrontal + "   Decimal    " + borderFrontal + "   Caracter   " + borderFrontal);
        System.out.println(border);
        
        /**
         * Imprimimos las filas.
         * Escribiendo en las celdas el valor numerico del caracter y el caracter.
         */
        for(int i = numeroInicial; i <= numeroFinal; i++) {
            // Border frontal 
            System.out.print(borderFrontal);
            
            //Calculamos los espacios que habra en la parte izquierda
            // y en la parte derecha del numero
            int espaciosIzquierda = (14 - (i + "").length()) / 2;
            int espaciosDerecha = (14 - (i + "").length()) / 2;
            
            // Si el numero tiene una cantidad de caracteres impar le sumamos un estacio demas en
            // la parte derecha
            espaciosDerecha = ((i + "").length() % 2 == 0) ? espaciosDerecha : espaciosDerecha + 1;
            
            // Imprimimos los espacion de la parte izquierda
            for(int x = 0; x < espaciosIzquierda; x++) {
                System.out.print(" ");
            }
            
            // Imprimimos el valor decimal del caracter
            System.out.print(i);
            
            // Imprimimos los espacion de la parte derecha
            for(int x = 0; x < espaciosDerecha; x++) {
                System.out.print(" ");
            }
            
            /**
             * Imprimimos el border frontal como separacion 
             * de las dos celdas
             */
            System.out.print(borderFrontal);
            
            /**
             * Imprimimos la celda con el caracter
             */
            int espaciosIzquierdaCaracter = (14 / 2) - 1; // Le restamos 1 por el border frontal
            int espaciosDerechaCaracter = 14 / 2;
            
            // Imprimimos los espacion de la parte izquierda
            for(int x = 0; x < espaciosIzquierdaCaracter; x++) {
                System.out.print(" ");
            }
            
            // Imprimimos el caracter casteabdo el numero entero a un char.
            System.out.print((char) i);
            
            // Imprimimos los espacion de((char)  la parte derecha
            for(int x = 0; x < espaciosDerechaCaracter; x++) {
                System.out.print(" ");
            }
            
            // Border frontal
            System.out.println(borderFrontal);
        }
        
        // Imprimimos el border inferior de la tabla.
        System.out.println(border);
    }
}

