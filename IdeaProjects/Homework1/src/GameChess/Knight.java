package GameChess;
/**
 * The <code>Knight</code> class represents the piece Knight.
 */

import static GameChess.Chess.emptyCharacter;

public class Knight {
    /**
     * Creates a <code>Position[]</code> object representing all the possible movements of the knight from a given
     * position
     *
     * @param chess the <code>Chess</code> object representing the game
     * @param p     the <code>Position</code> object representing the positions of knight
     * @return   the <code>Position[]</code> list of possible destinations
     */
    public static Position[] reachablePositions(Chess chess, Position p){
        char[][] board = chess.getBoard();
        Position origin = p;
        Position[] possibleMoves = new Position[8];
        int i = 0;
        if(origin != null && !chess.isEmpty(origin)){
            int atRank = origin.getRank();
            int atFile = origin.getFile();

            if(chess.isWhitePieceAt(origin)){

                if((board[atRank+1][atFile+2] >= 'a' && board[atRank+1][atFile+2] <= 'z') || board[atRank+1][atFile+2] == emptyCharacter) {
                    possibleMoves[i++] = new Position(atRank+1, atFile+2);
                }
                if((board[atRank+1][atFile-2] >= 'a' && board[atRank+1][atFile-2] <= 'z') || board[atRank+1][atFile-2]  == emptyCharacter ) {
                    possibleMoves[i++] = new Position(atRank+1, atFile-2);
                }
                if((board[atRank-1][atFile+2] >= 'a' && board[atRank-1][atFile+2] <= 'z') || board[atRank-1][atFile+2] == emptyCharacter ) {
                    possibleMoves[i++] = new Position(atRank-1, atFile+2);
                }
                if((board[atRank-1][atFile-2] >= 'a' && board[atRank-1][atFile-2] <= 'z') || board[atRank-1][atFile-2] == emptyCharacter) {
                    possibleMoves[i++] = new Position(atRank-1, atFile-2);
                }

                if((board[atRank+2][atFile+1] >= 'a' && board[atRank+2][atFile+1] <= 'z') || board[atRank+2][atFile+1] == emptyCharacter) {
                    possibleMoves[i++] = new Position(atRank+2, atFile+1);
                }
                if((board[atRank+2][atFile-1] >= 'a' && board[atRank+2][atFile-1] <= 'z') || board[atRank+2][atFile-1] == emptyCharacter){
                    possibleMoves[i++] = new Position(atRank+2, atFile-1);
                }
                if((board[atRank-2][atFile+1] >= 'a' && board[atRank-2][atFile-1] <= 'z') || board[atRank-2][atFile-1] == emptyCharacter) {
                    possibleMoves[i++] = new Position(atRank-2, atFile-1);
                }
                if((board[atRank-2][atFile-1] >= 'a' && board[atRank-2][atFile+1] <= 'z') || board[atRank-2][atFile+1] == emptyCharacter) {
                    possibleMoves[i++] = new Position(atRank-2, atFile+1);
                }



            } else {
                if((board[atFile-1][atRank-2] >= 'A' && board[atFile-1][atRank-2] <= 'Z') || board[atFile-1][atRank-2] == emptyCharacter) {
                    possibleMoves[i++] = new Position(atFile-1, atRank-2);
                }
                if((board[atFile-1][atRank+2] >= 'A' && board[atFile-1][atRank+2] <= 'Z') || board[atFile-1][atRank+2] == emptyCharacter ) {
                    possibleMoves[i++] = new Position(atFile-1, atRank+2);
                }
                if((board[atFile+1][atRank-2] >= 'A' && board[atFile+1][atRank-2] <= 'Z') || board[atFile+1][atRank-2]  == emptyCharacter ) {
                    possibleMoves[i++] = new Position(atFile+1, atRank-2);
                }
                if((board[atFile+1][atRank+2] >= 'A' && board[atFile+1][atRank+2] <= 'Z') || board[atFile+1][atRank+2] == emptyCharacter) {
                    possibleMoves[i++] = new Position(atFile+1, atRank+2);
                }
                if((board[atFile+2][atRank+1] >= 'A' && board[atFile+2][atRank-1] <= 'Z') || board[atFile+2][atRank-1] == emptyCharacter ) {
                    possibleMoves[i++] = new Position(atFile+2, atRank-1);
                }
                if((board[atFile+2][atRank-1] >= 'A' && board[atFile+2][atRank+1] <= 'Z') || board[atFile+2][atRank+1] == emptyCharacter ) {
                    possibleMoves[i++] = new Position(atFile+2, atRank+1);
                }
                if((board[atFile-2][atRank+1] >= 'A' && board[atFile-2][atRank-1] <= 'Z') || board[atFile-2][atRank-1] == emptyCharacter) {
                    possibleMoves[i++] = new Position(atFile-2, atRank-1);
                }
                if((board[atFile-2][atRank-1] >= 'A' && board[atFile-2][atRank+1] <= 'Z') || board[atFile-2][atRank+1] == emptyCharacter) {
                    possibleMoves[i++] = new Position(atFile-2, atRank+1);
                }

            }
            return possibleMoves;
        }

        return null;


    }


}
