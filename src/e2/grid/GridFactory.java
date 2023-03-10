package e2.grid;

import e2.Position;

import java.util.Set;

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

    /**
     * Creates a grid with the specified size and places mines at the specified positions.
     *
     * @param gridSize       the size of the grid
     * @param minesPositions the positions of the mines
     * @return the grid
     */
    Grid createGridWithSpecifiedMines(int gridSize, Set<Position> minesPositions);
    
}
