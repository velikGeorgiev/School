package EjercicionsTema04_02;

import java.util.Scanner;

/**
 * Calcula la diferencia entre dos hora en minutos.
 * 
 * @author Velik Georgiev Chelebiev
 * @version 0.0.1
 */
public class _03_DiferenciaMinutos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // En las siguientes variables se guardaran
        // las dos horas introducidas por el usuario
        String primeraHora, segundaHora;
        
        // En la siguiente variable se indicara si las horas 
        // introducidas son correctas
        boolean horasValidas = true;
        
        /**
         * Le pedimos al usuario que nos introduzca las dos horas.
         */
        do {
            System.out.print("Introduce la primera hora: ");
            primeraHora = scan.nextLine();

            System.out.print("Introduce la segunda hora: ");
            segundaHora = scan.nextLine();
            
            horasValidas = true;
            
            /**
             * Comprobamos si las horas son validas.
             * Si no los son imprimimos un mensaje de error y le asignamos a la variable
             * horasValidas el valor FALSE para que el bucle se vuelva a repetir
             */
            if(!validarHora(primeraHora) || !validarHora(segundaHora)) {
                System.out.println("El formato de la hora no es correcto.");
                horasValidas = false;
            }
        } while (!horasValidas);
        
        /**
         * Separamos las horas de los minutos.
         */
        String[] primeraHoraSplit = primeraHora.split(":");
        String[] segundaHoraSplit = segundaHora.split(":");

        // Calculamos la diferencia
        int diferencia = minutosDiferencia(primeraHoraSplit, segundaHoraSplit);
        
        // Imprimimos el resultado
        String unidad = (diferencia == 1) ? "min" : "mins";
        
        System.out.println("Diferencia en minutos entre las dos horas: " + diferencia + " " + unidad);
    }
    
    
    /**
     * Calcula la diferencia en minutos entre dos horas dadas.
     * 
     * @param primeraHora La primera hora
     * @param segundaHora La segunda hora
     * @return La diferencia entre las dos horas
     */
    public static int minutosDiferencia(String[] primeraHora, String[] segundaHora) {
        // Calculamos el total minutos de la primera hora
        int totalMinutosPrimeraHora = (Integer.parseInt(primeraHora[0]) * 60) + Integer.parseInt(primeraHora[1]);
        
        // Calculamos el total minutos de la segunda hora
        int totalMinutosSegundaHora = (Integer.parseInt(segundaHora[0]) * 60) + Integer.parseInt(segundaHora[1]);
        
        // Calculamos la diferencia
        int diferencia = Math.abs(totalMinutosPrimeraHora - totalMinutosSegundaHora);
        
        // Devolvemos la diferencia entre ambas horas
        return diferencia;
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
