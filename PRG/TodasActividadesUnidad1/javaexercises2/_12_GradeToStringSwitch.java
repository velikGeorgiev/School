package javaexercises2;

/**
 *
 * @author velko
 */
public class _12_GradeToStringSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "Simulacion" de entrada de varios numeros
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 23};
        
        for(int currentnumber : numbers) {
            switch(currentnumber) {
                case 0:
                case 1: 
                case 2:
                case 3:
                case 4:
                    System.out.println("Insuficiente");
                    break;
                case 5:
                    System.out.println("Suficiente");
                    break;
                case 6:
                    System.out.println("Bien");
                    break;
                case 7:
                case 8:
                       System.out.println("Notable");
                       break;
                case 9:
                case 10:
                        System.out.println("Sobresaliente");
                        break;
                default: 
                        System.out.println("La nota no es valida");
            }
        }
    }

}
