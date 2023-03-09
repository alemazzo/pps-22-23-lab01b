package e2.cell;

import e2.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private CellFactory factory;

    @BeforeEach
    public void setup() {
        factory = new CellFactoryImpl();
    }

    @Test
    void testCellShouldHavePosition() {
        final var cellPosition = new Position(0, 0);
        final Cell cell = this.factory.createEmptyCell(cellPosition);
        assertEquals(cellPosition, cell.getCellPosition());
    }

    @Test
    void testCellShouldHaveRevealedState() {
        final var cellPosition = new Position(0, 0);
        final Cell cell = this.factory.createEmptyCell(cellPosition);
        assertFalse(cell.isRevealed());
    }

    @Test
    void testCellShouldBeRevealable() {
        final var cellPosition = new Position(0, 0);
        final Cell cell = this.factory.createEmptyCell(cellPosition);
        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    @Test
    void testCellShouldBeRevealableOnlyOnce() {
        final var cellPosition = new Position(0, 0);
        final Cell cell = this.factory.createEmptyCell(cellPosition);
        cell.reveal();
        assertTrue(cell.isRevealed());
        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    @Test
    void testCellShouldHaveFlaggedState() {
        final var cellPosition = new Position(0, 0);
        final Cell cell = this.factory.createEmptyCell(cellPosition);
        assertFalse(cell.isFlagged());
    }

    @Test
    void testCellShouldBeFlaggable() {
        final var cellPosition = new Position(0, 0);
        final Cell cell = this.factory.createEmptyCell(cellPosition);
        cell.flag();
        assertTrue(cell.isFlagged());
    }

    @Test
    void testCellCanBeUnflaggedByCallingFlagMultipleTimes() {
        final var cellPosition = new Position(0, 0);
        final Cell cell = this.factory.createEmptyCell(cellPosition);
        cell.flag();
        assertTrue(cell.isFlagged());
        cell.flag();
        assertFalse(cell.isFlagged());
    }

    @Test
    void testCellShouldHaveType() {
        final var cellPosition = new Position(0, 0);
        final Cell cell = this.factory.createEmptyCell(cellPosition);
        assertEquals(CellType.EMPTY, cell.getCellType());
    }

    @Test
    void testCellCanBeMine() {
        final var cellPosition = new Position(0, 0);
        final Cell cell = this.factory.createMineCell(cellPosition);
        assertEquals(CellType.MINE, cell.getCellType());
    }

}
