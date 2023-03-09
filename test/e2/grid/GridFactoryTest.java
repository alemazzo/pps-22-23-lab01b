package e2.grid;

import e2.Pair;
import e2.grid.cell.Cell;
import e2.grid.factory.GridFactory;
import e2.grid.factory.GridFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testGridWithRandomMinesShouldRetrieveDifferentPosition() {
        final int maxMinesCount = DEFAULT_SIZE * DEFAULT_SIZE;
        final Grid grid = factory.gridWithRandomMines(DEFAULT_SIZE, maxMinesCount);
        assertEquals(maxMinesCount, grid.cells().stream()
                .filter(Cell::hasMine)
                .count()
        );
    }

    @Test
    void testGridWithMinesAt() {
        final var minesPositions = Set.of(
                new Pair<>(0, 0),
                new Pair<>(0, 1)
        );
        final Grid grid = factory.gridWithMinesAt(DEFAULT_SIZE, minesPositions);
        assertEquals(DEFAULT_SIZE, grid.size());
        assertEquals(2, grid.cells().stream()
                .filter(Cell::hasMine)
                .count()
        );
        assertTrue(grid.cells().stream()
                .filter(Cell::hasMine)
                .allMatch(cell -> minesPositions.contains(cell.position()))
        );
    }


}
