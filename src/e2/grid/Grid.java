package e2.grid;

import e2.Position;
import e2.cell.Cell;

import java.util.Optional;
import java.util.Set;

/**
 * A grid is a two-dimensional structure of cells.
 */
public interface Grid {

    /**
     * @return the size of this grid.
     */
    int getSize();

    /**
     * @param position the position of the cell to get.
     * @return the cell at the given position, if any.
     */
    Optional<Cell> getCellAt(Position position);

    /**
     * @param position the position of the cell to get the neighbours of.
     * @return the neighbours of the cell at the given position.
     */
    Set<Cell> getNeighboursOfCellAt(Position position);


    Set<Cell> getCells();

}
