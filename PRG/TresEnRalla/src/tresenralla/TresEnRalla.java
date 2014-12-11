package tresenralla;

import java.util.Scanner;

/**
 *
 * @author velko
 */
public class TresEnRalla {
    private static char[][] tablero = new char[3][3];
    
    public static void main(String[] args) {
        mostrarMenu();
        dibujarTablero();
    }
    
    public static void mostrarMenu() {
        StringBuilder menuOpciones = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        int opcion = 1;
        
        menuOpciones.append("1: Dos jugadores\n");
        menuOpciones.append("2: un jugador\n");
        menuOpciones.append("3: Salir\n");
        
        while(true) {
            System.out.print("\nElegir una opcion: ");
            opcion = Integer.parseInt(scan.nextLine());
            
            switch(opcion) {
                case 1: 
                    dosJugadores();
                break;
                case 2: break;
                    
                case 3: System.exit(0);
            }
        }
    }
    
    private static void dosJugadores() {
        Scanner scan = new Scanner(System.in);
        char player = 'O', ganador;
        int movimientos = 0;
        
        while(movimientos < 9) {
            dibujarTablero();

            System.out.print("Introduce las coordinadas ():" );
            String[] coords = scan.nextLine().split(" ");
            
            if(coords.length != 2) {
                System.out.println(" *** ERROR *** ");
                continue;
            }
            
            if(tablero[Integer.parseInt(coords[0])][Integer.parseInt(coords[1])] != 0x0) {
                System.out.println(" *** Coordinadas no libres *** ");
                continue;
            }
            
            movimientos++;
            player = (movimientos % 2 == 0) ? 'X' : 'O';
            
            tablero[Integer.parseInt(coords[0])][Integer.parseInt(coords[1])] = player;
            ganador = comprobarGanador();
            
            if(ganador != 0x0) {
                dibujarTablero();
                System.out.println(" +++ El ganador es " + ganador + " +++ ");
                break;
            }
        }
    }
    
    public static char comprobarGanador() {
        for (int i = 0; i < tablero.length; i++) {
            if(tablero[i][0] != 0x0 && tablero[i][0] == tablero[i][1] && tablero[0][0] == tablero[i][2]) {
                return tablero[i][0];
            }
        }
        
        for (int i = 0; i < tablero.length; i++) {
            if(tablero[0][i] != 0x0 && tablero[0][i] == tablero[1][i] && tablero[0][0] == tablero[2][i]) {
                return tablero[0][i];
            }
        }
        
        if(tablero[0][0] != 0x0 && tablero[1][1] == tablero[0][0] && tablero[0][0] == tablero[2][2]) {
            return tablero[0][0];
        } else if(tablero[2][2] != 0x0 && tablero[1][1] == tablero[2][2] && tablero[2][0] == tablero[2][2]) {
            return tablero[2][2];
        }
        
        return 0x0;
    }
    
    public static void dibujarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j] == 'X') {
                    System.out.print("[X]");
                } else if (tablero[i][j] == 'O') {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    }
}
