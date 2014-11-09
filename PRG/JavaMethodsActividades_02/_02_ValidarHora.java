package EjercicionsTema04_02;

import java.util.Scanner;

/**
 * El programa comprueba si la hora introducida por
 * el usuario tiene un formato correcto.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _02_ValidarHora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Leemos la hora del terminal
        System.out.print("Introduce la hora: ");
        String hora = scan.nextLine();
        
        if(validarHoraRegExp(hora)) {
            System.out.println("El formato es correcto.");
        } else {
            System.out.println("El formato NO es correcto.");
        }
    }

    /**
     * Comprueba si la hora indicada tiene un fomato correcto.
     * En este metodo se utiliza una expresion regular.
     * 
     * @param hora La hora a comprobar
     * @return True si el formato de la hora es correcto y false en caso contrario
     */
    public static boolean validarHoraRegExp(String hora) {
        return hora.matches("([01][0-9]|2[0-3]):[0-5][0-9]");
    }
    
    /**
     * Comprueba si la hora indicada tiene un fomato correcto.
     * 
     * @param hora La hora a comprobar
     * @return True si el formato de la hora es correcto y false en caso contrario
     */
    public static boolean validarHora(String hora) {
        // Una hora valida no puede contener mas
        // de 5 caracteres
        if(5 != hora.length()) {
            return false;
        }
        
        // Separamos las horas de los minutos
        String[] horasSplit = hora.split(":");
        
        // Si horasSplit contiene mas de dos elementos el formato 
        // no sera correcto
        if(horasSplit.length != 2) {
            return false;
        }
        
        int horasTotal = Integer.parseInt(horasSplit[0]);
        int minutosTotal = Integer.parseInt(horasSplit[1]);
        
        // Comprobamos si las horas son validas 
        // Es decir no pueden ser menor que 00 y mayor que 23
        if(horasTotal < 0 || horasTotal > 23) {
            return false;
        }
        
        // Comprobamos si los minutos son validos 
        // Es decir no pueden ser menor que 00 y mayor que 59
        
        if(minutosTotal < 0 || minutosTotal > 59) {
            return false;
        }
        
        // Si todas las validaciones son correctas devolvemos true
        return true;
    }    
}
