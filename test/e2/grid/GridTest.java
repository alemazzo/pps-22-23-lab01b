package e2.grid;

import e2.Position;
import e2.cell.Cell;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridTest {

    private final static int GRID_SIZE = 10;

    @Test
    void testGridShouldHaveSize() {
        final Grid grid = new GridImpl(GRID_SIZE);
        assertEquals(GRID_SIZE, grid.getSize());
    }

    @Test
    void testGridShouldExposeCellAtPosition() {
        final Grid grid = new GridImpl(GRID_SIZE);
        final var position = new Position(0, 0);
        final Optional<Cell> cell = grid.getCellAt(position);
        assertTrue(cell.isPresent());
        assertEquals(cell.get().getCellPosition(), position);
    }

}
