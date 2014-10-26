package javaexercises4;

import java.util.Scanner;

/**
 * El programa dibuja varias figuras segun las especificaciones del usuario.
 * @author Velik Georgiev Chelebiev
 * @version 0.0.2
 */
public class Figures {
        
    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // La opcion elegida por el usuario ( -1 para terminar el programa )
        int option = 0; 
        
        // La base, altura o tamaño de la figura.
        int base, height, size;
        
        /**
         * Antes de mostrar el menu le pediremos al usuario que
         * indique el tipo de caracteres que deasea utilizar para dibujar.
         * Si no se han indicado caracteres asignamos unos predeterminados
         */
        
        char drawChar = scanChar("Caracter para dibujar: ", '*');
        char backgroundChar = scanChar("Caracter para el fondo: ", ' ');
        
        // El objeto que se encarga de dibujar la figura
        FigureDraw draw = new FigureDraw(drawChar, backgroundChar);
        
        /**
         * Las opciones del menu y sus acciones corespondientes
         */
        do {
            option = menu();

            switch (option) {
                case 1:
                    size = scan("Lado: ");
                    draw.square(size, true);
                    break;
                case 2:
                    size = scan("Lado: ");
                    draw.square(size, false);
                    break;
                case 3:
                    base = scan("Base: ");
                    height = scan("Altura: ");
        
                    draw.rectangle(base, height, true);
                    break;
                case 4:
                    base = scan("Base: ");
                    height = scan("Altura: ");
        
                    draw.rectangle(base, height, false);
                    break;
                case 5:
                    base = scan("Base: ");
                    
                    draw.triangle(base);
                    break;
                case 6:
                    base = scan("Base (impar): ");
                    
                    draw.isosceles(base);
                    break;
                case 7:
                    base = scan("Base (impar): ");
                    
                    draw.romb(base);
                    break;
                default:
                    System.out.println("Operacion no valida.");
            }
        } while (option != -1);
    }
    
    /**
     * Muestra un texto y lee numero del teclado.
     * 
     * @param text El texto que se tiene que mostrar.
     * @return INT el numero introducido por el usuario
     */
    public static int scan(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        
        return Integer.parseInt(scan.nextLine());
    }
    
    /**
     * Muestra un texto y lee caracter del teclado.
     * 
     * @param text El texto que se tiene que mostrar.
     * @param defaultChar Caracter predeterminado. ( Se utiliza si no se introduce ninguno )
     * @return char el caracter introducido por el usuario
     */
    public static char scanChar(String text, char defaultChar) {
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        String input = scan.nextLine();
        
        if(input.equalsIgnoreCase("")) {
            return defaultChar;
        } else {
            return input.charAt(0);
        }
    }
        
    /**
     * Imprime el menu, y pide al usuario que elija una de las opciones
     * 
     * @return El numero de la opcion elegida
     */
    public static int menu() {
        String[] options = { "1: Cuadrado relleno", "2: Cuadrado vacio", 
                             "3: Rectangulo relleno", "4: Rectangulo vacio", "5: Triangulo rectangulo", 
                             "6: Triangulo isosceles", "7: Rombo"};
        
        System.out.println("Introduce el numero de la opcion: \n");
        for(String opt: options) {
            System.out.println("> " + opt);
        }
        
        System.out.print("Opcion: ");
        Scanner scan = new Scanner(System.in);
        
        return Integer.parseInt(scan.nextLine());
    }
}

/**
 * Clase dedicada a dibujar figuras en la pantalla del terminal.
 * OJO: La clase dibuja directamente no realiza returns con los resultados
 * 
 * @author Velik Georrgiev Chelebiev
 * @version 0.0.1
 */
class FigureDraw {
    
    // El caracter con el que se dibujara la figura
    private char figureChar;
    
    // El caracter con el que se rellenara el fondo
    private char backgroundChar;
    
    public FigureDraw() {
        this('*', ' ');
    }
    
    /**
     * El constructor asigna los caracteres que se utilizaran para dibujar
     * las figuras.
     * 
     * @param figureChar El caracter con el que se dibujara la figura
     * @param backgroundChar El caractecter que dibujara el vacio/fondo
     */
    public FigureDraw(char figureChar, char backgroundChar) {
        this.figureChar = figureChar;
        this.backgroundChar = backgroundChar;
    }
    
    /**
     * Repite un caracter las veces que se le indica.
     * 
     * @param ch El caracter que se repetira
     * @param times La cantidad de veces que se debe de repetir
     * @return Una cadena que contine el caracter indicado repetido las veces indicadas
     */
    public String repeatChar(char ch, int times) {
        StringBuilder sb = new StringBuilder(times);
        
        for(int i = 0; i < times; i++) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
    
    /**
     * Dibuja una figura cuadrada
     * 
     * @param fill Indica si la figura esta rellena o vacia
     * @param height La altura de la figura
     * @param base La base de la figura
     */
    protected void drawSquare(boolean fill, int height, int base) {
        
        if(fill) {
            for(int i = 0; i < height; i++) {
                System.out.println(this.repeatChar(this.figureChar ,base));
            }
        } else {
            for(int i = 0; i < height; i++) {
                if(i == 0) {
                    System.out.println(this.repeatChar(this.figureChar ,base));
                } else if(i == (height - 1)) {
                    System.out.println(this.repeatChar(this.figureChar ,base));
                }else{
                    System.out.println(this.figureChar + this.repeatChar(this.backgroundChar , (base - 2)) + this.figureChar);
                }
            }
        }
    }
    
    /**
     * Dibuja un cuadtrado
     * 
     * @param size El lado del triangulo
     * @param fill Indica si el triangulo esta vacio o relleno
     */
    public void square(int size, boolean fill) {
        
        this.drawSquare(fill, size, size);
    }
    
    /**
     * 
     * @param base El tamaño de la base de la figura
     * @param height La altura de la figura
     * @param fill Indica si la figura esta vacia o rellena
     */
    public void rectangle(int base, int height, boolean fill) {
        
        this.drawSquare(fill, base, height);
    }
    
    /**
     * Dibuja un triangulo
     * 
     * @param base La base del triangulo
     */
    public void triangle(int base) {
        
        for(int i = 1; i <= base; i++){
            System.out.println(this.repeatChar(this.figureChar, i));
        }
    }
    
    /**
     * Dibuja un triangulo isosceles.
     * 
     * @param base La base del triangulo. ( Deba ser impar ) 
     */
    public void isosceles(int base) {
        
        for(int i = 1; i <= base; i += 2) {
            int spaces = ((base - i) / 2);
            String line = this.repeatChar(this.backgroundChar, spaces);
            line += this.repeatChar(this.figureChar, i);
            line += this.repeatChar(this.backgroundChar, spaces);
            
            System.out.println(line);
        }
    }
    
    /**
     * El metodo dibuja un rombo.
     * Para ello utilizaremos tambien el metodo de dibujar un triangulo isosceles
     * 
     * @param base La base del rombo. ( Deba ser impar ) 
     */
    public void romb(int base) {
        
        this.isosceles(base);
        
        for(int i = base - 2; i >= 1; i -= 2){
            int spaces = ((base - i) / 2);
            String line = this.repeatChar(this.backgroundChar, spaces);
            line += this.repeatChar(this.figureChar, i);
            line += this.repeatChar(this.backgroundChar, spaces);
            
            System.out.println(line);
        }
    }
}
