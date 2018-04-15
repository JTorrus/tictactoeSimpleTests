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
}
