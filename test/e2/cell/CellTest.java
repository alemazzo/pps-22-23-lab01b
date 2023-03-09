package e2.cell;

import e2.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
