/**
 * @author Pablo Pérez Santos
 */

package examen_t3_pabloperez;
import java.util.*;

public class Ejercicoi3_PabloPerez {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int num1;
		int num2;
		int act;

		int intro = 3; //nombre de nombres introduïts. Comencem amb 3 perqué es impossible fer la comprobació amb menys nombres
		
		//Introduïm els tres primers nombres
		System.out.print("Introdueix un nombre: ");
		num1 = entrada.nextInt();
		System.out.print("Introdueix un nombre: ");
		num2 = entrada.nextInt();
		System.out.print("Introdueix un nombre: ");
		act = entrada.nextInt();
		
		while (num1 - num2 < act){
			System.out.println(num1 + " - "+ num2 + " = " + (num1-num2) + " < " + act); //traça per a que comproves que está bé
			num1 = num2; //l'antepenultim passa a ser el penúltim
			num2 = act; //el penúltim passa a ser lúltim.
			System.out.print("Introdueix un nombre: ");
			act = entrada.nextInt();
			intro++;
		}
		System.out.println("Has realitzat " + intro + " introduccions.");
		System.out.println(num1 + " - "+ num2 + " = " + (num1-num2) + " > " + act); //traça final que indica per qué el programa ha deixat de demanar nombres
	}	
}
