package e2;

import org.junit.jupiter.api.BeforeEach;

public class LogicTest {

    private static final int BOARD_SIZE = 10;
    private static final int NUM_MINES = 10;
    Logics logics;

    @BeforeEach
    void setup() {
        logics = new LogicsImpl(BOARD_SIZE, NUM_MINES);
    }
    
}
