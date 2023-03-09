package e2.grid;

import e2.Position;
import e2.cell.Cell;
import e2.cell.CellType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridFactoryTest {

    private final int GRID_SIZE = 10;

    private GridFactory factory;

    @BeforeEach
    public void setup() {
        factory = new GridFactoryImpl();
    }


    private Set<Cell> getCellsFromGrid(Grid grid) {
        Set<Cell> cells = new HashSet<>();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                final var position = new Position(i, j);
                final Optional<Cell> cell = grid.getCellAt(position);
                assertTrue(cell.isPresent());
                cells.add(cell.get());
            }
        }
        return cells;
    }

    @Test
    void testCanCreateEmptyGrid() {
        final Grid grid = factory.createEmptyGrid(GRID_SIZE);
        assertEquals(GRID_SIZE, grid.getSize());
        final Set<Cell> cells = getCellsFromGrid(grid);
        assertEquals(GRID_SIZE * GRID_SIZE, cells.size());
        for (Cell cell : cells) {
            assertEquals(CellType.EMPTY, cell.getCellType());
        }
    }

    @Test
    void testCanCreateGridWithRandomMines() {
        final var minesCount = 5;
        final Grid grid = factory.createGridWithRandomMines(GRID_SIZE, minesCount);
        final Set<Cell> cells = getCellsFromGrid(grid);

        int minesInGrid = cells.stream()
                .filter(cell -> cell.getCellType() == CellType.MINE)
                .mapToInt(cell -> 1)
                .sum();
        assertEquals(minesCount, minesInGrid);
    }
    
}
