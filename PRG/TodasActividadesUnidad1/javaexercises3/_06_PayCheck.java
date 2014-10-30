
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _06_PayCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours, tariff, bonus;
        
        // Leer la tarifa por hora
        System.out.print("Tarifa por hora: ");
        tariff = Integer.parseInt(scan.nextLine());
        
        // Leer las horas trabajadas
        System.out.print("Horas trabajadas: ");
        hours = Integer.parseInt(scan.nextLine());
        
        // Calcular las horas extras 
        bonus = (hours > 40) ? (hours - 40) : 0;
        hours = (hours > 40) ? 40 : hours;
        
        System.out.println("--------------------");
        System.out.println("Sueldo: " + (hours * tariff) + "€"); // El sueldo hasta las 40 horas
        System.out.println("Extras: " +  (bonus * (tariff * 1.5)) + "€"); // El sueldo a pratir de las 40 hopras
        System.out.println("--------------------");
        System.out.println("TOTAL: " +  (((hours * tariff)) + ((bonus * (tariff * 1.5)))) + "€" ); // Sueldo total
    }

}
