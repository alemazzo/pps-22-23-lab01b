package e2.cell;

import e2.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @BeforeEach
    public void setup() {

    }

    @Test
    void testCellShouldHavePosition() {
        final var cellPosition = new Position(0, 0);
        Cell cell = new CellImpl(cellPosition);
        assertEquals(cellPosition, cell.getCellPosition());
    }

    @Test
    void testCellShouldHaveRevealedState() {
        final var cellPosition = new Position(0, 0);
        Cell cell = new CellImpl(cellPosition);
        assertFalse(cell.isRevealed());
    }

    @Test
    void testCellShouldBeRevealable() {
        final var cellPosition = new Position(0, 0);
        Cell cell = new CellImpl(cellPosition);
        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    @Test
    void testCellShouldBeRevealableOnlyOnce() {
        final var cellPosition = new Position(0, 0);
        Cell cell = new CellImpl(cellPosition);
        cell.reveal();
        assertTrue(cell.isRevealed());
        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    @Test
    void testCellShouldHaveFlaggedState() {
        final var cellPosition = new Position(0, 0);
        Cell cell = new CellImpl(cellPosition);
        assertFalse(cell.isFlagged());
    }

    @Test
    void testCellShouldBeFlaggable() {
        final var cellPosition = new Position(0, 0);
        Cell cell = new CellImpl(cellPosition);
        cell.flag();
        assertTrue(cell.isFlagged());
    }

}
