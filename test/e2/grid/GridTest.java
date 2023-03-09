package e2.grid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    private GridFactory gridFactory;

    @BeforeEach
    void setup() {
        this.gridFactory = new GridFactoryImpl();
    }

    @Test
    void testGridSize() {
        final var gridSize = 10;
        final Grid grid = gridFactory.emptyGrid(gridSize);
        assertEquals(gridSize, grid.size());
    }

}
