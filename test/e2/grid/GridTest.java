package e2.grid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    private final int BOARD_SIZE = 10;

    private Grid grid;

    @BeforeEach
    void setup() {
        grid = new GridImpl(BOARD_SIZE);
    }

    @Test
    void testGridHasSize() {
        assertEquals(BOARD_SIZE, grid.size());
    }
    
}
