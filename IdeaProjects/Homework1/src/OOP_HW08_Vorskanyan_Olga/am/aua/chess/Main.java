package am.aua.chess;
import am.aua.chess.cli.ChessConsole;

/**
 * The <code>am.aua.chess.Main</code> class includes the entry point of the chess program.
 * 
 * @author Hovak Abramian <a href="mailto:hovag.abramian@aua.am">hovag.abramian@aua.am</a>
 * @author Varduhi Yeghiazaryan <a href="mailto:vyeghiazaryan@aua.am">vyeghiazaryan@aua.am</a>
 * @version 1.0
 * @since 1.0
 */
public class Main {
    /**
     * The entry point of the chess program. Creates a <code>am.aua.chess.cli.ChessConsole</code>
     * and invokes the <code>play</code> method on it.
     */
    public static void main(String[] args) {
        ChessConsole chessConsole = new ChessConsole();
        chessConsole.play();

    }
}
