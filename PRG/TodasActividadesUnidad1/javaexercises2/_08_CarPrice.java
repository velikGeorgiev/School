package javaexercises2;

/**
 *
 * @author vesprada
 */
public class _08_CarPrice {

    public static void main(String[] args) {
        // "Simulacion" de entrada de varios numeros
        int[] numbers = {100, 200, 251, 897, 321859, 23156, 2135, 546954};

        for (int currentPrice : numbers) {
            int temp = currentPrice;
            temp += (temp * 12) / 100;
            temp += (temp * 6) / 100;
            
            System.out.println("El coste total para " + currentPrice + "€ es de " + temp + "€");
        }
    }
}
