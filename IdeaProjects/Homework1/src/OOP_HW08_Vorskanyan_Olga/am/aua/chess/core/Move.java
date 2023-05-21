package am.aua.chess.core;

/**
 * The <code>am.aua.chess.core.Move</code> class stores and represents a move that a player makes
 * during a chess game.
 *
 * @author Hovak Abramian <a href="mailto:hovag.abramian@aua.am">hovag.abramian@aua.am</a>
 * @author Varduhi Yeghiazaryan <a href="mailto:vyeghiazaryan@aua.am">vyeghiazaryan@aua.am</a>
 * @version 1.0
 * @since 1.0
 */
public class Move {
    //immutable, contains mutable references
    // an instance variable for the origin position
    private Position origin;
    // an instance variable for the destination position
    private Position destination;

    /**
     * Constructs a new <code>am.aua.chess.core.Move</code> from given origin and destination
     * <code>am.aua.chess.core.Position</code>s.
     *
     * @param origin        the origin <code>am.aua.chess.core.Position</code>
     * @param destination   the destination <code>am.aua.chess.core.Position</code>
     */
    public Move(Position origin, Position destination) {
        this.origin = new Position(origin);
        this.destination = new Position(destination);
    }

    /**
     * Constructs a new <code>am.aua.chess.core.Move</code> to be an exact copy of a given
     * <code>am.aua.chess.core.Move</code>.
     *
     * @param other     the <code>am.aua.chess.core.Move</code> to be copied
     */
    public Move(Move other) {
        this.origin = new Position(other.origin);
        this.destination = new Position(other.destination);
    }

    /**
     * Returns the origin of this <code>am.aua.chess.core.Move</code>.
     *
     * @return          the origin <code>am.aua.chess.core.Position</code>
     */
    public Position getOrigin() {
        return new Position(this.origin);
    }

    /**
     * Returns the destination of this <code>am.aua.chess.core.Move</code>.
     *
     * @return          the destination <code>am.aua.chess.core.Position</code>
     */
    public Position getDestination() {
        return new Position(this.destination);
    }

    /**
     * Returns a <code>String</code> representation of this <code>am.aua.chess.core.Move</code>
     * with a format like "C2 C4".
     *
     * @return          the <code>String</code> representation
     */
    public String toString() {
        return this.origin.toString() + " " + this.destination.toString();
    }
}
