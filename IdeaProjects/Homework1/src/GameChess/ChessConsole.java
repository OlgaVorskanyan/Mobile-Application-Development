package GameChess;
/**
 * The <code>ChessConsole</code> represents a console user interface.
 */

import java.util.Scanner;

public class ChessConsole {

    private Chess game;

    /**
     * For the game to play we have the method
     */

    public void play() {
        Scanner sc = new Scanner(System.in);
        String inputLine;
        game = new Chess();
        print();
        while (!game.isGameOver()) {
            if (game.getTurn() == 0) {
                System.out.println("White’s move: ");
            } else {
                System.out.println("Black’s move: ");
            }
            inputLine = sc.nextLine();
            String[] input = inputLine.split(" ");
            if (input.length == 1) {
                print(Position.generateFromString(input[0]));
            }
            else if (input.length == 2) {
                Move m = new Move(Position.generateFromString(input[0]),
                        Position.generateFromString(input[1]));
                boolean success = game.performMove(m);
                if (!success) {
                    System.out.println("Invalid move. Please try again.");
                }
                print();
            }
        }
    }

    /**
     * Printing the board and the pieces
     */

    public void print() {
        char[][] board = game.getBoard();
        for(int i = 0; i < Chess.dim; i++){
            for(int j = 0; j < Chess.dim; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Print the board with the pieces and also shows with "{}" selected piece given as a <code>Position</code>
     * and a square to which it can move to
     *
     * @param position  the <code>Position</code> which should be put inside "{}"
     */

    public void print(Position position) {
        Position[] posOfEligibleValues = game.reachableFrom(position);
        char[][] board = game.getBoard();
        for(int i = 0; i < Chess.dim; i++){
            for(int j = 0; j < Chess.dim; j++){
                for(int k = 0; k < posOfEligibleValues.length; k++){
                    if(i == posOfEligibleValues[k].getRank() && j == posOfEligibleValues[k].getFile()) {
                        System.out.print("{" + board[i][j] + "} ");
                    } else{
                        System.out.print(board[i][j] + " ");
                    }
                }

            }
            System.out.println();
        }
    }





}
