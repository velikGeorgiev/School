package JavaMethods;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author velko
 */
public class OperacionMatematica {

    public static char[] opracionesValidas = new char[]{'*', '-', '/', '+'};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String equacion = null;
        StringBuilder primerNumero = new StringBuilder();
        StringBuilder segundoNumero = new StringBuilder();
        int numeroA, numeroB;

        char operacion = ' ';

        while (true) {

            primerNumero.delete(0, primerNumero.length());
            segundoNumero.delete(0, segundoNumero.length());
            operacion = ' ';

            equacion = scan.nextLine();

            for (int i = 0; i < equacion.length(); i++) {
                char currentChar = equacion.charAt(i);
                
                if(currentChar == ')' || currentChar == '(') {
                    continue;
                } 
                
                if (operacion == ' ') {
                    if (Character.isDigit(currentChar) || (primerNumero.length() <= 0 && currentChar == '-')) {
                        primerNumero.append(currentChar);
                    } else if (esOperacionValida(currentChar)) {
                        operacion = currentChar;
                    } else {
                        System.out.println("Formato no valido");
                        break;
                    }
                } else {
                    if (Character.isDigit(currentChar) || currentChar == '-') {
                        segundoNumero.append(currentChar);
                    }
                }
            }

            try {
                numeroA = Integer.parseInt(primerNumero.toString());
                numeroB = Integer.parseInt(segundoNumero.toString());
                
                System.out.println(calcular(numeroA, numeroB, operacion));
                
            } catch (Exception ex) {
                continue;
            }
        }
    }

    public static boolean esOperacionValida(char operacion) {
        for (char op : opracionesValidas) {
            if (operacion == op) {
                return true;
            }
        }

        return false;
    }

    public static int calcular(int numeroA, int numeroB, char op) {
        int resultado = 0;

        switch (op) {
            case '+':
                resultado = numeroA + numeroB;
                break;

            case '-':
                resultado = numeroA - numeroB;
                break;

            case '/':
                resultado = numeroA / numeroB;
                break;

            case '*':
                resultado = numeroA * numeroB;
                break;

            default:
                System.out.println("Operacion no valida");
                break;
        }
        
        return resultado;
    }
}
