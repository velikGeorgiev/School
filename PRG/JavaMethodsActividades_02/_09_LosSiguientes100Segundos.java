
package JavaMethodsActividades_02;

import java.util.Scanner;

/**
 * Muestra los siguientes 100 segundos de una fecha introducida
 * por el usuario.
 * 
 * @author Velik Georgiev Chelebiev
 */
public class _09_LosSiguientes100Segundos {

    /**
     * Para no inicializar cada vez el mismo array con los
     * mismos valores hemos definido el vector diasDeLaSemana
     * como global, de esta forma le asignaremos los valores tan solo 
     * una vez.
     * 
     * OJO: Los dias tienen que estar ordenados de forma correcta.
     */
    public static final String[] diasDeLaSemana  = new String[] { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo" };
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        boolean fechaValida = false;
        String[] entradaUsuario = null;
        String dia = "";
        int hora = -1, minuto = -1, segundos = -1;
        
        do {
            System.out.print("Dia [Formato: DIA HORA MIN SEC]: ");
            entradaUsuario = scan.nextLine().split(" ");
            
            if(entradaUsuario.length != 4) {
                System.out.println("\n*** Incorrecto. Intentelo de nuevo. ***\n");
                continue;
            }
            
            dia = entradaUsuario[0];
            hora = Integer.parseInt(entradaUsuario[1]);
            minuto = Integer.parseInt(entradaUsuario[2]);
            segundos = Integer.parseInt(entradaUsuario[3]);
            
            if(!validaFecha(dia, hora, minuto, segundos)) {
                System.out.println("\n*** Incorrecto. Intentelo de nuevo. ***\n");
            } else {
                fechaValida = true;
            }
            
        } while(!fechaValida);
        
        System.out.println("\n\nLos siguientes 100 segundos: \n");
        
        int totalSec = deFechaASegundos(dia, hora, minuto, segundos);
        
        for(int i = 1; i <= 100; i++) {
            System.out.println(deSegundosAFecha(++totalSec));
        }
    }

    /**
     * Comprueba si una fecha es valida.
     * 
     * @param dia El dia de la semana
     * @param h La hora
     * @param m Los minutos
     * @param s Los segundo
     * @return TRUE si la fecha indicada es valida y FALSE en caso contrario.
     */
    public static boolean validaFecha(String dia, int h, int m, int s) {
        // Si el dia no es correcto devolvemos FALSE
        if(numeroDelDia(dia) <= 0) {
            return false;
        }
        
        // Si la hora no es valida devolvemos FALSE
        if(!enRango(0, 23, h) || !enRango(0, 59, m) || !enRango(0, 59, s)) {
            return false;
        }
        
        // Si llegamos a este punto todo es correcto y devolvemos TRUE
        return true;
    }
    
    /**
     * Devuelve el dia al que corresponde un numero indicado.
     * 
     * @param dia Numero del dia
     * @return El dia al que corresponde el numero. Si el dia no se encuentra se devolvera null.
     */
    public static String deNumeroADia(int dia) {
        /**
         * Ya que usaremos la variable dia como index
         * del elemento del vector le restamos 1 para que
         * sea un indice correcto.
         */
        dia -= 1;
        
        /**
         * Si el indice ( el dia ) indicado no se encuentra
         * en el vector definido devolveremos null.
         */
        if(dia < 0 || dia >= diasDeLaSemana.length) {
            return null;
        }
        
        return diasDeLaSemana[dia];
    }
    
    /**
     * El metodo devuelve el valor numerico de un dia de la semana.
     * Para Lunes devolvera 1, Martes 2 etc. hasta Domingo 7
     * Si el dia no se encuentra el metodo devolvera 0
     * 
     * @param dia Un dia de la semana valido (Lunes, Martes ... Domingo )
     * @return EL numero del dia de la semana. Si no se encuentra devolvera 0
     */
    public static int numeroDelDia(String dia) {
        /**
         * En la variable index se guardara la posicion
         * del dia en el vector si se encuetra. 
         * El numero del dia seria la posicion + 1.
         */
        int index = -1, i = 0;
        
        /**
         * Buscamos el dia indicado en el vector mediante un bucle.
         * El bucle se interumpira cuando encuentre el dia o llegue 
         * al final del vector que contiene los dias de la semana.
         */
        do {
            // Si encontramos el dia guardamos su posicion en la variable
            // index para devolverse la al usuario. 
            // OJO: los dias en el vector tinen que estan ordenados
            if(diasDeLaSemana[i].toLowerCase().equals(dia.toLowerCase())) {
                index = i;
            }
        } while(!(i++ >= (diasDeLaSemana.length - 1) || index > -1));
        
        // Al index le sumamos 1 ya que el index inicial del vector es 0.
        // En caso de no haber le sumado 1 devolveria 0 para lunes y 6 para domingo.
        return (index + 1);
    }
    
    /**
     * Convierte un dia de la semana con su hora, minutos y segundos en segundos.
     * 
     * @param dia El dia de la semana
     * @param h La hora
     * @param m Los minutos
     * @param s Los segundo
     * @return Los segundos pasados desde el inicio de la semana hasta la fecha indicada
     */
    public static int deFechaASegundos(String dia, int h, int m, int s) { 
        return (((numeroDelDia(dia) - 1) * 86400) + (h * 3600) + (m * 60) + s);
    }
    
    /**
     * Convierte segundos en un dia, hora, minutos, segundos valudos.
     * 
     * @param s Segundos
     * @return El dia y la hora exacta de la semana
     */
    public static String deSegundosAFecha(int s) {
        int dia = (s / 86400) + 1;
        int horas = (s % 86400) / 3600;
        int minutos = ((s % 86400) % 3600) / 60;
        int segundos = ((s % 86400) % 3600) % 60;
        
        return (deNumeroADia(dia) + " " + horas + " " + minutos + " " + segundos);
    }
    
    /**
     * Comprueba si un numero esta en un rango.
     * 
     * @param min El valor minimo del rango (incluido)
     * @param max El valor maximo del rango (incluido)
     * @param num El numero a comptrobar
     * @return Devuelve TRUE si el numero esta en el rango y FALSE en caso contrario
     */
    public static boolean enRango(int min, int max, int num) {
        return (num >= min && num <= max);
    }
}
