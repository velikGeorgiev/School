package EjercicionsTema04_02;

/**
 *
 * @author velko
 */
public class _07_TransformarLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char letra = 'A';
        int distancia = Character.toUpperCase(letra) - Character.toLowerCase(letra);
        System.out.println((char)(letra - distancia));
    }

}
