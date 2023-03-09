package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicTest {

    private static final int BOARD_SIZE = 10;
    private static final int NUM_MINES = 10;

    @Test
    void testRevealOnEmptyBoardShouldRetrieveWinResult() {
        final Logics logics = new LogicsImpl(BOARD_SIZE, 0);
        final var position = new Pair<>(0, 0);
        assertEquals(Result.WIN, logics.reveal(position));
    }

}
