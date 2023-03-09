package e2.grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    private final static int GRID_SIZE = 10;

    @Test
    void testGridShouldHaveSize() {
        final Grid grid = new GridImpl(GRID_SIZE);
        assertEquals(GRID_SIZE, grid.getSize());
    }

}
