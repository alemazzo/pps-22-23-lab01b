package e2.grid;

import e2.Pair;
import e2.grid.cell.Cell;

import java.util.Set;

/**
 * A grid of cells.
 */
public interface Grid {

    /**
     * The cells of the grid.
     *
     * @return the cells of the grid.
     */
    Set<Cell> cells();

    /**
     * The size of the grid.
     *
     * @return the size of the grid.
     */
    int size();

    /**
     * The neighbours of a cell.
     * <p>
     * A cell is a neighbour of another cell if it is at most one cell away from it.
     * A cell is not a neighbour of itself.
     *
     * @param position the position of the cell.
     * @return the neighbours of the cell.
     */
    Set<Cell> getNeighboursOf(Pair<Integer, Integer> position);
}
