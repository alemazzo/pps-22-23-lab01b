package e2.grid.cell;

import e2.Cell;
import e2.CellImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {

    private Cell cell;

    @BeforeEach
    void setup() {

    }

    @Test
    void testCellHasNoMine() {
        final boolean hasMine = false;
        this.cell = new CellImpl(hasMine);
        assertFalse(cell.hasMine());
    }

    @Test
    void testCellHasMine() {
        final boolean hasMine = true;
        this.cell = new CellImpl(hasMine);
        assertTrue(cell.hasMine());
    }

}
