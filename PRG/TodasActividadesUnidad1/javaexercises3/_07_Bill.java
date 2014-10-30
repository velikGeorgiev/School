
package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author Velik Georgiev Chelebiev
 */
public class _07_Bill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amount;
        float sellPrice;
        
        // Leer las unidades adquiridas
        System.out.print("Unidades adquiridas: ");
        amount = Integer.parseInt(scan.nextLine());
        
        // Leer el precio de venta por unidad
        System.out.print("Precio de venta (unidad): ");
        sellPrice = Float.parseFloat(scan.nextLine());
        
        if(amount > 0) {
            float vat = 15; // El IVA ( % )
            float discount = 5; // El descuento ( % )
            
            /**
             *  Calcular los costes
             */
            float price = sellPrice * amount; // Precio SIN IVA
            float totalPrice = ((price * vat) / 100) + price; // El precio con la IVA ( sin descuento )
            float finalPrice = totalPrice; // Precio con descuento
            
            // Aplicando descuento, si la cantidad es superior a 500
            if(totalPrice > 500f) {
                finalPrice = totalPrice - ((totalPrice * discount) / 100f);
            }
            
            /**
             * Imprimir el ticket
             */
            System.out.println("\n-------------------------------");
            System.out.printf("%d und. * %.2f€    %.2f€\n\n", amount, sellPrice, price);
            System.out.printf("%.2f%% IVA    +%.2f€\n", vat, (totalPrice - price));
            
            // Si hay descuento lo aplicamos a la factura
            if(totalPrice > 500f) {
                System.out.printf("Descuento %.2f%%    -%.2f€\n", discount, ((totalPrice * discount) / 100));
            }
            
            System.out.println("-------------------------------");
            System.out.printf("Total a pagar: %.2f€\n", finalPrice);
        } else {
            System.out.println("Las unidades no pueden ser inferiores o iguales a 0.");
        }
    }
}
