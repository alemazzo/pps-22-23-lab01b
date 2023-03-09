package e2.grid.cell;

import e2.Pair;

/**
 * A cell in a grid.
 * <p>
 * It has a position, and it can have a mine or not.
 * It also has a revealed state that can be changed.
 */
public interface Cell {

    /**
     * The position of the cell.
     *
     * @return the position of the cell.
     */
    Pair<Integer, Integer> position();

    /**
     * Whether the cell has a mine or not.
     *
     * @return true if the cell has a mine, false otherwise.
     */
    boolean hasMine();

    /**
     * Whether the cell is revealed or not.
     *
     * @return true if the cell is revealed, false otherwise.
     */
    boolean isRevealed();

    /**
     * Reveals the cell.
     */
    void reveal();

}
