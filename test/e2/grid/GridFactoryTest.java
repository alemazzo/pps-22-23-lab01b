package e2.grid;

import e2.grid.cell.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridFactoryTest {

    private final static int DEFAULT_SIZE = 10;
    private GridFactory factory;

    @BeforeEach
    void setup() {
        this.factory = new GridFactoryImpl();
    }

    @Test
    void testEmptyGrid() {
        final Grid grid = factory.emptyGrid(DEFAULT_SIZE);
        assertEquals(DEFAULT_SIZE, grid.size());
        assertEquals(0, grid.cells().stream()
                .filter(Cell::hasMine)
                .count()
        );
    }

    @Test
    void testGridWithRandomMines() {
        final Grid grid = factory.gridWithRandomMines(DEFAULT_SIZE, 1);
        assertEquals(DEFAULT_SIZE, grid.size());
        assertEquals(1, grid.cells().stream()
                .filter(Cell::hasMine)
                .count()
        );
    }

}
