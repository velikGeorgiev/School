package EjercicionsTema04;

/**
 * Este programa es un conjunto de los 3 programas anteriores ( 12,13,14 ).
 * 
 * Sobreescribe los metodos segun la necesidad.
 * El cuadrado 3x3 no necesita parametros
 * El cuadrado necesita un parametro
 * El rectangulo BASExALTURA necesita 2 parametros. 
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _12_13_14_Dibujar {
    
    private static StringBuilder resultado = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        imprimirRectangulo(5, 6);
        imprimirRectangulo(3);
        imprimirRectangulo(5);
    }
    
    /**
     * Imprime en el terminal un cuadrado.
     * 
     * @param size El lado del cuadrado
     */
    public static void imprimirRectangulo(int size) {
        System.out.println(dibujarRectangulo(size, size));
    }
    
    /**
     * Imprime en el terminal un rectangulo con dimensiones 3x3.
     */
    public static void imprimirRectangulo() {
        System.out.println(dibujarRectangulo(3, 3));
    }
    
    /**
     * Imprime en el terminal un rectangulo.
     * 
     * @param base La base del rectandulo (x)
     * @param altura La altura del rectangulo (y)
     */
    public static void imprimirRectangulo(int base, int altura) {
        System.out.println(dibujarRectangulo(base, altura));
    }
    
    /**
     * Crea una cadena de caracteres con forma de rectangulo.
     * La altura de ese retangulo seran lineas nuevas y la base
     * la cantidad de caracteres por linea.
     * 
     * @param base La base del rectangulo
     * @param altura La altura del triangulo
     * @return Una cadena que compone un rectangulo dibujado utilizando caracteres
     */
    public static String dibujarRectangulo(int base, int altura) {
        // Un StringBuilder en el cual se guardara el rectangulo.
        // Le damos una capacidad inicial igual al area del rectangulo.
        StringBuilder resultado = new StringBuilder(base * altura);
        
        // El caracter que se utilizara para dibujar el rectangulo
        char caracterParaDibujar = '*';
        
        for(int i = 0; i < altura; i++) {
            resultado.append(repetirCaracter(caracterParaDibujar, base));
            resultado.append("\n");
        }
        
        return resultado.toString();
    }
    
    /**
     * Repite un caracter una serie de veces (indicada).
     * 
     * @param caracter El caracter a repetir
     * @param repetir Cuantas veces se tiene que repetir el caracter
     * @return Una cadena con el caracter repatido las veces indicadas
     */
    public static String repetirCaracter(char caracter, int repetir) {
        resultado = new StringBuilder(repetir);
        
        for(int i = 0; i < repetir; i++) {
            resultado.append(caracter);
        }
        
        return resultado.toString();
    }
}
