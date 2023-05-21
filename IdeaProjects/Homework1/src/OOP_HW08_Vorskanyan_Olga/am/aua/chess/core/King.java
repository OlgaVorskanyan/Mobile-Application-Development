package am.aua.chess.core;

/**
 * The <code>am.aua.chess.core.King</code> class contains the behaviour of king pieces and the class extends Piece.
 *
 */

public class King extends Piece {
    public boolean hasMoved;

    /**
     * A no-arg constructor,  initializes pieces of King with WHITE by default .
     */


    public King() {
        super();
    }

    /**
     * A constructor, initializes according to
     * <code>am.aua.chess.core.Chess.PieceColor</code> object.
     *
     * @param color   the original color of piece according to which the object is initialized
     */

    public King(Chess.PieceColor color){
        super(color);
    }

    /**
     * A constructor, initializes according to
     * <code>am.aua.chess.core.Chess.PieceColor</code> object and <code>boolean</code>.
     *
     * @param color    the original color of piece according to which the object is initialized
     * @param hasMoved checking if the peace has moved
     */


    public King(Chess.PieceColor color, boolean hasMoved){
        super(color);
        this.hasMoved = hasMoved;
    }

    /**
     * An overridden method that returns "K" if the color of King is WHITE
     * and returns "k" if it is BLACK
     * @return          a <code>String</code> which is "K" in case of WHITE piece and "k" otherwise
     */

    public String toString (){
        if(this.getColor().equals(Chess.PieceColor.WHITE)) {
            return "K";
        }
        else
            return "k";
    }

    /**
     * An overridden method that generates and returns a set of all the positions into which a king
     * might perform a valid move from a given position in the given ongoing
     * chess game.
     *
     * @param chess     the ongoing <code>am.aua.chess.core.Chess</code> game
     * @param p         the position of the king
     * @return          a <code>am.aua.chess.core.Position</code> array with all the positions
     *                  that a king can move into from position <code>p</code>
     */



    public Position[] allDestinations(Chess chess, Position p) {
        int[][] pattern = {
                {p.getRank() + 1, p.getFile()},
                {p.getRank() - 1, p.getFile()},
                {p.getRank(), p.getFile() - 1},
                {p.getRank(), p.getFile() + 1},

                {p.getRank() + 1, p.getFile() + 1},
                {p.getRank() - 1, p.getFile() + 1},
                {p.getRank() - 1, p.getFile() - 1},
                {p.getRank() + 1, p.getFile() - 1}
        };


        Position[] result = new Position[0];

        for (int i = 0; i < pattern.length; i++) {
            Position potential = Position.generateFromRankAndFile(pattern[i][0],
                    pattern[i][1]);
            if (potential != null &&
                    (chess.isEmpty(potential) ||
                            chess.getPieceAt(potential).getColor() != chess.getPieceAt(p).getColor())
            )
                result = Position.appendPositionsToArray(result, potential);
        }

        return result;
    }
}
