package am.aua.chess.core;

public class Bishop extends Piece {

    public Bishop() {
        super();
    }

    public Bishop(Chess.PieceColor color){
        super(color);
    }

    public String toString (){
        if(this.getColor().equals(Chess.PieceColor.WHITE)) {
            return "B";
        }
        else
            return "b";
    }


    public Position[] allDestinations(Chess chess, Position p) {
            return Bishop.reachablePositions(chess, p);
        }

    public static Position[] reachablePositions(Chess chess, Position p) {
            int[] rankOffsets = {1, -1, -1, 1};
            int[] fileOffsets = {1, -1, 1, -1};
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
    }









