package GameChess;
/**
 * The <code>Move</code> class represents moves of the player.
 */

public class Move {
    private Position origin, destination;
    /**
     * Constructs a newly allocated <code>Move</code> object
     *
     * @param newOrigin   <code>Position</code> type representing the origin
     * @param newDestination   <code>Position</code> type representing the destination
     */


    public Move(Position newOrigin, Position newDestination) {
        this.origin = newOrigin;
        this.destination = newDestination;
    }

    /**
     * Constructs a newly allocated <code>Move</code> object that
     * represents the same Move on the board without argument as the given argument.
     *
     * @param that      a <code>Move</code> object
     */

    public Move(Move that) {
        this.origin = new Position(that.origin);
        this.destination = new Position(that.destination);
    }

    /**
     * Returns the origin of the move.
     *
     * @return      the <code>Position</code> origin
     */

    public Position getOrigin() {
        return new Position(origin);
    }

    /**
     * Returns the destination of the move.
     *
     * @return      the <code>Position</code> destination
     */

    public Position getDestination() {
        return new Position(destination);
    }

    /**
     * Returns the String representation of the move.
     *
     * @return      the <code>String</code> representation
     */

    public String toString() {
        String a = origin.toString();
        String b = destination.toString();
        return (a+b);
    }


}
