package e2;

import e2.grid.RevealResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicTest {

    private static final int BOARD_SIZE = 10;
    private static final int NUM_MINES = 10;
    private Logics logics;

    @BeforeEach
    void setup() {

    }

    @Test
    void testRevealOnEmptyGridLogic() {
        this.logics = new LogicsImpl(BOARD_SIZE, 0);
        final var result = this.logics.reveal(new Pair<>(0, 0));
        assertEquals(RevealResult.EMPTY, result);
    }

}
