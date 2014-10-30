
package examen_t3_pabloperez;
import java.util.*;
/**
 *
 * @author Pablo Pérez Santos
 */
public class Ejercicio1_PabloPerez {


	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int num;
		int aux;

		int comença = 0;
		int acaba;
		
		System.out.println("Condicions: ");
		System.out.println("·Que comence en 2.");
		System.out.println("·Que acabe en 2, 4 o 6.\n");
		
		int i = 0;
		do{
			System.out.print("Introdueix un nombre: ");
			num = entrada.nextInt();
			aux = num;
			acaba = aux%10;
			
			while ( aux != 0){
				comença = aux%10;
				aux /= 10;
			}		
			if (comença == 2 && (acaba == 2 || acaba == 4 || acaba == 6)){
				System.out.println("El número " + num + " cumpleix les condicions\n");
			}
			i++;
		}while(i < 10);
	}	
}
