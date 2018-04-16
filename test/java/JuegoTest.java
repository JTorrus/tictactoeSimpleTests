
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JuegoTest {


    @Test
    public void whenBoardIsFullGameIsOver () {
        Casilla[][] board = createFullBoard();
        Juego game = new Juego(new Tablero(board), new Player[0]);
        assertTrue(game.isOver());
    }

    @Test
    public void playerOneWinsWhenFillingLeftsideDiagonalWorks() {
        Player[] pairOfPlayers = createPairOfPlayers();
        Juego gameUnderTest = new Juego(createLeftsideDiagonalFilledBoard(), pairOfPlayers);

        assertTrue(pairOfPlayers[0] == gameUnderTest.whoWon());
    }

    @Test
    public void playerOneWinsWhenFillingRightsideDiagonalWorks() {
        Player[] pairOfPlayers = createPairOfPlayers();
        Juego gameUnderTest = new Juego(createRightsideDiagonalFilleddBoard(), pairOfPlayers);

        assertTrue(pairOfPlayers[0] == gameUnderTest.whoWon());
    }

    @Test
    public void playerOneWinsWhenFillingColumnWorks() {
        Player[] pairOfPlayers = createPairOfPlayers();
        Juego gameUnderTest = new Juego(createColumnFilledBoard(), pairOfPlayers);

        assertTrue(pairOfPlayers[0] == gameUnderTest.whoWon());

    }

    @Test
    public void playerOneWinsWhenFillingRowWorks() {

    }

    private Casilla[][] createFullBoard() {
        Casilla[][] board = new Casilla[3][3];
        Casilla occupiedSquare = mock(Casilla.class);
        when(occupiedSquare.isOccupied()).thenReturn(true);
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                board[x][y] = occupiedSquare;
            }
        }
        return board;
    }

    private Player[] createPairOfPlayers() {
        Player playerOne = mock(Player.class);
        when(playerOne.getChip()).thenReturn('X');

        Player playerTwo = mock(Player.class);
        when(playerTwo.getChip()).thenReturn('O');

        return new Player[]{playerOne, playerTwo};
    }

    private Tablero createColumnFilledBoard() {
        Posicion positionOne = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(0);
        when(positionOne.getY()).thenReturn(0);

        Posicion positionTwo = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(1);
        when(positionOne.getY()).thenReturn(0);

        Posicion positionThree = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(2);
        when(positionOne.getY()).thenReturn(0);

        Tablero board = new Tablero(simulateEmptyBoard());

        board.getCasilla(positionOne).setChip('X');
        board.getCasilla(positionTwo).setChip('X');
        board.getCasilla(positionThree).setChip('X');

        return board;
    }

    private Tablero createRowFilledBoard() {
        Posicion positionOne = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(0);
        when(positionOne.getY()).thenReturn(0);

        Posicion positionTwo = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(0);
        when(positionOne.getY()).thenReturn(1);

        Posicion positionThree = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(0);
        when(positionOne.getY()).thenReturn(2);

        Tablero board = new Tablero(simulateEmptyBoard());

        board.getCasilla(positionOne).setChip('X');
        board.getCasilla(positionTwo).setChip('X');
        board.getCasilla(positionThree).setChip('X');

        return board;
    }

    private Tablero createRightsideDiagonalFilleddBoard() {
        Posicion positionOne = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(0);
        when(positionOne.getY()).thenReturn(0);

        Posicion positionTwo = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(1);
        when(positionOne.getY()).thenReturn(1);

        Posicion positionThree = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(2);
        when(positionOne.getY()).thenReturn(2);

        Tablero board = new Tablero(simulateEmptyBoard());

        board.getCasilla(positionOne).setChip('X');
        board.getCasilla(positionTwo).setChip('X');
        board.getCasilla(positionThree).setChip('X');

        return board;
    }

    private Tablero createLeftsideDiagonalFilledBoard() {
        Posicion positionOne = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(0);
        when(positionOne.getY()).thenReturn(2);

        Posicion positionTwo = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(1);
        when(positionOne.getY()).thenReturn(1);

        Posicion positionThree = mock(Posicion.class);
        when(positionOne.getX()).thenReturn(2);
        when(positionOne.getY()).thenReturn(0);

        Tablero board = new Tablero(simulateEmptyBoard());

        board.getCasilla(positionOne).setChip('X');
        board.getCasilla(positionTwo).setChip('X');
        board.getCasilla(positionThree).setChip('X');

        return board;
    }

    private Casilla[][] simulateEmptyBoard() {
        Casilla[][] cells = new Casilla[3][3];
        Casilla emptySquare = mock(Casilla.class);
        when(emptySquare.isOccupied()).thenReturn(false);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                cells[x][y] = emptySquare;
            }
        }

        return cells;
    }
}
