import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _03_ControlDeOrden {

    /**
     * @param args Los argumentos pasados por el terminal
     */
    public static void main(String[] args) {
        /**
         * Numero entero introducido por el usuario.
         */        
        int entradaUsuario = 0;
        
        /**
         * Ultimo numero introducido VALIDO
         */
        int ultimoNumeroValido = 0;
        
        /**
         * Cantidad de los numeros NO VALIDOS introducidos.
         */
        int cantidadNumerosNoValidos = 0;
        
        /**
         * Leemos la serie de numeros introducidos por el usuario 
         * hasta que introduzca un numero negativo.
         */
        try(Scanner scan = new Scanner(System.in)) {
            do {
                try{
                    System.out.print("Introduce numero: ");
                    entradaUsuario = Integer.parseInt(scan.nextLine());
                } catch(Exception ex) {
                    // Si el valor introducido no es valido lo indicamos
                    // y le volvemos a pedir al usuario que itroduzca un valor.
                    System.out.println("*** El valor introducido no es un valor valido. ***");
                    continue;
                }
                
                // Si la entrada del usuario es menor que cero ( negativa )
                // interumpimos el bucle y mostramos el resutlado
                if(entradaUsuario < 0) {
                    break;
                }
                
                /**
                 * Si el numero introducido es MENOR que el ultimo numero introducido,
                 * se trata de un numero NO VALIDO, por lo tanto incrementaremos
                 * la cantidad de numeros no validos introducidos con 1, en caso contrario
                 * asignamos el numero introducido como un numero valido.
                 */
                if(entradaUsuario < ultimoNumeroValido) {
                    cantidadNumerosNoValidos++;
                } else {
                    ultimoNumeroValido = entradaUsuario;
                }
                
            } while (true);
            
            // Imprimimos la cantidad de numeros no validos introducidos
            System.out.println("Numeros no validos introducidos: " + cantidadNumerosNoValidos);
        }
    }
}
