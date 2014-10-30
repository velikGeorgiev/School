package javaexercises2;

/**
 *
 * @author velko
 */
public class _12_GradeToStringIf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "Simulacion" de entrada de varios numeros
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 34};
        
        for(int currentnumber : numbers) {
            if(currentnumber < 5) {
                System.out.println("Insuficiente");
            } else if(currentnumber == 5) {
                System.out.println("Suficiente");
            } else if (currentnumber == 6) {
                System.out.println("Bien");
            } else if(currentnumber == 7 || currentnumber == 8) {
                System.out.println("Notable");
            } else if(currentnumber == 9 || currentnumber == 10) {
                System.out.println("Sobresaliente");
            } else {
                System.out.println("La nota no es valida");
            }
        }
    }
}
