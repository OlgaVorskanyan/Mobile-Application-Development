package GameChess;

/**
 * The <code>Position</code> class represents a position on the chessboard.
 * An object of type <code>Position</code> contains two fields of type
 * <code>int</code> to represent the rank and file of the chessboard.
 */
public class Position {
    private int rank, file;

    //constructors

    /**
     * Constructs new <code>Position</code> object that shows a position on the board without arguments
     */

    public Position() {
        this.rank = 0;
        this.file = 0;
    }

    /**
     * Constructs a newly allocated <code>Position</code> object that
     * represents the same Position on the board without argument as the given argument.
     *
     * @param that      a <code>Position</code> object
     */

    public Position(Position that) {
        this.rank = that.rank;
        this.file = that.file;
    }


    // constructors
    /**
     * Constructs a newly allocated <code>Position</code> object that
     * represents the position onboard with the specified <code>int</code> rank and file.
     *
     * @param rank     the rank of the rectangle
     * @param file     the file of the rectangle
     */

    public Position(int rank, int file) {
        this.rank = rank;
        this.file = file;

    }

    // accessors
    /**
     * Returns the rank of the position.
     *
     * @return      the <code>int</code> rank
     */

    public int getRank() {
        return this.rank;
    }

    // accessors
    /**
     * Returns the file of the position.
     *
     * @return      the <code>int</code> file
     */

    public int getFile() {
        return this.file;
    }


    // mutators
    /**
     * Updates the rank of the position to the specified <code>int</code>
     *
     * @param newRank     the new <code>int</code> value for the rank
     */

    public void setRank(int newRank) {
        if (newRank >= 0 && newRank <= 7)
            this.rank = newRank;
        else
            System.out.println("Not a valid number!");

    }

    // mutators
    /**
     * Updates the file of the position to the specified <code>int</code>
     *
     * @param newFile    the new <code>int</code> value for the file
     */

    public void setFile(int newFile) {
        if (newFile >= 0 && newFile <= 7)
            this.file = newFile;
         else
            System.out.println("Not a valid number!");

    }

    /**
     * Generates a new String representation from rank and file
     * and we get string representation of the position
     *
     * @return  the <code>String</code> position
     */


    public String toString() {
        String file = null, rank = null;

        if(this.rank == 8)
            rank = "0";
        else if(this.rank == 7)
            rank = "1";
        else if(this.rank == 6)
            rank = "2";
        else if(this.rank == 5)
            rank = "3";
        else if(this.rank == 4)
            rank = "4";
        else if(this.rank == 3)
            rank = "5";
        else if(this.rank == 2)
            rank = "6";
        else if(this.rank == 1)
            rank = "7";

        if(this.file == 0)
            file = "A";
        else if(this.file == 1)
            file = "B";
        else if(this.rank == 3)
            file = "C";
        else if(this.rank == 4)
            file = "D";
        else if(this.rank == 5)
            file = "E";
        else if(this.rank == 6)
            file = "F";
        else if(this.rank == 7)
            file = "G";
        else if(this.rank == 8)
            file = "H";

        return (file + rank);
    }

    /**
     * Generates a new position from a given String argument
     *
     *
     * @param givenString           <code>String</code> representing the position
     * @return                      the new <code>Position</code> position
     */

    public static Position generateFromString(String givenString) {
        int rank = 0, file = 0;
        if(givenString.charAt(0) == 'A')
            file = 0;
        else if(givenString.charAt(0) == 'B')
            file = 1;
        else if(givenString.charAt(0) == 'C')
            file = 2;
        else if(givenString.charAt(0) == 'D')
            file = 3;
        else if(givenString.charAt(0) == 'E')
            file = 4;
        else if(givenString.charAt(0) == 'F')
            file = 5;
        else if(givenString.charAt(0) == 'G')
            file = 6;
        else if(givenString.charAt(0) == 'H')
            file = 7;

        if(givenString.charAt(1) == '8')
            rank = 0;
        else if(givenString.charAt(1) == '7')
            rank = 1;
        else if(givenString.charAt(1) == '6')
            rank = 2;
        else if(givenString.charAt(1) == '5')
            rank = 3;
        else if(givenString.charAt(1) == '4')
            rank = 4;
        else if(givenString.charAt(1) == '3')
            rank = 5;
        else if(givenString.charAt(1) == '2')
            rank = 6;
        else if(givenString.charAt(1) == '1')
            rank = 7;

        return new Position (rank, file);

    }

    /**
     *
     * @param givenNumberOne the new <code>int</code> value for the given first Number which is rank
     * @param givenNumberTwo the new<code>Position</code> value for the given second Number which is file
     *
     * @return   the new <code>Position</code> position
     */


    public static Position generateFromRankAndFile(int givenNumberOne,int givenNumberTwo){
        return new Position(givenNumberOne, givenNumberTwo);
    }

    /** Appends new Position type object to an array of positions
     *
     * @param arr the new <code>arr</code> our array of positions
     * @param p    the new<code>Position</code> which we append
     *
     * @return  the new <code>Position</code> array
     */

    public static Position[] appendPositionToArray(Position[] arr, Position p){
        Position[] arrayLongSized = new Position[arr.length+1];
        for(int i = 0; i<=arr.length-1; i++)
            arrayLongSized[i] = arr[i];
        arrayLongSized[arr.length] = p;
        return arrayLongSized;
    }

}