/**
 * The <code>am.aua.chess.core.Rook</code> class contains the behaviour of rook pieces and the class extends Piece.
 *
 * @author Hovak Abramian <a href="mailto:hovag.abramian@aua.am">hovag.abramian@aua.am</a>
 * @author Varduhi Yeghiazaryan <a href="mailto:vyeghiazaryan@aua.am">vyeghiazaryan@aua.am</a>
 * @version 1.0
 * @since 1.0
 */

package am.aua.chess.core;

public class Rook extends Piece {


    private boolean hasMoved;

    /**
     * A no-arg constructor,  initializes pieces of Rook with WHITE by default .
     */

    public Rook() {
        this(Chess.PieceColor.WHITE);
    }

    /**
     * A constructor, initializes according to
     * <code>am.aua.chess.core.Chess.PieceColor</code> object.
     *
     * @param color    the original color of piece according to which the object is initialized
     */

    public Rook(Chess.PieceColor color) {
        this(color, false);
    }

    /**
     * A constructor, initializes according to
     * <code>am.aua.chess.core.Chess.PieceColor</code> object and <code>boolean</code>.
     *
     * @param color    the original color of piece according to which the object is initialized
     * @param hasMoved checking if the peace has moved
     */

    public Rook(Chess.PieceColor color, boolean hasMoved) {
        super(color);
        this.hasMoved = hasMoved;
    }

    /**
     * An overridden method that returns "R" if the color of Knight is WHITE
     * and returns "r" if it is BLACK
     * @return          a <code>String</code> which is "R" in case of WHITE piece and "r" otherwise
     */

    public String toString() {
        if (this.getColor() == Chess.PieceColor.WHITE)
            return "R";
        else
            return "r";
    }

    /**
     * An overridden method that generates and returns a set of all the positions into which a Rook
     * might perform a valid move from a given position in the given ongoing
     * chess game.
     *
     * @param chess     the ongoing <code>am.aua.chess.core.Chess</code> game
     * @param p         the position of the rook
     * @return          a <code>am.aua.chess.core.Position</code> array with all the positions
     *                  that a rook can move into from position <code>p</code>
     */

    public Position[] allDestinations(Chess chess, Position p) {
        return Rook.reachablePositions(chess, p);
    }


    public static Position[] reachablePositions(Chess chess, Position p) {
        int[] rankOffsets = {1, -1, 0, 0};
        int[] fileOffsets = {0, 0, 1, -1};
        Position[] result = new Position[0];

        for (int d = 0; d < 4; d++) {
            int i = p.getRank() + rankOffsets[d];
            int j = p.getFile() + fileOffsets[d];
            while (i >= 0 && i < Chess.BOARD_RANKS &&
                    j >= 0 && j < Chess.BOARD_FILES) {
                Position current = Position.generateFromRankAndFile(i, j);

                if (chess.isEmpty(current))
                    result = Position.appendPositionsToArray(result,current);
                else {
                    if (chess.getPieceAt(current).getColor() !=
                            chess.getPieceAt(p).getColor())
                        result = Position.appendPositionsToArray(result,
                                                                 current);
                    break;
                }
                i += rankOffsets[d];
                j += fileOffsets[d];
            }
        }

        return result;
    }

    /*
    // Alternative simplistic approach
    public static am.aua.chess.core.Position[] reachablePositions(am.aua.chess.core.Chess chess, am.aua.chess.core.Position p){
        am.aua.chess.core.Position[] result = new am.aua.chess.core.Position[0];

        for(int i = p.getRank() + 1; i < am.aua.chess.core.Chess.BOARD_RANKS; i++){
            am.aua.chess.core.Position current = am.aua.chess.core.Position.generateFromRankAndFile(i,p.getFile());

            if(chess.isEmpty(current)){
                result = am.aua.chess.core.Position.appendPositionsToArray(result,current);
            }else{
                if(chess.getPieceAt(current).getPieceColor() != chess.getPieceAt(p).getPieceColor()){
                    result = am.aua.chess.core.Position.appendPositionsToArray(result,current);
                    break;
                }else{
                    break;
                }
            }
        }

        for(int i = p.getRank() - 1; i >= 0; i--){
            am.aua.chess.core.Position current = am.aua.chess.core.Position.generateFromRankAndFile(i,p.getFile());
            if(chess.isEmpty(current)){
                result = am.aua.chess.core.Position.appendPositionsToArray(result,current);
            }else{
                if(chess.getPieceAt(current).getPieceColor() != chess.getPieceAt(p).getPieceColor()){
                    result = am.aua.chess.core.Position.appendPositionsToArray(result,current);
                    break;
                }else{
                    break;
                }
            }
        }


        for(int i = p.getFile() + 1; i < am.aua.chess.core.Chess.BOARD_FILES; i++){
            am.aua.chess.core.Position current = am.aua.chess.core.Position.generateFromRankAndFile(p.getRank(),i);

            if(chess.isEmpty(current)){
                result = am.aua.chess.core.Position.appendPositionsToArray(result,current);
            }else{
                if(chess.getPieceAt(current).getPieceColor() != chess.getPieceAt(p).getPieceColor()){
                    result = am.aua.chess.core.Position.appendPositionsToArray(result,current);
                    break;
                }else{
                    break;
                }
            }
        }

        for(int i = p.getFile() - 1; i >= 0; i--){
            am.aua.chess.core.Position current = am.aua.chess.core.Position.generateFromRankAndFile(p.getRank(),i);
            if(chess.isEmpty(current)){
                result = am.aua.chess.core.Position.appendPositionsToArray(result,current);
            }else{
                if(chess.getPieceAt(current).getPieceColor() != chess.getPieceAt(p).getPieceColor()){
                    result = am.aua.chess.core.Position.appendPositionsToArray(result,current);
                    break;
                }else{
                    break;
                }
            }
        }

        return result;
    }
    */
}
