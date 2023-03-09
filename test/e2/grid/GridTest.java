package e2.grid;

import org.junit.jupiter.api.BeforeEach;

public class GridTest {

    private final int BOARD_SIZE = 10;

    private Grid grid;

    @BeforeEach
    void setup() {
        grid = new GridImpl(BOARD_SIZE);
    }
    
}
