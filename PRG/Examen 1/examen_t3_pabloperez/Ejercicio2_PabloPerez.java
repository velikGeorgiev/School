
package examen_t3_pabloperez;
import java.util.*;
/**
 *
 * @author Pablo Pérez Santos
 */
public class Ejercicio2_PabloPerez {


	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int tabla = 0;
		int opcion;
		do{
			System.out.println("\nTABLES DE MULTIPLICAR");
			System.out.println("********************************");
			System.out.println("1.- Tabla del 3");
			System.out.println("2.- Tabla del 4");
			System.out.println("3.- Tabla del 5");
			System.out.println("0.- Salir");
			System.out.print("\nIntrodueix una opció: ");
			opcion = entrada.nextInt();

			switch (opcion){
				case 0: break;
				case 1: tabla = 3;break;
				case 2: tabla = 4;break;
				case 3: tabla = 5;break;	
			}
			if (opcion < 0 || opcion > 3) System.out.println("Opció erronea!");
			else if (opcion != 0){
				System.out.println("\nTabla del " + tabla);
				for (int i = 0; i < 11; i++) {
					System.out.println(tabla + " X " + i + " = " + tabla*i);
				}
			}
		}while (opcion != 0);
	}
	
}
