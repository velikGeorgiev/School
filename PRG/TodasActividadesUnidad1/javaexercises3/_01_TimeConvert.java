
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _01_TimeConvert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int minutes, days, hours;
        String strMinutes, strDays, strHours;
        
        // Leer los minutos
        System.out.print("Minutos: ");
        minutes = Math.abs(Integer.parseInt(scan.nextLine()));
        
        // Calcular dias
        days = minutes / 1440;
        hours = (minutes % 1440) / 60;
        minutes = (minutes % 1440) % 60;
        
        // Texto
        strDays = (days == 1) ? "dia" : "dias";
        strHours = (hours == 1) ? "hora" : "horas";
        strMinutes = (minutes == 1) ? "minuto" : "minutos";
        
        System.out.printf("%d%s %d%s %d%s\n", days, strDays, hours, strHours, minutes, strMinutes);
    }

}
