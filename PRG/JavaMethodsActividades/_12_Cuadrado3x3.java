package EjercicionsTema04;

/**
 * El programa se encarga de dibujar un cuadrado de dimensiones
 * fijas 3x3.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _12_Cuadrado3x3 {

    private static StringBuilder resultado = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dibujarCuadrado3x3();
    }
    
    /**
     * Imprime un cuadrado con dimensiones 3x3.
     * 
     * Para ello llama el metodo imprimirRectangulo 
     * pasandole dos argumentos iguales (altura y base son iguales)
     */
    public static void dibujarCuadrado3x3() {
        int size = 3;
        
        imprimirRectangulo(size, size);
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
