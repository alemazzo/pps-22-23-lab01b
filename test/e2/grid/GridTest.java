package e2.grid;

import e2.Position;
import e2.cell.Cell;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

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

    @Test
    void testGridShouldExposeGetNeighboursOfCellAt() {
        final Grid grid = new GridImpl(GRID_SIZE);
        final var position = new Position(0, 0);
        final Set<Cell> neighbours = grid.getNeighboursOfCellAt(position);
        assertEquals(3, neighbours.size());

        final var expectedNeighbours = Set.of(
                new Position(0, 1),
                new Position(1, 0),
                new Position(1, 1)
        );

        for (Cell neighbour : neighbours) {
            assertTrue(expectedNeighbours.contains(neighbour.getCellPosition()));
        }
    }

}
