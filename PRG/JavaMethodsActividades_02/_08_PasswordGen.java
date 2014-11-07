
package JavaMethodsActividades_02;

import java.util.Random;
import java.util.Scanner;

/**
 * El programa genera una contraseña aleatoria compuesta por
 * letras mayusculas, minusculas y/o numeros.
 * 
 * El tamaño de la contraseña viene definido por el mismo
 * usuario.
 * 
 * En este programa se utiliza la clase Random para generar
 * todos los componentes aleatorios. En un proyecto comercial
 * es recomendable utilizar SecureRandom que se encuentra en el 
 * paquete (java.security) por razones de seguridad.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 * @see Random
 */
public class _08_PasswordGen {    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Pedir al usuario que introduzca la longitud del password
        System.out.print("De cuantos simbolos debe de ser el pass: ");
        int passLength = Integer.parseInt(scan.nextLine());
        
        // Generar pass
        String password = genPassword(passLength);
        
        // Imprimimos el pass
        System.out.println("Su password es: " + password);
    }
    
    /**
     * Genera una contraseña aleatoria.
     * La constraseña sera compuesta por letras minusculas, mayusculas y numeros.
     * 
     * @param length El tamaño de la contraseña
     * @return Una contraseña aleatoria del tamaño indicado.
     */
    public static String genPassword(int length) {
        StringBuilder password = new StringBuilder(length);
        
        /**
         * Generamos caracteres/numeros aleatorios hasta
         * llegar el tamaño indicado de la contraseña.
         */
        for(int i = 0; i < length; i++) {            
            
            /**
             * Para "decidir" si se utiliza una letra minuscula, mayuscula o un numero
             * generamos un numero aleatorio del 0 al 2. 
             * Segun el numero generado se genera un caracter u otro, añadiendo el mismo
             * al StringBuilder que guardara la contraseña.
             */
            switch(new Random().nextInt(3)) {
                case 0: password.append(genLetraMinuscula()); break;
                case 1: password.append(genLetraMayuscula()); break;
                case 2: password.append(genNumero()); break;
            }
        }
        
        return password.toString();
    }

    /**
     * Genera una letra minuscula aleatoria.
     * 
     * Genera un numero aleatorio en el rango
     * de las letras minusculas en la tabla ASCII y luego conviete
     * el numero en un caracter.
     * 
     * @return Letra minuscula aleatoria (caracter)
     */
    public static char genLetraMinuscula() {
        // Las letras minusculas empiezan de 97 hasta 122
        int a = (int)'a';
        int z = (int)'z';
        
        return (char)(new Random().nextInt((z - a) + 1) + a);
    }
    
    /**
     * Genera una letra mayuscula aleatoria.
     * 
     * Genera un numero aleatorio en el rango
     * de las letras mayusculas en la tabla ASCII y luego conviete
     * el numero en un caracter.
     * 
     * @return Letra mayuscula aleatoria (caracter)
     */
    public static char genLetraMayuscula() {
        // Las letras mayusculas empiezan de 65 hasta 90
        int a = (int)'A';
        int z = (int)'Z';
        
        return (char)(new Random().nextInt((z - a) + 1) + a);
    }
    
    /**
     * Genera un un numero aleatorio del 0 al 9.
     * 
     * @return Numero aleatorio del 0 al 9
     */
    public static int genNumero() {
        return (new Random().nextInt(10));
    }
}
