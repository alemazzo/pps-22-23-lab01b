package e2.grid;

import e2.Position;
import e2.cell.Cell;
import e2.cell.CellType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridFactoryTest {

    private final int GRID_SIZE = 10;

    private GridFactory factory;

    @BeforeEach
    public void setup() {
        factory = new GridFactoryImpl();
    }

    @Test
    void testCanCreateEmptyGrid() {
        final Grid grid = factory.createEmptyGrid(GRID_SIZE);
        assertEquals(GRID_SIZE, grid.getSize());
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                final var position = new Position(i, j);
                final Optional<Cell> cell = grid.getCellAt(position);
                assertTrue(cell.isPresent());
                assertEquals(CellType.EMPTY, cell.get().getCellType());
            }
        }
    }
}
