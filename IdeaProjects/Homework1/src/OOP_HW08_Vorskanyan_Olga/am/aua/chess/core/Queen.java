package am.aua.chess.core;

/**
 * The <code>am.aua.chess.core.Queen</code> class contains the behaviour of queen pieces and the class extends Piece.
 *
 */

public class Queen extends Piece {

    /**
     * A no-arg constructor,  initializes pieces of Queen with WHITE by default .
     */

    public Queen() {
        super();
    }

    /**
     * A constructor, initializes according to
     * <code>am.aua.chess.core.Chess.PieceColor</code> object.
     *
     * @param color   the original color of piece according to which the object is initialized
     */

    public Queen(Chess.PieceColor color){
        super(color);
    }

    /**
     * An overridden method that returns "Q" if the color of Queen is WHITE
     * and returns "q" if it is BLACK
     * @return          a <code>String</code> which is "Q" in case of WHITE piece and "q" otherwise
     */

    public String toString (){
        if(this.getColor().equals(Chess.PieceColor.WHITE)) {
            return "Q";
        }
        else
            return "q";
    }

    /**
     * An overridden method that generates and returns a set of all the positions into which a queen
     * might perform a valid move from a given position in the given ongoing
     * chess game.
     *
     * @param chess     the ongoing <code>am.aua.chess.core.Chess</code> game
     * @param p         the position of the queen
     * @return          a <code>am.aua.chess.core.Position</code> array with all the positions
     *                  that a queen can move into from position <code>p</code>
     */

    public Position[] allDestinations(Chess chess, Position p) {
        Position [] bishopMoves = Bishop.reachablePositions(chess, p);
        Position [] rookMoves = Rook.reachablePositions(chess, p);

        Position [] queenMoves = new Position[bishopMoves.length + rookMoves.length];


        for(int i = 0; i < bishopMoves.length; i++) {
                queenMoves[i] = bishopMoves[i];
            }

        int index = bishopMoves.length;

        for(int i = 0; i < rookMoves.length; i++ ){
            queenMoves[index + i] = rookMoves[i];

        }

        return queenMoves;
    }


}
