package am.aua.chess.core;



/**
 * The <code>am.aua.chess.core.Knight</code> class contains the behaviour of knight pieces and the class extends Piece.
 * 
 * @author Hovak Abramian <a href="mailto:hovag.abramian@aua.am">hovag.abramian@aua.am</a>
 * @author Varduhi Yeghiazaryan <a href="mailto:vyeghiazaryan@aua.am">vyeghiazaryan@aua.am</a>
 * @version 1.0
 * @since 1.0
 */
public class Knight extends Piece {

    /**
     * A no-arg constructor,  initializes pieces of Knight with WHITE by default .
     */
    public Knight() {
        super();
    }

    /**
     * A constructor, initializes according to
     * <code>am.aua.chess.core.Chess.PieceColor</code> object.
     *
     * @param color   the original color of piece according to which the object is initialized
     */
    public Knight(Chess.PieceColor color) {
        super(color);
    }

    /**
     * An overridden method that generates and returns a set of all the positions into which a knight
     * might perform a valid move from a given position in the given ongoing
     * chess game.
     *
     * @param chess     the ongoing <code>am.aua.chess.core.Chess</code> game
     * @param p         the position of the knight
     * @return          a <code>am.aua.chess.core.Position</code> array with all the positions
     *                  that a knight can move into from position <code>p</code>
     */
    public Position[] allDestinations(Chess chess, Position p) {
        int[][] pattern = {
                {p.getRank() + 2, p.getFile() + 1},
                {p.getRank() + 2, p.getFile() - 1},
                {p.getRank() - 2, p.getFile() + 1},
                {p.getRank() - 2, p.getFile() - 1},

                {p.getRank() + 1, p.getFile() + 2},
                {p.getRank() + 1, p.getFile() - 2},
                {p.getRank() - 1, p.getFile() + 2},
                {p.getRank() - 1, p.getFile() - 2}
        };


        Position[] result = new Position[0];

        for (int i = 0; i < pattern.length; i++) {
            Position potential = Position.generateFromRankAndFile(pattern[i][0],
                                                                  pattern[i][1]);
            if (potential != null && 
                    (chess.isEmpty(potential) ||
                     chess.getPieceAt(potential).getColor() != chess.getPieceAt(p).getColor()
                    )
            )
                result = Position.appendPositionsToArray(result, potential);
        }

        return result;
    }



    /**
     * An overridden method that returns "N" if the color of Knight is WHITE
     * and returns "n" if it is BLACK
     * @return          a <code>String</code> which is "N" in case of WHITE piece and "n" otherwise
     */

    public String toString (){
        if(this.getColor().equals(Chess.PieceColor.WHITE)) {
            return "N";
        }
        else
            return "n";
    }
}

