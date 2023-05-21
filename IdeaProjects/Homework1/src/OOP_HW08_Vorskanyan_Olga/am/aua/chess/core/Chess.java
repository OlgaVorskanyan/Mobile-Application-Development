package am.aua.chess.core;

import am.aua.chess.core.Knight;
import am.aua.chess.core.Move;
import am.aua.chess.core.Position;

/**
 * The <code>am.aua.chess.core.Chess</code> class encapsulates the state of an ongoing game of
 * chess.
 * 
 * @author Hovak Abramian <a href="mailto:hovag.abramian@aua.am">hovag.abramian@aua.am</a>
 * @author Varduhi Yeghiazaryan <a href="mailto:vyeghiazaryan@aua.am">vyeghiazaryan@aua.am</a>
 * @version 1.0
 * @since 1.0
 */
public class Chess {
    //mutable, e.g. performMove modifies state
    /**
     * The number of board ranks in chess.
     */
    public static final int BOARD_RANKS = 8;
    /**
     * The number of board files in chess.
     */
    public static final int BOARD_FILES = 8;

    /**
     * The <code>enum</code> value to represent empty positions on the board.
     */

    public enum PieceColor {WHITE, BLACK};




    // an instance variable for the board and pieces on it
    private Piece[][] board;
    // an instance variable counter for the current number of moves in the game
    private PieceColor turn;


    public Chess() {
        turn = PieceColor.WHITE;
        this.board = new Piece[BOARD_RANKS][BOARD_FILES];

        for (int i = 0; i < BOARD_RANKS; i++)
            for (int j = 0; j < BOARD_FILES; j++) {
                if (i == 0) {
                    if (j == 0 || j == 7)
                        board[i][j] = new Rook(PieceColor.BLACK);
                    else if (j == 1 || j == 6)
                        board[i][j] = new King(PieceColor.BLACK);
                    else if (j == 2 || j == 5)
                        board[i][j] = new Bishop(PieceColor.BLACK);
                } else if (i == 1) {
                    board[i][j] = new Pawn(PieceColor.BLACK);
                } else if (i == 7) {
                    if (j == 0 || j == 7){
                        board[i][j] = new Rook(PieceColor.WHITE);
                    } else if (j == 1 || j == 6){
                        board[i][j] = new King(PieceColor.WHITE);
                    } else if (j == 2 || j == 5) {
                        board[i][j] = new Bishop(PieceColor.WHITE);
                    }
                }
                else if (i == 6)
                    board[i][j] = new Pawn(PieceColor.WHITE);

            }
    }


    /**
     * Constructs a new <code>am.aua.chess.core.Chess</code>  given a String positioning and a turn, sets up an
     * ongoing chess game.
     *
     * @param positioning a String of length 64 containing the positioning
     * @param turn object of the color of the turn
     */


    public Chess(String positioning,PieceColor turn) {
        this.board = new Piece[BOARD_RANKS][BOARD_FILES];
        this.turn = turn;
        int index = 0;
        int whiteKing = 0;
        int blackKing = 0;
        for(int i = 0; i < BOARD_RANKS; i++) {
            for(int j = 0; j < BOARD_FILES; j++) {
                switch (positioning.charAt(index++)) {
                    case 'R':
                        board[i][j] = new Rook(PieceColor.WHITE,false);
                        break;
                    case 'r':
                        board[i][j] = new Rook(PieceColor.BLACK, false);
                        break;
                    case 'S':
                        board[i][j] = new Rook(PieceColor.WHITE, true);
                        break;
                    case 's':
                        board[i][j] = new Rook(PieceColor.BLACK, true);
                        break;
                    case 'N':
                        board[i][j] = new Rook(PieceColor.WHITE);
                        break;
                    case 'n':
                        board[i][j] = new Rook(PieceColor.BLACK);
                        break;
                    case 'B':
                        board[i][j] = new Bishop(PieceColor.WHITE);
                        break;
                    case 'b':
                        board[i][j] = new Bishop(PieceColor.BLACK);
                        break;
                    case 'K':
                        board[i][j] = new King(PieceColor.WHITE, false);
                        whiteKing++;
                        break;
                    case 'k':
                        board[i][j] = new King(PieceColor.BLACK, false);
                        blackKing++;
                        break;
                    case 'L':
                        board[i][j] = new King(PieceColor.WHITE, true);
                        whiteKing++;
                        break;
                    case 'l':
                        board[i][j] = new King(PieceColor.BLACK, true);
                        blackKing++;
                        break;
                    case 'Q':
                        board[i][j] = new Queen(PieceColor.WHITE);
                        break;
                    case 'q':
                        board[i][j] = new Queen(PieceColor.BLACK);
                        break;
                    case 'P':
                        board[i][j] = new Pawn(PieceColor.WHITE);
                        break;
                    case 'p':
                        board[i][j] = new Pawn(PieceColor.BLACK);
                        break;
                }
                if(blackKing != 1 && whiteKing != 1){
                    System.out.println("Wrong positioning!");
                    return;
                }
            }
        }


    }
    
    /**
     * Returns a <code>Piece</code> matrix representing the game board and the
     * pieces on it.
     *
     * @return          the board as a <code>Piece</code> matrix
     */
    public Piece[][] getBoard() {
        //returns deep copy
        Piece[][] board = new Piece[BOARD_RANKS][BOARD_FILES];
        for (int i = 0; i < BOARD_RANKS; i++)
            for (int j = 0; j < BOARD_FILES; j++)
                board[i][j] = this.board[i][j];
        return board;
    }

    /**
     * Returns either WHITE or BLACK to indicate white's or black's turn, respectively.
     *
     * @return          either WHITE for white's or BLACK for black's turn
     */
    public PieceColor getTurn() {
        return turn;
    }

    /**
     * Checks if the game is over or if it still continues.
     * <p>
     * Current version always returns <code>false</code>. The functionality will
     * be fixed in future versions.
     *
     * @return          true if and only if the game is over
     */
    public boolean isGameOver() {
        return false;
    }



    /**
     * Checks if a given position on the board is empty.
     *
     * @param p         the position that should be tested
     * @return          true if and only if <code>p</code> is empty
     */
    public boolean isEmpty(Position p) {
        return this.board[p.getRank()][p.getFile()] == null;
    }

    /**
     * Returns the <code>Piece</code> representing the piece on a given position
     * on the board.
     *
     * @param p         the position on the board
     * @return          the <code>Piece</code> representing the piece on
     *                  <code>p</code>
     */
    public Piece getPieceAt(Position p) {
        return this.board[p.getRank()][p.getFile()];
    }

    /**
     * Identifies and returns the set of all positions that can serve as
     * destinations for a move from the given origin.
     * <p>
     * If the origin is not a real object or is empty, the method just returns
     * <code>null</code>. Otherwise, it returns a listing of all eligible
     * destinations based on the type of piece in origin (only knight pieces
     * considered in the current version).
     *
     * @param origin    the origin position on the board
     * @return          the array with the set of reachable positions
     */
    public Position[] reachableFrom(Position origin) {
        if (origin == null || this.isEmpty(origin))
            return null;

        Piece piece = board[origin.getRank()][origin.getFile()] ;
        return piece.allDestinations(this, origin);
    }

    /**
     * Attempts to make a given <code>am.aua.chess.core.Move</code>. If the move is valid, i.e.
     * the destination is in the set reachable from the origin, the method
     * correctly updates the state of <code>am.aua.chess.core.Chess</code> and returns
     * <code>true</code>. Otherwise, the method returns <code>false</code>.
     *
     * @param m         the move attempted
     * @return          true if and only if the move was successfully made
     */
    public boolean performMove(Move m) {
        Position origin = m.getOrigin();
        Position destination = m.getDestination();

        Position[] reachable = this.reachableFrom(origin);

        for (int i = 0; i < reachable.length; i++)
            if (destination.getRank() == reachable[i].getRank()
                    && destination.getFile() == reachable[i].getFile()) {
                this.board[destination.getRank()][destination.getFile()] =
                        this.board[origin.getRank()][origin.getFile()];
                this.board[origin.getRank()][origin.getFile()] = null;
                if(turn == PieceColor.WHITE){
                    turn = PieceColor.BLACK;
                }
                else
                    turn = PieceColor.WHITE;
                return true;
            }

        return false;
    }


}
