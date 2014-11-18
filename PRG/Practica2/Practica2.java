package practica2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author velko
 */
public class Practica2 {
    
    public static Scanner scan = new Scanner(System.in);
    
    public static StringBuilder listaDeOpciones = new StringBuilder();
    public static StringBuilder listaDePalabrasOcultas = new StringBuilder();
    
    public static String[] listaDeJugadores;
    public static String palabraOculta = "";
    
    public static final char SEPARADOR = ',';
    public static final char MASK_CHAR = '-';
   
    public static final boolean toLowerCaseAllUserInputs = true;
    public static boolean esMultijugador = false;
    
    public static int errors = 0;
    public static int solverBonus = 0;
    public static int fallosPermitidos = 8;
    
    public static void main(String[] args) {
        
        // Creamos las opciones disponibles
        agregarOpcion(1, "Introducir palabra");
        agregarOpcion(2, "Adivinar palabra");
        agregarOpcion(3, "Salir");
        agregarOpcion(4, "Introducir varias palabras");
        agregarOpcion(5, "Mas Opciones");
        agregarOpcion(6, "Estadisticas");
        
        elegirOpcion();
    }
    
    public static void elegirOpcion() {
        // Monstramos el menu
        System.out.println("\n" + listaDeOpciones);
        
        // Leemos la opcion del usuario
        int opcionElegida = leerNumero("Eliga una opcion: ");
        
        seleccionarOpcion(opcionElegida);
    }
    
    public static void seleccionarOpcion(int opcion) {
        switch(opcion) {
            case 1: 
                agregarNuevaPalabra();
            break;
                
            case 2:
                if(palabraOculta.equals("") && listaDePalabrasOcultas.length() == 0) {
                    imprimirError("No se encuentran palabras.");
                    elegirOpcion();
                } else if(listaDePalabrasOcultas.length() > 0) {
                    if(esMultijugador) {
                        multiJugador(true);
                    } else {
                        singleJugador(true);
                    }
                } else {
                    if(esMultijugador) {
                        multiJugador(false);
                    } else {
                        singleJugador(false);
                    }
                }
            break;
                
            case 3:
                return;
                
            case 4:
                agregarListaDePalabras();
                elegirOpcion();
            break;
                
            case 5:
                String multiStr = (esMultijugador) ? "Multijugador: " + listaDeJugadores.length : "Un Jugador";
                System.out.println(" > 1: Numero de jugadores (" + multiStr +")");
                System.out.println(" > 2: Limite de fallos (" + fallosPermitidos + ")");
                System.out.println(" > 3: Bonus puntos para el que resuelva la palabra (" + solverBonus + ")");
                
                // leer la opcion del sub menu
                int subOpcion = leerNumero("  > Opcion: ");
                
                switch(subOpcion) {
                    case 1:
                        int total = leerNumero("   > Numero de jugadores: ");
                        
                        if(total <= 1) {
                            esMultijugador = false;
                        } else {
                            esMultijugador = true;
                            definirJugadores(total);
                        }
                    break;
                        
                    case 2:
                        fallosPermitidos = leerNumero("    > Fallos permitidos: ");
                    break;
                    
                    case 3:
                        if(!esMultijugador) {
                            imprimirError("No estas en modo multijugador");
                        } else {
                            solverBonus = leerNumero("    > Bonus puntos: ");
                        }
                    break;
                        
                    default: 
                        imprimirError("La Sub opcion elegida no existe");
                    break;
                }
            break;
                
            default:
                imprimirError("Opcion no valida.");
            break;
        }
        
        elegirOpcion();
    }
    
    
    public static void singleJugador(boolean palabraAleatoria) {
        /**
         * Si el modo multijugador esta activo salimos del metodo.
         */
        if(esMultijugador == true) {
            return;
        }
        
        /**
         * Fallos cometidos
         */
        int fallos = 0;
        
        /**
         * Letra introducida por el jugador
         */
        char letra;
        
        /**
         * La palabra que el jugador debe de adivinar
         */
        String palabra;
        
        int acertaciones;
        
        /**
         * Si se quiere jugar con palabra aleatoria la elegimos
         * de la lista y si no utilizamos la palabra predifinada por el
         * usuario mediante la opcion 1
         */
        if(palabraAleatoria == true) {
            palabra = palabraAleatoria();
        } else {
            palabra = palabraOculta;
        }
        
        /**
         * La palabra representado por "-" por cada
         * letra oculta ( no descubierta )
         */
        StringBuilder mascara = new StringBuilder(repetirCaracter('-', palabra.length()));
        
        System.out.println(mascara);
        
        do {
            letra = leerCaracter("Introduce una letra: ");
            
            /**
             * Creamos la nueva mascara que contendra las letras
             * iguales a las intruducidas por el usuario descubiertas.
             */
            StringBuilder nuevaMascara = validarLetra(palabra, letra, mascara);
            
            /**
             *  Si las mascaras son iguales, la letra introducida por el 
             * jugador no es correcta, por lo tanto le sumamos un fallo. 
             * Si las mascaras no son iguales mostramos la letras en la mascara
             * y le pedimos que escriba otra letra.
             */
            if(nuevaMascara.toString().equals(mascara.toString())){
                fallos += 1;
            } else {
                acertaciones = diferencia(mascara, nuevaMascara);
                
                System.out.println("\nLa letra " + letra + " esta " + acertaciones + " veces\n");
                
                // Asignamos la nueva mascara
                mascara = nuevaMascara;
            }
            
            // Imprimimos la mascara actual
            System.out.println(mascara);
            
            /**
             * Si no hay jugadores con "vidas" mostramos la palabra
             */
            if(fallos >= fallosPermitidos) {
                imprimirError("Te has quedado sin intentos");
                break;
            }
        } while (!validarPalabra(mascara.toString()));
    }
    
    public static void multiJugador(boolean palabraAleatoria){ 
        /**
         * Si el modo multijugador no esta activo salimos del metodo.
         */
        if(esMultijugador == false) {
            return;
        }
        
        /**
         * Jugador al que le toca jugar
         */
        int jugador = 0;
        
        /**
         * La palabra que el jugador debe de adivinar
         */
        String palabra;
        
        /**
         * Letra introducida por el jugador
         */
        char letra;
        
        /**
         * La puntuacion de cada jugador
         */
        int[] puntuacion = new int[listaDeJugadores.length];
        
        /**
         * Los fallos cometidos por cada jugador
         */
        int[] fallos = new int[listaDeJugadores.length];
        
        int acertaciones;
        
        /**
         * Si se quiere jugar con palabra aleatoria la elegimos
         * de la lista y si no utilizamos la palabra predifinada por el
         * usuario mediante la opcion 1
         */
        if(palabraAleatoria == true) {
            palabra = palabraAleatoria();
        } else {
            palabra = palabraOculta;
        }
        
        /**
         * La palabra representado por "-" por cada
         * letra oculta ( no descubierta )
         */
        StringBuilder mascara = new StringBuilder(repetirCaracter(MASK_CHAR, palabra.length()));
        
        do {
            /**
             * Comprobamos si el numero del jugador esta en el rango.
             * Si no esta empezamos del jugador 0
             */
            if(jugador >= listaDeJugadores.length) {
                jugador = 0;
            }
            
            /**
             * Comprobamos si el jugador puede jugar
             */
            while(fallos[jugador] >= fallosPermitidos) {
                jugador = siguenteJugador(jugador);
            }
            
            letra = leerCaracter("(" + listaDeJugadores[jugador] + ")Introduce una letra: ");
            
            /**
             * Creamos la nueva mascara que contendra las letras
             * iguales a las intruducidas por el usuario descubiertas.
             */
            StringBuilder nuevaMascara = validarLetra(palabra, letra, mascara);
            
            /**
             *  Si las mascaras son iguales, la letra introducida por el 
             * jugador no es correcta, por lo tanto le sumamos un fallo
             * y pasamos al siguiente jugador. Si las mascaras no son iguales
             * sumamos los puntos correspondientes al jugador y le damos otro intento.
             */
            if(nuevaMascara.toString().equals(mascara.toString())){
                fallos[jugador] += 1;
                jugador = siguenteJugador(jugador);
            } else {
                // A la puntuacion del jugador se le sumara la cantidad
                // de letras descubiertas
                puntuacion[jugador] += diferencia(mascara, nuevaMascara);
                
                acertaciones = diferencia(mascara, nuevaMascara);
                
                System.out.println("\nLa letra " + letra + " esta " + acertaciones + " veces\n");
                
                // Si acaba de resolver la palabra le sumamos el bonus
                if(validarPalabra(nuevaMascara.toString())){
                    puntuacion[jugador] += solverBonus;
                    break;
                }
                
                // Asignamos la nueva mascara
                mascara = nuevaMascara;
            }
            
            // Imprimimos la mascara actual
            System.out.println(mascara);
            
            /**
             * Si no hay jugadores con "vidas" mostramos la palabra
             */
            if(jugadorEnJuego(fallos) == false) {
                imprimirError("No quedan jugadores con 'vidas'.");
                break;
            }
        } while(!validarPalabra(mascara.toString())); // El juego continua hasta que la mascara sea una palabra valida
        
        // Mostramos las puntuaciones
        System.out.println("===== Puntuaciones: ======");
        
        for(int i = 0; i < listaDeJugadores.length; i++) {
            System.out.println(listaDeJugadores[i] + ": " + puntuacion[i] + " puntos");
        }
        
        System.out.println("\nEl ganador es " + listaDeJugadores[indexDelValorMax(puntuacion)]);
    }
    
    public static int siguenteJugador(int jugadorActual) {
        jugadorActual++;
        
        if(jugadorActual >= listaDeJugadores.length){
            jugadorActual = 0;
        }
        
        return jugadorActual;
    }
    
    public static boolean jugadorEnJuego(int[] fallos) {
        for (int i = 0; i < fallos.length; i++) {
            if(fallos[i] < fallosPermitidos) {
                return true;
            }
        }
        
        return false;
    }
    
    public static int indexDelValorMax(int[] arr) {
        int numeroMaximo = Integer.MIN_VALUE;
        int index = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > numeroMaximo) {
                index = i;
                numeroMaximo = arr[i];
            }
        }
        
        return index;
    }
    
    public static void definirJugadores(int jugadores) {
        String nombreJugador;
        listaDeJugadores = new String[jugadores];
        
        for(int i = 0; i < jugadores; i++) {
            nombreJugador = leerCadena("    > Nombre del jugador: ");

            if(!validarPalabra(nombreJugador)){
                imprimirError("Nombre no valido");
                i--;
                continue;
            }
            
            listaDeJugadores[i] = nombreJugador;
        }
    }    
    
    public static StringBuilder validarLetra(String palabra, char letra, StringBuilder aMascara) {
        /**
         * Hacemos copia de la mascara para no sobreescribir
         * la mascara original
         */
        StringBuilder mascara = new StringBuilder(aMascara);
        
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
        imprimirError("Se borraran las palabras anteriores.");
        listaDePalabrasOcultas = new StringBuilder();
        
        String palabra;
        
        do {
            palabra = leerCadena("Introduce la palabra: ");
            
            if(!validarPalabra(palabra)) {
                imprimirError("La palabra no es valida");
                continue;
            }
            
            listaDePalabrasOcultas.append(palabra);
            listaDePalabrasOcultas.append(SEPARADOR);
        } while(!palabra.equals("end"));
    }
    
    public static String palabraAleatoria() {
        // Insertamos las palabras en un vector
        String[] palabras = listaDePalabrasOcultas.toString().split(String.valueOf(SEPARADOR));
        
        // Devolvemos una de estas palabras de forma aleatoria
        return palabras[new Random().nextInt((palabras.length - 1))];
    }
    
    public static void agregarNuevaPalabra() {
        String palabra = "";
        boolean palabraValida;
        
        do {
            palabra = leerCadena("Introduce la palabra: ");
            palabraValida = validarPalabra(palabra);
            
            if(!palabraValida) {
                imprimirError("La palabra no es valida");
            }
        } while(!palabraValida);
        
        palabraOculta = palabra;
    }
    
    public static void imprimirError(String error) {
        System.out.println("\n*** " + error + " ***\n");
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
    
    public static int diferencia(StringBuilder original, StringBuilder copia) {
        if(original == null || copia == null) {
            return -1;
        }
        
        int diferencia = Math.abs(original.length() - copia.length());
        int length = (original.length() < copia.length()) ? original.length(): copia.length();
        
        for(int i = 0; i < length; i++) {
            if(original.charAt(i) != copia.charAt(i)) {
                diferencia++;
            }
        }
        
        return diferencia;
    }
}
