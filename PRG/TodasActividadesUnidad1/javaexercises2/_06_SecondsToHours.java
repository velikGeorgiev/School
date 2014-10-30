package javaexercises2;

/**
 *
 * @author velko
 */
public class _06_SecondsToHours {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int seconds = 7261; // input data
        
        int hours = seconds / 3600;
        int minutes = (seconds - hours * 3600) / 60;
        int secondsConverted = seconds % 60;
        
        System.out.printf("%d segundos son: %d horas %d minutos %d segundos", seconds, hours, minutes, secondsConverted);
    }

}
