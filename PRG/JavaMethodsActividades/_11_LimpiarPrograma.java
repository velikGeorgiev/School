package EjercicionsTema04;

/**
 * Simula un CLEAR/CLS del terminal imprimiendo
 * 25 lineas nuevas.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _11_LimpiarPrograma {

    /**
     * Probando el metodo borrarPantalla().
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        borrarPantalla();
    }

    /**
     * Repite el caracter de nueva linea 25 veces
     * para simular un CLEAR/CLS al terminal.
     */
    public static void borrarPantalla() {
        System.out.println(repetirCaracter('\n', 25));
    }
    
    /**
     * Repite un caracter una serie de veces (indicada).
     * 
     * @param caracter El caracter a repetir
     * @param repetir Cuantas veces se tiene que repetir el caracter
     * @return Una cadena con el caracter repatido las veces indicadas
     */
    public static String repetirCaracter(char caracter, int repetir) {
        StringBuilder resultado = new StringBuilder(repetir);
        
        for(int i = 0; i < repetir; i++) {
            resultado.append(caracter);
        }
        
        return resultado.toString();
    }
}
