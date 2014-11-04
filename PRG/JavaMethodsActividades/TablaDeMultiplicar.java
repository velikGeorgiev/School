package JavaMethods;

/**
 *
 * @author velko
 */
public class TablaDeMultiplicar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            imprimirTabla(i);
        }
    }
    
    public static StringBuilder tablaDeMultiplicar(int num) {
        StringBuilder resultado = new StringBuilder(100);
        
        for(int i = 1; i <= 10; i++) {
            resultado.append(num).append(" * ").append(i).append(" = ").append(producto(num, i)).append("\n");
        }
        
        return resultado;
    }
    
    public static int producto(int a, int b) {
        return (a * b);
    }
    
    public static void imprimirTabla(int[] numeros) {
        for(int numero: numeros) {
            System.out.println("Tabla del " + numero);
            System.out.println(repeatString("-", 20) + "\n");
            System.out.println(tablaDeMultiplicar(numero));
        }
    }
    
    public static void imprimirTabla(int numero) {
        imprimirTabla(new int[] { numero } );
    }
    
    public static String repeatString(String str, int veces) {
        StringBuilder resultado = new StringBuilder(str.length() * veces);
        
        for(int i = 0; i < veces; i++) {
            resultado.append(str);
        }
        
        return resultado.toString();
    }
}
