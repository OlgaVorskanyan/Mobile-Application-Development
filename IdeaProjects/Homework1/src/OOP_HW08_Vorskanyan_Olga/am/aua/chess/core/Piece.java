package am.aua.chess.core;



/**
 * A class that represents the notion of a chess piece
 * <code>am.aua.chess.core.Piece</code>.
 */

//import am.aua.chess.core.Chess;

public class Piece {

    /**
     * The color of the piece.
     */
    public Chess.PieceColor color;

    /**
     * A constructor, initializes according to
     * <code>am.aua.chess.core.Piece</code> object.
     *
     * @param color     the original color of piece, according to which the new object
     *                  is initialized
     */

    public Piece(Chess.PieceColor color) {
        this.color = color;
    }

    /**
     * A no-arg constructor, initializes pieces of chess with WHITE by default .
     */

    public Piece(){
        this.color = Chess.PieceColor.WHITE;
    }

    /**
     * Accessor method for the piece color.
     *
     * @return          the color of the piece
     */
    public Chess.PieceColor getColor() {
        return this.color;
    }

    /**
     * A public method that, given an ongoing chess game and a valid position
     *returns <code>null</code>.
     *
     * @param chess         the game chess
     * @param p             given position
     * @return              <code>null</code>
     */

    public Position[] allDestinations(Chess chess, Position p){
        return null;
    } //this will be changed later





}
