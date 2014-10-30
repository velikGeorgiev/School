package javaexercises3;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class _19_Actualizado {

    private static final int TOTAL_NAMES = 5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = new String[TOTAL_NAMES];
        String keyWord = "";
        
        for(int i = 0; i < TOTAL_NAMES; i++) {
            System.out.print("Nombre (" + (i + 1) + "/" + TOTAL_NAMES + "): ");
            names[i] = scan.nextLine().trim();
        }
        
        do {
            System.out.print("Letra: ");
            keyWord = scan.nextLine().trim();
            
            if(keyWord.equalsIgnoreCase("fin")) {
                break;
            }
            
            for(String name: names) {
                if(name.charAt(0) == keyWord.charAt(0)) {
                    System.out.println("-->[" + name + "]");
                }
            }
        } while (true);
    }
}
