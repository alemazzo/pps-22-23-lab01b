package e2.grid.factory;

import e2.Pair;
import e2.grid.Grid;

import java.util.Set;

/**
 * A factory for creating grids.
 */
public interface GridFactory {

    /**
     * Create an empty grid.
     *
     * @param size the size of the grid.
     * @return the empty grid.
     */
    Grid emptyGrid(int size);

    /**
     * Create a grid with random mines.
     *
     * @param size       the size of the grid.
     * @param minesCount the number of mines.
     * @return the grid with random mines.
     */
    Grid gridWithRandomMines(int size, int minesCount);

    /**
     * Create a grid with mines at the given positions.
     *
     * @param size           the size of the grid.
     * @param minesPositions the positions of the mines.
     * @return the grid with mines at the given positions.
     */
    Grid gridWithMinesAt(int size, Set<Pair<Integer, Integer>> minesPositions);

}
