package e2;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicTest {

    private static final int BOARD_SIZE = 10;
    private static final int NUM_MINES = 10;
    private Logics logics;

    @Test
    void testLogicShouldExposeReveal() {
        final var minesPositions = Set.of(
                new Position(0, 0),
                new Position(0, 1)
        );
        logics = new LogicsImpl(BOARD_SIZE, minesPositions);
        final var result = logics.reveal(new Position(0, 2));
        assertEquals(RevealResult.EMPTY, result);
    }

    @Test
    void testRevealOnEmptyBoardShouldReturnResultWin() {
        final var numMines = 0;
        logics = new LogicsImpl(BOARD_SIZE, numMines);
        final var result = logics.reveal(new Position(0, 0));
        assertEquals(RevealResult.WIN, result);
    }

}
