package javaexercises2;


/**
 *
 * @author velko
 */
public class _09_Resturant {
    public static void main(String[] args) {
        // Coste , cantidad
        // el index 0 sera el coste
        // el index 1 sera la cantidad
        int[] jamon = { 2, 3 };
        int[] queso = { 1, 5 };
        int[] patatasFritas = { 3, 2 };
        int[] beer = { 1, 120 };
        
        // Calculamos el total individual
        int totalJamon = jamon[0] * jamon[1];
        int totalQueso = queso[0] * queso[1];
        int totalPatatas = patatasFritas[0] * patatasFritas[1];
        int totalBeer = beer[0] * beer[1];
        
        // El total del pedido
        int orderTotal = totalJamon + totalQueso + totalPatatas + totalBeer;
        
        // El resultado sera imprimido en forma de ticket
        System.out.println("---------------------------------");
        System.out.printf("%d Jamon          * %d€    %d€\n", jamon[1], jamon[0], totalJamon);
        System.out.printf("%d Queso          * %d€    %d€\n", queso[1], queso[0], totalQueso);
        System.out.printf("%d Patatas Fritas * %d€    %d€\n", patatasFritas[1], patatasFritas[0], totalPatatas);
        System.out.printf("%d Cerveza      * %d€    %d€\n", beer[1], beer[0], totalBeer);
        System.out.println("---------------------------------");
        System.out.println("Total:                   " + orderTotal + "€");
        
    }
}
