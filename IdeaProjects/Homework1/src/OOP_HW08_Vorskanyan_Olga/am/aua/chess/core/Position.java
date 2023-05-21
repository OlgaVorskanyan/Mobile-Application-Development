package am.aua.chess.core;

/**
 * A class for storing and representing a position on a chess board. Contains
 * static methods that generate valid objects after ensuring that the given
 * arguments are valid.
 * <p>
 * Also note how <b>javadoc can contain HTML tags.</b>
 *
 * @author Hovak Abramian <a href="mailto:hovag.abramian@aua.am">hovag.abramian@aua.am</a>
 * @author Varduhi Yeghiazaryan <a href="mailto:vyeghiazaryan@aua.am">vyeghiazaryan@aua.am</a>
 * @version 1.0
 * @since 1.0
 */
public class Position {
    //mutable
    /*
     * am.aua.chess.core.Position rank on the board, starting from the top.
     * Classic chessboard squares are ranked from 1 to 8. The value 0
     * corresponds with the 8th rank and
     * a value of 7 corresponds with the 1st rank.
     */
    private int rank;
    /*
     * am.aua.chess.core.Position file on the board, starting from the left.
     * Classic chessboard files are from A to H. The value 0 corresponds with A
     * and a value of 7 corresponds with H.
     */
    private int file;

    /**
     * A no-arg constructor, initializes with 0's, corresponds with A8.
     */
    public Position() {
        this.rank = 0;
        this.file = 0;
    }

    /**
     * A copy constructor, initializes according to another
     * <code>am.aua.chess.core.Position</code> object.
     * 
     * @param other     the original position, according to which the new object
     *                  is created
     */
    public Position(Position other) {
        this.setRank(other.rank);
        this.setFile(other.file);
    }

    /**
     * A parameterized constructor, initializes the fields with given values.
     *
     * @param rank      an integer representing the rank
     * @param file      an integer representing the file
     */
    private Position(int rank, int file) {
        this.setRank(rank);
        this.setFile(file);
    }

    /**
     * Accessor method for the rank of the position.
     *
     * @return          the rank of the position
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Accessor method for the file of the position.
     *
     * @return          the file of the position
     */
    public int getFile() {
        return this.file;
    }

    /**
     * Mutator method for the rank of the position.
     *
     * @param rank      the new rank
     */
    public void setRank(int rank) {
        if (rank >= 0 && rank < Chess.BOARD_RANKS)
            this.rank = rank;
    }

    /**
     * Mutator method for the file of the position.
     *
     * @param file      the new file
     */
    public void setFile(int file) {
        if (file >= 0 && file < Chess.BOARD_FILES)
            this.file = file;
    }

    /**
     * Returns a <code>String</code> representation of this
     * <code>am.aua.chess.core.Position</code> with a format like "C2".
     *
     * @return          the <code>String</code> representation
     */
    public String toString() {
        return "" + (char)('A' + this.file) + (Chess.BOARD_RANKS - this.rank);
    }

    /**
     * A static method that, given a valid string indicating a chessboard square
     * in chess notation, e.g. "a8" or "A8", creates a position object after
     * verification. Returns <code>null</code> otherwise.
     * Such methods are known as static factory methods and are advantageous in
     * a multitude of ways.
     *
     * @param s         the name of the chessboard square, such as "A8"
     * @return          a position object or <code>null</code>
     */
    public static Position generateFromString(String s) {
        s = s.toUpperCase();
        if (s.length() != 2
                || (s.charAt(0) < 'A' || s.charAt(0) >= 'A' + Chess.BOARD_FILES)
                || (s.charAt(1) < '1' || s.charAt(1) >= '1' + Chess.BOARD_RANKS)
        )
            return null;
        return generateFromRankAndFile(Chess.BOARD_RANKS - s.charAt(1) + '0',
                                       s.charAt(0) - 'A');
    }

    /**
     * A static method that takes two valid integers representing rank and file,
     * creates a position object after verification. Returns <code>null</code>
     * otherwise.
     * Such methods are known as static factory methods and are advantageous in
     * a multitude of ways.
     *
     * @param rank      the rank of the chessboard square from 0(8) to 7(1)
     * @param file      the file of the chessboard square from 0(A) to 7(H)
     * @return          a position object or <code>null</code>
     */
    public static Position generateFromRankAndFile(int rank, int file) {
        Position result = null;
        if (rank >= 0 && rank < Chess.BOARD_RANKS
                && file >= 0 && file < Chess.BOARD_FILES
        )
            result = new Position(rank, file);
        return result;
    }

    /**
     * A static method that adds a given element of type <code>am.aua.chess.core.Position</code>
     * to an array of <code>am.aua.chess.core.Position</code>s.
     *
     * @param arr       an array, to which the given element should be added
     * @param arg        the element
     * @return          an extended array with the given elements
     */
    public static Position[] appendPositionsToArray(Position[] arr, Position... arg) {
        // Intentionally shallow
        Position[] result = new Position[arr.length + arg.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        for(int i = 0; i < arg.length; i++ ) {
            result[result.length-1+i] = arr[i];
        }
        return result;
    }
}
