package e2.grid.cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private static final Set<Cell> DEFAULT_NEIGHBOURS = Set.of();
    private Cell cell;

    @BeforeEach
    void setup() {

    }

    @Test
    void testCellHasNoMine() {
        final boolean hasMine = false;
        this.cell = new CellImpl(hasMine, DEFAULT_NEIGHBOURS);
        assertFalse(cell.hasMine());
    }

    @Test
    void testCellHasMine() {
        final boolean hasMine = true;
        this.cell = new CellImpl(hasMine, DEFAULT_NEIGHBOURS);
        assertTrue(cell.hasMine());
    }

    @Test
    void testCellHasNoNeighbours() {
        this.cell = new CellImpl(false, DEFAULT_NEIGHBOURS);
        final var actualNeighbours = cell.neighbours();
        assertEquals(DEFAULT_NEIGHBOURS.size(), actualNeighbours.size());
        assertTrue(actualNeighbours.containsAll(DEFAULT_NEIGHBOURS));
    }

    @Test
    void testCellHasNeighbours() {
        final Set<Cell> neighbours = Set.of(
                new CellImpl(true, Set.of()),
                new CellImpl(false, Set.of())
        );
        this.cell = new CellImpl(false, neighbours);
        final var actualNeighbours = cell.neighbours();
        assertEquals(neighbours.size(), actualNeighbours.size());
        assertTrue(actualNeighbours.containsAll(neighbours));
    }


}
