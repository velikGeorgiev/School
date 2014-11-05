package EjercicionsTema04;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _03_Pow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double base = pedirNumero("Base: ", 50);
        double exp = pedirNumero("Exponente: ", 10);
        
        System.out.println("Resultado: " + Math.pow(base, exp));
    }
    
    public static double pedirNumero(String textoAMostrar, double maximo) {
        double numero = 0;
        
        Scanner scan = new Scanner(System.in);
        
        do {
            
            System.out.print(textoAMostrar); 
            numero = Double.parseDouble(scan.nextLine());
        } while(maximo < numero);

        
        return numero;
    }
}
