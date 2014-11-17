package practica2;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class Practica2 {
    
    public static StringBuilder listaDeOpciones = new StringBuilder();
    public static Scanner scan = new Scanner(System.in);
    
    public static StringBuilder listaDePalabrasOcultas = new StringBuilder();
    public static String palabraOculta = "";
    public static final char separadorPalabras = ',';
    public static boolean toLowerCaseAllUserInputs = true;
    public static int errors = 0;
    
    public static void main(String[] args) {
        
        // Creamos las opciones disponibles
        agregarOpcion(1, "Introducir palabra");
        agregarOpcion(2, "Adivinar palabra");
        agregarOpcion(3, "Salir");
        agregarOpcion(4, "Introducir varias palabras");
        
        elegirOpcion();
    }
    
    public static void elegirOpcion() {
        // Monstramos el menu
        System.out.println(listaDeOpciones);
        
        // Leemos la opcion del usuario
        int opcionElegida = leerNumero("Eliga una opcion: ");
        
        seleccionarOpcion(opcionElegida);
    }
    
    public static void seleccionarOpcion(int opcion) {
        switch(opcion) {
            case 1: 
                agregarNuevaPalabra();
                elegirOpcion();
            break;
                
            case 2:
                adivinarPalabra(false);
            break;
                
            case 3:
                return;
                
            case 4:
                agregarListaDePalabras();
                elegirOpcion();
            break;
        }
    }
    
    public static void adivinarPalabra(boolean palabraAleatoria) {
        String palabra = "";
        StringBuilder mascara;
        char caracter;
        
        if(palabraAleatoria == true) {
            
        } else {
            palabra = palabraOculta;
        }
        
        mascara = new StringBuilder(repetirCaracter('-', palabra.length()));
        
        do {
            caracter = leerCaracter("Introduce una letra: ");
            StringBuilder nuevaMascara = validarLetra(palabra, caracter, mascara);
            
            if(nuevaMascara.toString().endsWith(mascara.toString())){
                errors++;
            } else {
                mascara = nuevaMascara;
            }
            
            System.out.println(mascara);
        } while(!validarPalabra(mascara.toString()) || errors < 8);
    }
    
    public static StringBuilder validarLetra(String palabra, char letra, StringBuilder mascara) {
        for(int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i) == letra) {
                mascara.setCharAt(i, letra);
            }
        }
        
        return mascara;
    }
    
    public static String repetirCaracter(char ch, int repetir) {
        StringBuilder resultado = new StringBuilder(repetir);
        
        for(int i = 0; i < repetir; i++) {
            resultado.append(ch);
        }
        
        return resultado.toString();
    }
    
    public static void agregarListaDePalabras() {
        System.out.println("\nSe borraran las palabras anteriores.\n");
        listaDePalabrasOcultas = new StringBuilder();
        
        String palabra = "";
        
        do {
            palabra = leerCadena("Introduce la palabra: ");
            
            if(!validarPalabra(palabra)) {
                System.out.println("La palabra no es valida");
                continue;
            }
            
            listaDePalabrasOcultas.append(palabra);
            listaDePalabrasOcultas.append(separadorPalabras);
        } while(!palabra.equals("end"));
    }
    
    public static void agregarNuevaPalabra() {
        String palabra = "";
        boolean palabraValida = false;
        
        do {
            palabra = leerCadena("Introduce la palabra: ");
            palabraValida = validarPalabra(palabra);
            
            if(!palabraValida) {
                System.out.println("La palabra no es valida");
            }
        } while(!palabraValida);
        
        palabraOculta = palabra;
    }
    
    public static boolean validarPalabra(String palabra) {
        for(int i = 0; i < palabra.length(); i++) {
            if(!Character.isAlphabetic(palabra.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    public static String leerCadena(String texto) {
        System.out.print(texto);
        
        if(toLowerCaseAllUserInputs) {
            return scan.nextLine().toLowerCase();
        }
        
        return scan.nextLine();
    }
    
    public static char leerCaracter(String texto) {
        System.out.print(texto);
        
        if(toLowerCaseAllUserInputs) {
            return Character.toLowerCase(scan.nextLine().charAt(0));
        }
        
        return scan.nextLine().charAt(0);
    }
    
    public static int leerNumero(String texto) {
        System.out.print(texto);
        
        return Integer.parseInt(scan.nextLine());
    }
    
    public static void agregarOpcion(int codigo, String nombreDeLaOpcion) {
        listaDeOpciones.append(codigo);
        listaDeOpciones.append(": ");
        listaDeOpciones.append(nombreDeLaOpcion);
        listaDeOpciones.append("\n");
    }
    
}
