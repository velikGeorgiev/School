package javaexercises4;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author velko
 */
public class Game {

    public static enum Players {

        player, ai
    }

    public static enum Moves {

        Stone("Piedra"), Paper("Papel"), Scissors("Tijeras");

        private String value;

        private Moves(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + this.value + "]";
        }
    }

    public static enum Status {

        win("Ganas"), lose("Pierdes"), tie("Empate");

        private String value;

        private Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    /**
     * El resultado del juego score[0] => jugador score[1] => Ordenador (AI)
     *
     */
    private static int[] score = {0, 0};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Moves player;
        int moveNumber = 1;
        
        for(Moves strMove: Moves.values()) {
            System.out.println((moveNumber++) + ": " + strMove);
        }

        do {
            // Leemos el movimiento del jugador y creamos un movimiento de inteligencia artificial
            System.out.print("Juega con: ");
            player = intToMove(Integer.parseInt(scan.nextLine()));

            // Si el movimiento no es valido el programa termina
            if (player == null) {
                break;
            }

            Moves aiMove = aiMove();
            Status gameStatus = isPlayerWinner(player, aiMove);

            // Actualizamos el resultado
            updateScore(gameStatus);

            // Mostramos el ganador
            System.out.print(player + " vs " + aiMove);
            System.out.println(" => " + gameStatus);

            System.out.println("Tu: " + score[0] + " PC: " + score[1]);
        } while (true);
    }

    public static Players intToPlayer(int player) {
        if (player == 0) {
            return Players.player;
        }

        return Players.ai;
    }

    public static Moves intToMove(int move) {
        HashMap<Integer, Moves> moves = new HashMap<Integer, Moves>() {
            {
                put(1, Moves.Stone);
                put(2, Moves.Paper);
                put(3, Moves.Scissors);
            }
        };

        return moves.get(move);
    }

    public static void updateScore(Status playerStatus) {
        if (playerStatus == Status.lose) {
            score[1]++;
        } else if(playerStatus == Status.win) {
            score[0]++;
        }
    }

    public static Status isPlayerWinner(Moves player, Moves ai) {

        // Tenemos empate
        if (player == ai) {
            return Status.tie;
        }

        // Comprobamos si el ganador es el jugador
        if ((player == Moves.Stone && ai == Moves.Scissors)
                || (player == Moves.Scissors && ai == Moves.Paper)
                || (player == Moves.Paper && ai == Moves.Stone)) {
            
            return Status.win;
        }

        // El ganador es el ordenador
        return Status.lose;
    }

    public static Moves aiMove() {
        int min = 1;
        int max = 3;

        return intToMove((new Random().nextInt((max - min) + 1) + min));
    }
}
