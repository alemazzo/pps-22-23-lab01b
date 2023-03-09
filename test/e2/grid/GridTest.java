package e2.grid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    private Grid grid;

    @BeforeEach
    void setup() {
        grid = new GridImpl(1);
    }

    @Test
    void testGridHasCells() {
        final var actualCells = grid.cells();
        assertEquals(0, actualCells.size());
    }

}
