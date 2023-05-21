package am.aua.chess.cli;

import am.aua.chess.core.Chess;
import am.aua.chess.core.Move;
import am.aua.chess.core.Position;

import java.util.*;

/**
 * A class that provides a command line interface for the class
 * <code>am.aua.chess.core.Chess</code>.
 * 
 * @author Hovak Abramian <a href="mailto:hovag.abramian@aua.am">hovag.abramian@aua.am</a>
 * @author Varduhi Yeghiazaryan <a href="mailto:vyeghiazaryan@aua.am">vyeghiazaryan@aua.am</a>
 * @version 1.0
 * @since 1.0
 */
public class ChessConsole {
    // an instance variable for a am.aua.chess.core.Chess object
    private Chess game;

    /**
     * Initializes the game and contains the core loop of the game.
     */
    public void play() {
        Scanner sc = new Scanner(System.in);
        String inputLine;
        game = new Chess();

        print();

        while (!game.isGameOver()) {
            if (game.getTurn() == Chess.PieceColor.WHITE)
                System.out.println("White's move: ");
            else
                System.out.println("Black's move: ");

            inputLine = sc.nextLine();
            String[] input = inputLine.split(" ");
            if (input.length == 1)
                print(Position.generateFromString(input[0]));
            else if (input.length == 2) {
                Position origin = Position.generateFromString(input[0]);
                Position destination = Position.generateFromString(input[1]);
                if(origin != null){
                    Chess.PieceColor pieceColor = game.getBoard()[origin.getRank()][origin.getFile()].getColor();
                    if(game.getTurn() != pieceColor) {
                        System.out.println("Not valid!");
                        return;
                    }
                } else {
                    System.out.println("Not Valid!");
                    return;
                }
                Move m = new Move(origin, destination);
                boolean success = game.performMove(m);
                if (!success)
                    System.out.println("Invalid move. Please try again.");
                print();
            }
        }
    }

    /**
     * Prints the board and the pieces on it, while highlighting a selected
     * piece, along with the squares to which it can move to.
     *
     * @param origin    the position of the selected piece
     */
    public void print(Position origin) {
        Position[] reachableSquares = game.reachableFrom(origin);

        for (int i = 0; i < Chess.BOARD_RANKS; i++) {
            System.out.print((Chess.BOARD_RANKS - i) + " ");

            for (int j = 0; j < Chess.BOARD_FILES; j++) {
                boolean isHighlighted = false;

                if (origin != null &&
                        origin.getRank() == i && origin.getFile() == j
                )
                    isHighlighted = true;

                for (int k = 0; reachableSquares != null &&
                                k < reachableSquares.length; k++)
                    if (reachableSquares[k].getRank() == i &&
                            reachableSquares[k].getFile() == j)
                    {
                        isHighlighted = true;
                        break;
                    }

                if (isHighlighted)
                    System.out.print("\u001b[31m");

                System.out.print("[");

                Position current = Position.generateFromRankAndFile(i, j);
                if (game.isEmpty(current))
                    System.out.print(" ");
                else
                    System.out.print(game.getPieceAt(current));

                System.out.print("]");

                if (isHighlighted)
                    System.out.print("\u001b[0m");
            }
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H ");
        System.out.println();
    }

    /**
     * Prints the board and the pieces on it.
     */
    public void print() {
        print(null);
    }
}
