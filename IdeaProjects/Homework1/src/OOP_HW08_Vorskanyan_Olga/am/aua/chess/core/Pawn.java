package am.aua.chess.core;

/**
 * The <code>am.aua.chess.core.Pawn</code> class contains the behaviour of pawn pieces and the class extends Piece.
 *
 */

public class Pawn extends Piece{

    /**
     * A no-arg constructor,  initializes pieces of Pawn with WHITE by default .
     */
    public Pawn() {
        super();
    }

    /**
     * A constructor, initializes according to
     * <code>am.aua.chess.core.Chess.PieceColor</code> object.
     *
     * @param color   the original color of piece according to which the object is initialized
     */

    public Pawn(Chess.PieceColor color){
        super(color);
    }

    /**
     * An overridden method that returns "P" if the color of Pawn is WHITE
     * and returns "p" if it is BLACK
     * @return          a <code>String</code> which is "P" in case of WHITE piece and "p" otherwise
     */

    public String toString (){
        if(this.getColor().equals(Chess.PieceColor.WHITE)) {
            return "P";
        }
        else
            return "p";
    }

    /**
     * An overridden method that generates and returns a set of all the positions into which a pawn
     * might perform a valid move from a given position in the given ongoing
     * chess game.
     *
     * @param chess     the ongoing <code>am.aua.chess.core.Chess</code> game
     * @param p         the position of the pawn
     * @return          a <code>am.aua.chess.core.Position</code> array with all the positions
     *                  that a pawn can move into from position <code>p</code>
     */

    public Position[] allDestinations(Chess chess, Position p) {
        Position[] pawnMoves = new Position[0];
        int atRank = p.getRank();
        int atFile = p.getFile();
        Chess.PieceColor pieceColor = chess.getPieceAt(p).getColor();
        if (pieceColor == Chess.PieceColor.WHITE) {
            Position pos1 = Position.generateFromRankAndFile(atRank + 1, atFile);
            if (chess.isEmpty(pos1))
                pawnMoves = Position.appendPositionsToArray(pawnMoves, pos1);
            if (atRank == 2) {
                Position pos2 = Position.generateFromRankAndFile(atRank + 2, atFile);
                if (chess.isEmpty(pos2))
                    pawnMoves = Position.appendPositionsToArray(pawnMoves, pos2);
            }
            Position pos3 = Position.generateFromRankAndFile(atRank + 1, atFile + 1);
            Position pos4 = Position.generateFromRankAndFile(atRank + 1, atFile - 1);

            if (chess.getPieceAt(pos3) != null && chess.getPieceAt(pos3).getColor() == Chess.PieceColor.BLACK) {
                pawnMoves = Position.appendPositionsToArray(pawnMoves, pos3);
            }

            if (chess.getPieceAt(pos4) != null && chess.getPieceAt(pos4).getColor() == Chess.PieceColor.BLACK) {
                pawnMoves = Position.appendPositionsToArray(pawnMoves, pos4);
            }


        } else {
            Position pos1 = Position.generateFromRankAndFile(atRank - 1, atFile);
            if (chess.isEmpty(pos1))
                pawnMoves = Position.appendPositionsToArray(pawnMoves, pos1);
            if (atRank == 7) {
                Position pos2 = Position.generateFromRankAndFile(atRank - 2, atFile);
                if (chess.isEmpty(pos2))
                    pawnMoves = Position.appendPositionsToArray(pawnMoves, pos2);
            }

            Position pos3 = Position.generateFromRankAndFile(atRank - 1, atFile + 1);
            Position pos4 = Position.generateFromRankAndFile(atRank - 1, atFile - 1);

            if (chess.getPieceAt(pos3) != null && chess.getPieceAt(pos3).getColor() == Chess.PieceColor.BLACK) {
                pawnMoves = Position.appendPositionsToArray(pawnMoves, pos3);
            }

            if (chess.getPieceAt(pos4) != null && chess.getPieceAt(pos4).getColor() == Chess.PieceColor.BLACK) {
                pawnMoves = Position.appendPositionsToArray(pawnMoves, pos4);
            }
        } return pawnMoves;


    }
}
