
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _12_StudentGrades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int gradesCount = 0;
        
        // Tipos de notas
        int fail = 0, pass = 0;
        float sum = 0f, failSum = 0f, passSum = 0f;
        
        // Leer la cantidad de notas a ingresar
        System.out.print("Notas a ingresar: ");
        gradesCount = Integer.parseInt(scan.nextLine());
        
        // Array de notas
        float[] grades = new float[gradesCount];
        
        // Leer las notas
        for(int i = 0; i < gradesCount; i++) {
            System.out.print("Insertar nota: ");
            grades[i] = Float.parseFloat(scan.nextLine());
            sum += grades[i];
                    
            if(grades[i] < 5f) {
                fail++;
                failSum += grades[i];
            } else {
                pass++;
                passSum += grades[i];
            }
        }
        
        System.out.println("Aprobados: " + pass);
        System.out.println("Suspendidos: " + fail);
        System.out.println("Promedio: " + (sum / gradesCount));
        System.out.println("Promedio suspendidas: " + (failSum / fail));
        System.out.println("Promedio aprobadas: " + (passSum / pass));
    }
}
