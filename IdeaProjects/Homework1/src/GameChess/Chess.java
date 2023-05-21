package GameChess;

public class Chess {
    public static final int dim = 8;
    public static final char emptyCharacter = '*';
    char [][] board;
    int counter = 0;



    public Chess() {
        board = new char[dim][dim];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++ ){
                this.board[i][j] = emptyCharacter;
            }
        }
        this.counter = 0;
    }

    public Chess(char[][] givenBoard) {
        board = new char[dim][dim];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++ ){
                this.board[i][j] = emptyCharacter;
            }
        }
        this.counter = 0;
    }



    public char[][] getBoard() {
        char[][] updatedBoard = new char[dim][dim];
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                updatedBoard[i][j] = board[i][j];
        return updatedBoard;

    }

    public int getTurn(){
        if(counter%2==1)
            return 0;
        else
            return 1;
    }


    public boolean isGameOver () {
        return false;
    }

    public boolean isWhitePieceAt(Position position) {
        char member = board[position.getRank()][position.getFile()];
        if(member == emptyCharacter)
            return false;
        String stringElement = Character.toString(member);
        if(stringElement.toUpperCase().equals(stringElement))
            return true;
        else
            return false;
    }


    public boolean isEmpty(Position position) {
        char member = board[position.getRank()][position.getFile()];
        if(member == emptyCharacter)
            return true;
        else
            return false;
    }


    public char getPieceAt(Position position) {
        char member = board[position.getRank()][position.getFile()];
        return member;
    }

    public Position[] reachableFrom(Position origin){
        if((origin == null) || this.isEmpty(origin))
            return null;
        int atRank = origin.getRank();
        int atFile = origin.getFile();
        Position[] eligibleDestinations = Knight.reachablePositions(this,origin);
        return eligibleDestinations;
    }

    public boolean performMove(Move move) {
        Position origin = move.getOrigin();
        Position destination = move.getDestination();
        Position[] eligibleDestinations = reachableFrom(origin);
        if(eligibleDestinations != null){
            for(int i = 0; i < eligibleDestinations.length; i++) {
                if(eligibleDestinations[i].getRank() == destination.getRank() && eligibleDestinations[i].getFile()==destination.getFile()){
                    board[destination.getRank()][destination.getFile()] = board[origin.getRank()][origin.getFile()];
                    board[origin.getRank()][origin.getFile()] = emptyCharacter;
                    counter++;
                    return true;
                }
            }
            return false;
        }
        return false;
    }






}
