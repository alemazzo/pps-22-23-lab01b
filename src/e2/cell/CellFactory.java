package e2.cell;

import e2.Position;

/**
 * A Factory for creating cells.
 */
public interface CellFactory {

    /**
     * Creates a new mine cell.
     *
     * @param position the position of the cell.
     * @return the new cell.
     */
    Cell createMine(Position position);

    /**
     * Creates a new empty cell.
     *
     * @param position the position of the cell.
     * @return the new cell.
     */
    Cell createEmpty(Position position);

}
