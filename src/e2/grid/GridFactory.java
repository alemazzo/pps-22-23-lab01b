package e2.grid;

/**
 * Factory for creating grids.
 */
public interface GridFactory {

    /**
     * Creates a grid with the specified size.
     *
     * @param gridSize the size of the grid
     * @return the grid
     */
    Grid createEmptyGrid(int gridSize);

    /**
     * Creates a grid with the specified size and randomly places mines.
     *
     * @param gridSize   the size of the grid
     * @param minesCount the number of mines to place
     * @return the grid
     */
    Grid createGridWithRandomMines(int gridSize, int minesCount);

}
