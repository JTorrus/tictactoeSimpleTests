import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JuegoAdvancedTest {
    @Test
    public void whenBoardIsFullGameIsOver () {
        Juego game = new Juego(createFullBoard(), new Player[0]);
        assertTrue(game.isOver());
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------

    private Tablero createFullBoard() {
        Tablero board = mock(Tablero.class);
        Casilla occupiedSquare = mock(Casilla.class);
        when(occupiedSquare.isOccupied()).thenReturn(true);

        when(board.getCasilla(any(Posicion.class))).thenReturn(occupiedSquare);
        return board;
    }

    private Player[] createPairOfPlayers() {
        Player playerOne = mock(Player.class);
        when(playerOne.getChip()).thenReturn('X');

        Player playerTwo = mock(Player.class);
        when(playerTwo.getChip()).thenReturn('O');

        return new Player[]{playerOne, playerTwo};
    }

    private Casilla createEmptySquare() {
        Casilla emptySquare = mock(Casilla.class);

        when(emptySquare.getChip()).thenReturn(' ');
        when(emptySquare.isOccupied()).thenReturn(false);

        return emptySquare;
    }

    private Casilla createOccupiedSquare() {
        Casilla occupiedSquare = mock(Casilla.class);

        when(occupiedSquare.getChip()).thenReturn('X');
        when(occupiedSquare.isOccupied()).thenReturn(true);

        return occupiedSquare;
    }

    private Tablero createColumnFilledBoard() {
        Tablero board = mock(Tablero.class);
        final Casilla emptySquare = createEmptySquare();
        final Casilla occupiedSquare = createOccupiedSquare();

        when(board.getCasilla(any(Posicion.class))).then(new Answer<Casilla>() {
            public Casilla answer(InvocationOnMock invocationOnMock) {
                Posicion positionUnderAnswer = (Posicion) invocationOnMock.getArguments()[0];

                if (positionUnderAnswer.getX() == 0 && positionUnderAnswer.getY() == 0 || positionUnderAnswer.getX() == 1 && positionUnderAnswer.getY() == 0 || positionUnderAnswer.getY() == 2 && positionUnderAnswer.getY() == 0) {
                    return occupiedSquare;
                } else {
                    return emptySquare;
                }
            }
        });

        return board;
    }

    private Tablero createRowFilledBoard() {

    }

    private Tablero createRightsideDiagonalFilledBoard() {

    }

    private Tablero createLeftsideDiagonalFilledBoard() {

    }
}
