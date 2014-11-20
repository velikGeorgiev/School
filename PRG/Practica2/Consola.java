package haorcado;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class Consola {
    private static Scanner scan;
    private static Letras letrasPredeterminadas = Letras.Predeterminadas;
    
    static {
        scan = new Scanner(System.in);
    }
    
    public static enum Letras {
        Mayusculas, Minusculas, Predeterminadas
    }
    
    public static String leerCadena(String texto) {
        return leerCadena(texto, letrasPredeterminadas);
    }
    
    public static String leerCadena(String texto, Letras tipo) {
        String resultado = "";
        boolean entradaValida;
        
        do {
            entradaValida = true;
            
            try {
                System.out.print(texto);

                switch(tipo) {
                    case Mayusculas: 
                        resultado = scan.nextLine().toUpperCase();
                    break;

                    case Minusculas: 
                        resultado = scan.nextLine().toLowerCase();
                    break;

                    default:
                        resultado = scan.nextLine();
                    break;
                }
            } catch (Exception ex) {
                entradaValida = false;
            } 
        } while(!entradaValida);
                
        return resultado;
    }
    
    public static char leerCaracter(String texto) {
        return leerCaracter(texto, letrasPredeterminadas);
    }
    
    public static char leerCaracter(String texto, Letras tipo) {
        char resultado = ' ';
        boolean entradaValida;
        
        do {
            entradaValida = true;
            
            try {
                System.out.print(texto);

                switch(tipo) {
                    case Mayusculas: 
                        resultado = scan.nextLine().toUpperCase().charAt(0);
                    break;

                    case Minusculas: 
                        resultado = scan.nextLine().toLowerCase().charAt(0);
                    break;

                    default:
                        resultado = scan.nextLine().charAt(0);
                    break;
                }
            } catch (Exception ex) {
                entradaValida = false;
            } 
        } while(!entradaValida);
        
        return resultado;
    }
    
    public static int leerNumero(String texto) {
        int resultado = 0;
        boolean entradaValida;
        
        do {
            entradaValida = true;
            
            try {
                System.out.print(texto);
                resultado = Integer.parseInt(scan.nextLine());
            } catch (Exception ex) {
                entradaValida = false;
            } 
        } while(!entradaValida);
        
        return resultado;
    }
    
    public static boolean esCaracter(String cadena) {
        return (cadena.length() == 1);
    }
    
    public static void limpiar() {
        System.out.println(repetirCaracter('\n', 50));
    }
    
    public static String repetirCaracter(char ch, int rep) {
        StringBuilder resultado = new StringBuilder(rep);
        
        for(int i = 0; i < rep; i++) {
            resultado.append(ch);
        }
        
        return resultado.toString();
    }
    
    public static void imprimeTabla(String[] columnas, String[][] filas) {
        System.out.println("####################");
        
        for (int i = 0; i < columnas.length; i++) {
            System.out.print(columnas[i] + " | ");
        }
        
        System.out.println("\n####################");
        
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < filas[i].length; j++) {
                System.out.print(filas[i][j] + " | ");
            }
            
            System.out.println("");
        }
    }
}
