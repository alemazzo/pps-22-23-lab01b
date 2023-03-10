package e2.cell;

import e2.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellFactoryTest {

    private CellFactory factory;

    @BeforeEach
    public void setup() {
        factory = new CellFactoryImpl();
    }

    @Test
    void testCellFactoryShouldCreateMineCell() {
        final var position = new Position(0, 0);
        Cell cell = factory.createMine(position);
        assertEquals(CellType.MINE, cell.getType());
    }

    @Test
    void testCellFactoryShouldCreateEmptyCell() {
        final var position = new Position(0, 0);
        Cell cell = factory.createEmpty(position);
        assertEquals(CellType.EMPTY, cell.getType());
    }

}
