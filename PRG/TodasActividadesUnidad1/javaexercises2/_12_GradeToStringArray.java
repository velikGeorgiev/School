package javaexercises2;

/**
 *
 * @author velko
 */
public class _12_GradeToStringArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "Simulacion" de entrada de varios numeros
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 23, 1};
        
        // Notas
        String[] gradesString = new String[11];
        
        // Definir notas asignando su calificacion.
        gradesString[0] = "Insuficiente";
        gradesString[1] = "Insuficiente";
        gradesString[2] = "Insuficiente";
        gradesString[3] = "Insuficiente";
        gradesString[4] = "Insuficiente";
        gradesString[5] = "Suficiente";
        gradesString[6] = "Bien";
        gradesString[7] = "Notable";
        gradesString[8] = "Notable";
        gradesString[9] = "Sobresaliente";
        gradesString[10] = "Sobresaliente";
        
        for(int currentNumber : numbers ){
            try{
                System.out.println(gradesString[currentNumber]);
            } catch(Exception ex) {
                // Si la matriz no contiene el index dado
                // significa que la nota no es valida. Por lo tanto 
                // imprimimos un texto de error.
                System.out.println("Nota no valida.");
            }
        }
    }

}
