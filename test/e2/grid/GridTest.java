package e2.grid;

import e2.Pair;
import e2.grid.cell.Cell;
import e2.grid.factory.GridFactory;
import e2.grid.factory.GridFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    private final static int DEFAULT_SIZE = 10;

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

    @Test
    void testGridGetNeighboursOf() {
        final var gridSize = 10;
        final var minesPositions = Set.of(
                new Pair<>(0, 0),
                new Pair<>(0, 1)
        );
        final Grid grid = gridFactory.gridWithMinesAt(gridSize, minesPositions);
        final var neighbours = grid.getNeighboursOf(new Pair<>(0, 0));
        assertEquals(3, neighbours.size());
        assertEquals(1, neighbours.stream()
                .filter(Cell::hasMine)
                .count());
    }

    @Test
    void testRevealMineShouldReturnResultMine() {
        final Grid grid = this.gridFactory.gridWithMinesAt(DEFAULT_SIZE, Set.of(
                new Pair<>(0, 0)
        ));
        final RevealResult result = grid.reveal(new Pair<>(0, 0));
        assertEquals(RevealResult.MINE, result);
    }

    @Test
    void testRevealEmptyCellShouldReturnResultEmpty() {
        final Grid grid = this.gridFactory.emptyGrid(DEFAULT_SIZE);
        final RevealResult result = grid.reveal(new Pair<>(0, 0));
        assertEquals(RevealResult.EMPTY, result);
    }

}
