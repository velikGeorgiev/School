package juego;

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
    public static char MASK_CHAR = (char)9607;
   
    public static final boolean toLowerCaseAllUserInputs = true;
    public static boolean esMultijugador = false;
    
    public static int solverBonus = 0;
    public static int fallosPermitidos = 8;
    
    public static void main(String[] args) {
        
        // Creamos las opciones disponibles
        agregarOpcion(1, "Introducir palabra");
        agregarOpcion(2, "Adivinar palabra");
        agregarOpcion(3, "Salir");
        agregarOpcion(4, "Introducir varias palabras");
        agregarOpcion(5, "Mas Opciones");
        
        dibujarLogo();
        
        elegirOpcion(false);
    }
   
    /**
     * Imprime el menu en la pantalla del terminal, pediendo le al usuario
     * que eliga una opcion.
     * Previamente la pantalla se limpia.
     * Despues de haber seleccionado una de las opciones mostradas
     * se ejecutara su correspondiente accion. En caso de que 
     * la opcion no es valida se volvera a llamar este metodo.
     */
    public static void elegirOpcion(boolean limpiarPantalla) {
        
        if(limpiarPantalla) {
            // Cada vez que entremos en el programa limpiamos la pantalla
            limpiarPantalla();
        }
        
        // Monstramos el menu
        System.out.println("\n" + listaDeOpciones);
        
        // Leemos la opcion del usuario
        int opcionElegida = leerNumero("Eliga una opcion: ");
        
        seleccionarOpcion(opcionElegida);
    }
    
    /**
     * Realiza una operacion o una serie de operaciones segun la opcion elegida.
     * Este metodo representa la implementacion de la opcion elegida por el usuario
     * mediante el metodo elegirOpcion().
     * 
     * Si la opcion elegida no es valida se volvera a llamar el metodo elegirOpcion()
     * 
     * @param opcion La opcion elegida
     */
    public static void seleccionarOpcion(int opcion) {
        // Indica si el jugador desea
        // hacer otra partida
        String otraPartida = "no";
        
        switch(opcion) {
            /**
             * La opcion 1 le permite al jugador ingresar una palabra con la 
             * que se jugara.
             */
            case 1: 
                agregarNuevaPalabra();
            break;
                
            /**
             * La opcion 2 es la opcion de jugar.
             * Si no hay ninguna palabra definida, ni lista de palabras
             * se mostrara un mensaje de error y se mostrara el menu de opciones.
             */
            case 2:
                if(palabraOculta.equals("") && listaDePalabrasOcultas.length() == 0) {
                    imprimirError("No se encuentran palabras.");
                    
                    // Le pedimos al usuario que introduzca intro
                    // para ver el menu 
                    leerCadena("Pulsa [INTRO] para continuar: ");
                    
                    elegirOpcion(true);
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
                
                otraPartida = leerCadena("Desea salir del juego (si/no): ");
            break;
                
            case 3:
                return;
                
            case 4:
                agregarListaDePalabras();
                elegirOpcion(true);
            break;
                
            case 5:
                String multiStr = (esMultijugador) ? "Multijugador: " + listaDeJugadores.length : "Un Jugador";
                System.out.println(" > 1: Numero de jugadores (" + multiStr +")");
                System.out.println(" > 2: Limite de fallos (" + fallosPermitidos + ")");
                System.out.println(" > 3: Bonus puntos para el que resuelva la palabra (" + solverBonus + ")");
                System.out.println(" > 4: Cambiar la mascara del juego (" + MASK_CHAR + ")");
                
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
                        
                    case 4:
                        MASK_CHAR = leerCaracter("    > Introduce la nueva mascara: ");
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
        
        if(!otraPartida.equals("si")) {
            elegirOpcion(true);
        }
    }
    
    /**
     * Jugar al AHORCADO en modo de un jugador.
     * 
     * En este modo no se llevara un contador de puntos ya que sera solo un 
     * jugador.
     * 
     * El metodo pide al jugador introducir un caracter y comprueba si el caracter
     * esta en la palabra escondida. Si el caracter esta se muestran todas sus ocurrencias
     * y se vuelve a pedir al usuario que introduzca otro. 
     * 
     * Si el jugador se pase del limite de los fallos maximos permitidos
     * el juego termina mostrando la palabra escondida.
     * 
     * @param palabraAleatoria 
     */
    public static void singleJugador(boolean palabraAleatoria) {
        /**
         * Si el modo multijugador esta activo salimos del metodo.
         */
        if(esMultijugador == true) {
            return;
        }
        
        limpiarPantalla();
                
        /**
         * Fallos cometidos
         */
        int fallos = 0;
        
        /**
         * Letra introducida por el jugador
         */
        char letra;
        
        /**
         * La entrada original del usuario ( sea letra o cadena )
         */
        String entradaUsuario;
        
        /**
         * La palabra que el jugador debe de adivinar
         */
        String palabra;
        
        /**
         * Cantidad de lentras/caracteres acertados
         */
        int aciertos;
        
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
        StringBuilder mascara = crearMascara(palabra);
        
        // Imprimimos la mascara
        imprimirMascara(mascara, 0);
        
        do {     
            // Lee la entrada del usuario
            entradaUsuario = leerCadena("Introduce letra o la palabra: ");
            
            /**
             * Si la entrada del usuario es una cadena nos salimos del
             * bucle y posteriormente se comprobara si la palabra introducida por el usuario 
             * es correcta o no. Si se introduce un caracter/letra se comprueba si esta.
             * Si es una valor vacio le volvemos a pedir que introduzca una palabra o letra/caracter
             */
            if(entradaUsuario.length() > 1) {                
                break;
            } else if(entradaUsuario.length() < 1) {
                continue;
            }
        
            // Si se ha introducido solo 1 letra la cogemos
            letra = entradaUsuario.charAt(0);
            
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
                // Calculamos las diferencias entre la nueva mascara y la vieja 
                // cada diferencia sera un acierto
                aciertos = diferencia(mascara, nuevaMascara);
                
                System.out.println("\nLa letra " + letra + " esta " + aciertos + " veces\n");
                
                // Asignamos la nueva mascara
                mascara = nuevaMascara;
            }
            
            // Antes de imprimir la nueva mascara borramos la anterior
            limpiarPantalla();
            
            // Imprimimos la mascara actual
            imprimirMascara(mascara, fallos);
            
            /**
             * Si no hay jugadores con "vidas" mostramos la palabra
             */
            if(fallos >= fallosPermitidos) {
                imprimirError("Te has quedado sin intentos. La palabra era: " + palabra);
                break;
            }
        } while (!validarPalabra(mascara.toString()));
        
        if((validarPalabra(mascara.toString()) || entradaUsuario.equals(palabra)) && fallos < fallosPermitidos) {
            dibujaTexto("Ganas", 10);
        } else {
            dibujaTexto("Pierdes", 10);
        }
    }
    
    /**
     * Crea una mascara ( cambiando las letras por algun caracter predefinido ) para la palabra indicada.
     * 
     * @param palabra La palabra para la cual se quiere crear una mascara
     * @return La mascara de la palabra
     */
    public static StringBuilder crearMascara(String palabra) {
        StringBuilder resultado = new StringBuilder(palabra.length());
        
        for(int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i) == ' ') { 
                resultado.append(" ");
            } else {
                resultado.append(MASK_CHAR);
            }
        }
        
        return resultado;
    }
    
    /**
     * Jugar al AHORCADO en modo de multijugador.
     * A diferencia del modo de un jugador, en este modo jugaran varios jugadores
     * se llevara una puntuacion y habra un ganador.
     * 
     * El metodo pide al jugador introducir un caracter y comprueba si el caracter
     * esta en la palabra escondida. Si el caracter esta se muestran todas sus ocurrencias
     * y al jugador se le suman puntos iguales a todas las acertaciones de la letra introducida.
     * Si el jugador adivina la letra vuelve a ser su turno, en caso contrario
     * pasamos al siguiente jugador.
     * 
     * @param palabraAleatoria Indica si se juega con palabra aleatoria 
     *                         o con solo una palabra previamente introducida.
     */
    public static void multiJugador(boolean palabraAleatoria){ 
        /**
         * Si el modo multijugador no esta activo salimos del metodo.
         */
        if(esMultijugador == false) {
            return;
        }
        
        // Se limpia la pantalla
        limpiarPantalla();
        
        /**
         * Jugador al que le toca jugar
         */
        int jugador = 0;
        
        /**
         * La entrada original del usuario ( sea letra o cadena )
         */
        String entradaUsuario;
        
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
        
        /**
         * El numero de veces que aparece la letra introducida )
         */
        int aciertos;
                
        /**
         * Si se quiere jugar con palabra aleatoria la elegimos
         * de la lista y si no utilizamos la palabra predifinada por el
         * usuario mediante la opcion 1
         */
        if(palabraAleatoria == true) {
            // Genera una palabra aleatoria a partir de la lista
            palabra = palabraAleatoria();
        } else {
            palabra = palabraOculta;
        }
        
        /**
         * La palabra representado por "-" por cada
         * letra oculta ( no descubierta )
         */
        StringBuilder mascara = crearMascara(palabra);
        
        // Imprimimos la mascara
        imprimirMascara(mascara, 0);
        
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
            
            // Lee la entrada del jugador actual
            entradaUsuario = leerCadena("(" + listaDeJugadores[jugador] + ") Introduce letra o la palabra: ");
            
            /**
             * Si la entrada del usuario es una cadena nos salimos del
             * bucle y posteriormente se comprobara si la palabra introducida por el usuario 
             * es correcta o no. Si se introduce un caracter/letra se comprueba si esta.
             * Si es una valor vacio le volvemos a pedir que introduzca una palabra o letra/caracter
             */
            if(entradaUsuario.length() > 1) {       
                // Si la palabra es correcta calculamos la puntuacion + el bonus definido
                // y salimos del bucle. Posteriormente se mostrara el resutlado de la partida
                // Si la palabra no es correcta el jugaro ya no podra jugar en esta partida
                if(entradaUsuario.equals(palabra)) {
                    int difPalabras = diferencia(new StringBuilder(entradaUsuario), mascara);
                    puntuacion[jugador] += (difPalabras + solverBonus);
                    break;
                } else {
                    // Ya que el jugador no adivino la palabra entere
                    // le asignamos la maxima cantidad de fallos para que no pueda jugar
                    // Como en el principio del bucle ya comprobamos que jugador podra jugar
                    // el actual se descontara y pasara automaticamente al siguiente.
                    fallos[jugador] = fallosPermitidos;
                    
                    // Mostramos Un mensaje de que el juego para el termina
                    dibujaTexto("Pierdes", listaDeJugadores[jugador], 4);
                    
                    // Ya que el metodo dibujaTexto "limpiara" la pantalla
                    // imprimimos la mascara para el sisuiente jugador que pueda jugar
                    int siguienteJugador = jugador;
                    
                    while(fallos[siguienteJugador] >= fallosPermitidos) {
                        siguienteJugador = siguenteJugador(siguienteJugador);
                    }
                    
                    imprimirMascara(mascara, fallos[siguienteJugador]);
                    
                    continue;
                }
            } else if(entradaUsuario.length() < 1) {
                continue;
            }
        
            // Si se ha introducido solo 1 letra la cogemos
            letra = entradaUsuario.charAt(0);
            
            /**
             * Creamos la nueva mascara que contendra las letras
             * iguales a las intruducidas por el usuario descubiertas.
             */
            StringBuilder nuevaMascara = validarLetra(palabra, letra, mascara);
            
            
            // Imprimimos la mascara actual
            imprimirMascara(mascara, fallos[jugador]);
            
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
                // Calculamos la diferencia entre la mascara nueva y la vieja
                int difMascaras = diferencia(mascara, nuevaMascara);
                
                // A la puntuacion del jugador se le sumara la cantidad
                // de letras descubiertas
                puntuacion[jugador] += difMascaras;
                
                aciertos = difMascaras;
                
                System.out.println("\nLa letra " + letra + " esta " + aciertos + " veces\n");
                
                // Si acaba de resolver la palabra le sumamos el bonus
                if(validarPalabra(nuevaMascara.toString())){
                    puntuacion[jugador] += solverBonus;
                    break;
                }
                
                // Asignamos la nueva mascara
                mascara = nuevaMascara;
            }
                        
            /**
             * Si no hay jugadores con "vidas" mostramos la palabra
             */
            if(jugadorEnJuego(fallos) == false) {
                imprimirError("No quedan jugadores con 'vidas'. La palabra era: " + palabra);
                break;
            }
        } while(!validarPalabra(mascara.toString())); // El juego continua hasta que la mascara sea una palabra valida
        
        // Mostramos las puntuaciones
        System.out.println("===== Puntuaciones: ======");
        
        for(int i = 0; i < listaDeJugadores.length; i++) {
            System.out.println(listaDeJugadores[i] + ": " + puntuacion[i] + " puntos");
        }
        
        System.out.println("El ganador es: " + listaDeJugadores[indexDelValorMax(puntuacion)]);
    }
    
    /**
     * El metodo devuelve el indice del siguiente jugador respecto
     * el jugador actual.
     * 
     * OJO: Este metodo no comprueba si el jugador tiene intentos restantes
     * 
     * @param jugadorActual Jugador actual
     * @return El siguiente jugador que debe de jugar 
     */
    public static int siguenteJugador(int jugadorActual) {
        jugadorActual++;
        
        if(jugadorActual >= listaDeJugadores.length){
            jugadorActual = 0;
        }
        
        return jugadorActual;
    }
    
    /**
     * Comprueba si hay algun jugador que puede jugar.
     * Comprueba si existe algun jugador en el juego que tenga
     * menos fallos del maximo permitido.
     * 
     * @param fallos Numero de fallos de cada jugador
     * @return TRUE si existe algun jugador con menos fallos del maximo permitido
     *         FALSE en caso contrario
     */
    public static boolean jugadorEnJuego(int[] fallos) {
        for (int i = 0; i < fallos.length; i++) {
            if(fallos[i] < fallosPermitidos) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Devuelve en indice del valor mas alto de un vector numerico.
     * 
     * @param arr El vector en el cual se buscara el numero mas alto
     * @return El indice del numero mas alto
     */
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
    
    /**
     * Asigna los jugadores que participaran en el juego.
     * Lee una serie (indicada) de nombre por el terminal.
     * Si no es un nombre valido, volvera a pedir.
     * 
     * @param jugadores Numero de jugadores ( Nombres a introducir )
     */
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
            
            // Si el nombre es valido lo asignamos al 
            // vector global que guarda los jugadores
            listaDeJugadores[i] = nombreJugador;
        }
    }    
    
    /**
     * Comprueba si en el parametro palabra existe el caracter (letra), en este caso 
     * cambia el caracter de la misma posicion en aMascara.
     * De esta forma descubre una letra de una palabra oculta.
     * 
     * @param palabra Palabra original
     * @param letra Letra a comprobar
     * @param aMascara En este StringBuilder se descubriran las letras
     * @return Nuevo StringBuilder con las letras descubiertas/cambiadas
     */
    public static StringBuilder validarLetra(String palabra, char letra, StringBuilder aMascara) {
        /** 
         * Si la palabra y el StringBuilder no tienen el mismo tamaño devolvemos NULL
         */
        if(palabra.length() != aMascara.length()) {
            return null;
        }
        
        /**
         * Hacemos copia de la mascara para no sobreescribir
         * la mascara original.
         */
        StringBuilder mascara = new StringBuilder(aMascara);
        
        for(int i = 0; i < palabra.length(); i++) {
            // Si la letra de la palabra y la letra indicada
            // coinciden cambiamos el caracter de la mascara
            if(palabra.charAt(i) == letra) {
                mascara.setCharAt(i, letra);
            }
        }
        
        return mascara;
    }
    
    /**
     * Repite un caracter una serie de veces.
     * 
     * @param ch Caracter a repetir
     * @param repetir Cuantas veces se tiene que repetir el caracter dado
     * @return Devuelve una cadena que contiene el caracter indicado las veces indicadas.
     */
    public static String repetirCaracter(char ch, int repetir) {
        StringBuilder resultado = new StringBuilder(repetir);
        
        for(int i = 0; i < repetir; i++) {
            resultado.append(ch);
        }
        
        return resultado.toString();
    }
    
    /**
     * Añade una serie de palabras en una lista.
     * Posteriormente de esta lista se seleccionara una palabra
     * de forma aleatoria con la cual se jugara.
     * El metodo lee palabras hasta introducir la palabra "fin"
     */
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
        } while(!palabra.equals("fin"));
    }
    
    /**
     * Selecciona una palabra de forma aleatoria
     * de la lista de palabras, previamente definida por el usuario.
     * 
     * @return Una palabra aleatoria
     */
    public static String palabraAleatoria() {
        // Si no hay conjunto de palabras definidos devolvemos NULL
        if(listaDePalabrasOcultas.toString().equals("")) {
            return null;
        }
        // Insertamos las palabras en un vector
        String[] palabras = listaDePalabrasOcultas.toString().split(String.valueOf(SEPARADOR));
        
        // Devolvemos una de estas palabras de forma aleatoria
        return palabras[new Random().nextInt((palabras.length - 1))];
    }
    
    /**
     * Define la palabra oculta con la que se jugara el juego.
     * El metodo le pide al usuario que intruduzca palabras hasta
     * que la misma sea correcta ( compuesta solo por caracteres alfabeticos )
     */
    public static void agregarNuevaPalabra() {
        String palabra = "";
        boolean palabraValida;
        
        do {
            palabra = leerCadena("Introduce la palabra: ");
            
            // Comprobamos si la palabra introducida es una palabra valida
            palabraValida = validarPalabra(palabra);
            
            if(!palabraValida) {
                imprimirError("La palabra no es valida");
            }
        } while(!palabraValida);
        
        // Asignamos la palabra a una variable global
        palabraOculta = palabra;
    }
    
    /**
     * Imprime un error por pantalla
     * 
     * @param error El error que se debe de imprimir
     */
    public static void imprimirError(String error) {
        limpiarPantalla();
        System.out.println(repetirCaracter(' ', 10) + repetirCaracter('#', (error.length() + 4)));
        System.out.println(repetirCaracter(' ', (int)Math.floor(error.length() / 2)) + error);
        System.out.println(repetirCaracter(' ', 10) + repetirCaracter('#', (error.length() + 4)));
        System.out.println("\n\n");
    }
    
    /**
     * Comprueba si una palabra esta compuesta SOLO por letras o espacios.
     * 
     * @param palabra La palabra a comprobar
     * @return TRUE si la palabra es correcta ( solo letras ) FALSE en caso contrario
     */
    public static boolean validarPalabra(String palabra) {
        for(int i = 0; i < palabra.length(); i++) {
            if(!Character.isAlphabetic(palabra.charAt(i)) && palabra.charAt(i) != ' ') {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Lee una cadena del terminal introducido por el usuario.
     * 
     * @param texto El texto que se mostrara al usuario para indicar le que es lo 
     *              que tiene que introducir.
     * @return La cadena introducido por el usuario
     */
    public static String leerCadena(String texto) {
        System.out.print(texto);
        
        if(toLowerCaseAllUserInputs) {
            return scan.nextLine().toLowerCase();
        }
        
        return scan.nextLine();
    }
    
    /**
     * Lee un caracter del terminal introducido por el usuario.
     * 
     * @param texto El texto que se mostrara al usuario para indicar le que es lo 
     *              que tiene que introducir.
     * @return La cadena introducida por el usuario
     */
    public static char leerCaracter(String texto) {
        System.out.print(texto);
        
        if(toLowerCaseAllUserInputs) {
            return Character.toLowerCase(scan.nextLine().charAt(0));
        }
        
        return scan.nextLine().charAt(0);
    }
    
    /**
     * Lee un numero del terminal introducido por el usuario.
     * 
     * @param texto El texto que se mostrara al usuario para indicar le que es lo 
     *              que tiene que introducir.
     * @return El numero introducido por el usuario
     */
    public static int leerNumero(String texto) {
        System.out.print(texto);
        
        return Integer.parseInt(scan.nextLine());
    }
    
    /**
     * El metodo añade una opcion, con su codigo correspondiente al menu.
     * 
     * @param codigo El codigo de la operacion
     * @param nombreDeLaOpcion La descripcion de la operacion
     */
    public static void agregarOpcion(int codigo, String nombreDeLaOpcion) {
        listaDeOpciones.append(codigo);
        listaDeOpciones.append(": ");
        listaDeOpciones.append(nombreDeLaOpcion);
        listaDeOpciones.append("\n");
    }
    
    /**
     * Calcula la diferencia entre dos StringBuilders.
     * Si alguno de los valores es NULL se devolvera -1 como resultado
     * 
     * @param original El StringBuilder origiinal
     * @param copia El StringBuilder copia con el que se comparara el original
     * @return El numero de caracteres diferentes entre los dos StringBuilders dados.
     */
    public static int diferencia(StringBuilder original, StringBuilder copia) {
        // Si alguno de los StringBuilder no esta inicializado 
        // es decir es NULL devolvemos -1
        if(original == null || copia == null) {
            return -1;
        }
        
        // Si un StringBuilder contiene mas caracteres que el otro
        // todos esos caracteres seran la diferencia inicia ( que no hara falta
        // comparar los )
        int diferencia = Math.abs(original.length() - copia.length());
        
        // En caso de que un StringBuilder es mas largo que el otro cogemos 
        // en tamaño del mas corto, de esta forma nos aseguramos de que no nos vamos
        // a salir del limite de algun StringBuilder
        int length = (original.length() < copia.length()) ? original.length(): copia.length();
        
        /**
         * Comprobamos los caracteres de cada posicion si son iguales o diferentes.
         * En caso de que los caracteres no son iguales aumentamos la variable
         * diferencia con 1
         */
        for(int i = 0; i < length; i++) {
            if(original.charAt(i) != copia.charAt(i)) {
                diferencia++;
            }
        }
        
        return diferencia;
    }
    
    /**
     * Limpia la pantalla imprimiendo 50 linias nuevas vacias
     */
    public static void limpiarPantalla() {
        System.out.println(repetirCaracter('\n', 50));
    }
    
    /**
     * Imprime una mascara ( StringBuilder ) en la pantalla del terminal.
     * Usamos ese metodo para dar le una vista mas agradable al usuario.
     * 
     * @param mascara La mascara que se debe de imprimir
     */
    public static void imprimirMascara(StringBuilder mascara, int fallos) {
        StringBuilder mascaraParaImprimir = separarCaracteres(' ', mascara);
        
        char charDibujar = (char)9608;
        
        // Imprimimos la horca si hay fallos
        if(fallos > 0) {
            //System.out.print(cogerHorca(fallos, ((int)Math.ceil(mascara.length() / 2)) * 2));
            System.out.print(cogerHorca(fallos, 2));
            //System.out.println(" Fallos: (" + fallos + "/" + fallosPermitidos + ")");
            System.out.println(representacionGUIFallos(fallos));
        }
        
        // Imprimimos el borde superior
        //System.out.println(repetirCaracter(charDibujar, (mascaraParaImprimir.length() + 2)));
        
        // Imprimimos la mascara
        System.out.println(mascaraParaImprimir);
        
        // Imprimimos el borde inferior
        //System.out.println(repetirCaracter(charDibujar, (mascaraParaImprimir.length() + 2)));
    }
    
    public static String representacionGUIFallos(int fallos) {
        StringBuilder resultado = new StringBuilder(fallosPermitidos);
        resultado.append(repetirCaracter((char)9679, fallos));
        resultado.append(repetirCaracter((char)9711, (fallosPermitidos - fallos)));
        
        return resultado.toString();
    }
    
    /**
     * El metodo se ocupa de representar la horca a partir
     * del numero de fallos cometidos por el jugador.
     * 
     * @param errores Errores cometidos ( fallos )
     * @param padding Se utiliza para definir el numero de espacios antes de la horca
     *                parecido a un padding-left
     * @return Un String con la horca 'dibujada'
     */
    public static String cogerHorca(int errores, int padding) {
        StringBuilder resultado = new StringBuilder();
        
        char cabeza = (char)9785;
        char horcaIzquierda = (char)9615;
        char horcaSuperior = (char)9620;
        char cuerda = (char)9591;
        char cuerpo = (char)9474;
        char manoIzquierda = '\\';
        char manoDerecha = '/';
        
        // cabeza
        if(errores >= 1) {
            resultado.append(repetirCaracter(' ', padding));
            resultado.append(horcaIzquierda);
        }
        
        if(errores >= 2) resultado.append(horcaSuperior);
        if(errores >= 2) resultado.append(cuerda);
        if(errores >= 1) resultado.append('\n');
        
        if(errores >= 1) {
            resultado.append(repetirCaracter(' ', padding));
            resultado.append(horcaIzquierda);
        }
        if(errores >= 3) resultado.append(' ');
        if(errores >= 3) resultado.append(cabeza);
        if(errores >= 1) resultado.append('\n');
        
        if(errores >= 1) {
            resultado.append(repetirCaracter(' ', padding));
            resultado.append(horcaIzquierda);
        }
        if(errores >= 4) resultado.append(manoDerecha);
        if(errores >= 5) resultado.append(cuerpo);
        if(errores >= 6) resultado.append(manoIzquierda);
        if(errores >= 1) resultado.append('\n');
        
        if(errores >= 1) {
            resultado.append(repetirCaracter(' ', padding));
            resultado.append(horcaIzquierda);
        }
        
        if(errores < 7) resultado.append("   ");
        if(errores >= 7) resultado.append(manoDerecha);
        if(errores == 7) resultado.append("  ");
        if(errores >= 8) resultado.append(' ');
        if(errores >= 8) resultado.append(manoIzquierda);
        resultado.append("  ");
        
        return resultado.toString();
    }
    
    /**
     * Añade un caracter entre cada caracter en un StringBuilder
     * 
     * @param separador El separador que separara los caracteres
     * @param sb El StringBuilder cuyos elementos deben de ser separados
     * @return Un nuevo StringBuilder que contiene los caracteres ya separados
     */
    public static StringBuilder separarCaracteres(char separador, StringBuilder sb) {
        StringBuilder resultado = new StringBuilder(sb.length() * 2);
        
        for(int i = 0; i < sb.length(); i++) {
            resultado.append(sb.charAt(i));
            resultado.append(separador);
        }
        
        return resultado;
    }    
    
    public static void dibujaTexto(String status, int cantidadDeParpadeos) {
        dibujaTexto(status, "", cantidadDeParpadeos);
    }
    
    public static void dibujaTexto(String status, String textoAdicional, int cantidadDeParpadeos) {
        String textoGanas = "  _    _                _____                       _       \n" +
                            " | |  | |              / ____|                     | |      \n" +
                            " | |__| | __ _ ___    | |  __  __ _ _ __   __ _  __| | ___  \n" +
                            " |  __  |/ _` / __|   | | |_ |/ _` | '_ \\ / _` |/ _` |/ _ \\ \n" +
                            " | |  | | (_| \\__ \\   | |__| | (_| | | | | (_| | (_| | (_) |\n" +
                            " |_|  |_|\\__,_|___/    \\_____|\\__,_|_| |_|\\__,_|\\__,_|\\___/";
        
        
        String textoPierdes = "   _____                           ____                 \n" +
                              "  / ____|                         / __ \\                \n" +
                              " | |  __  __ _ _ __ ___   ___    | |  | |_   _____ _ __ \n" +
                              " | | |_ |/ _` | '_ ` _ \\ / _ \\   | |  | \\ \\ / / _ \\ '__|\n" +
                              " | |__| | (_| | | | | | |  __/   | |__| |\\ V /  __/ |   \n" +
                              "  \\_____|\\__,_|_| |_| |_|\\___|    \\____/  \\_/ \\___|_|  ";
        
        String texto = "";
        
        switch (status) {
            case "Ganas": texto = textoGanas; break;
            case "Pierdes": texto = textoPierdes; break;
        }
        
        // Limpiamos la pantalla
        limpiarPantalla();
        
        for (int i = 0; i < cantidadDeParpadeos; i++) {
            if(i % 2 == 0) {
                System.out.println(textoAdicional);
                System.out.println(texto);
            } else {
                limpiarPantalla();
            }
            
            try {
                Thread.sleep(500);
            }catch(Exception e) { }
        }
    }
    
    public static void dibujarLogo() {
        String[] texto = new String[5];
                
                       texto[0] = "    ___    __                              __    ";
                       texto[1] = "   /   |  / /_  ____  ______________ _____/ /___ ";
                       texto[2] = "  / /| | / __ \\/ __ \\/ ___/ ___/ __ `/ __  / __ \\";
                       texto[3] = " / ___ |/ / / / /_/ / /  / /__/ /_/ / /_/ / /_/ /";
                       texto[4] = "/_/  |_/_/ /_/\\____/_/   \\___/\\__,_/\\__,_/\\____/";
                       
        for (int i = 0; i < 10; i++) {
        
            limpiarPantalla();
            for(int x = 0; x < texto.length; x++) {
                System.out.println(repetirCaracter(' ', (i * 2)) + texto[x]);
            }
            
            
            try {
                Thread.sleep(300);
            }catch(Exception e) { }
        }
        
        limpiarPantalla();
    }
}
















