package javaexercises;

/**
 *
 * @author velko
 */
public class _20_21_NamePyramid {
    public static void main(String[] args) {
        String name = "Velko";
        
        for(int i = 1; i <= name.length(); i++) {
            System.out.println(name.substring(0, i));
        }
    }
}
