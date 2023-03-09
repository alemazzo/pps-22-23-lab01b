package e2.cell;

import e2.Position;

/**
 * A cell in a minesweeper game.
 */
public interface Cell {

    /**
     * @return the type of this cell.
     */
    CellType getCellType();
    
    /**
     * @return the position of this cell.
     */
    Position getCellPosition();

    /**
     * @return true if this cell is revealed, false otherwise.
     */
    boolean isRevealed();

    /**
     * Reveals this cell.
     */
    void reveal();

    /**
     * @return true if this cell is flagged, false otherwise.
     */
    boolean isFlagged();

    /**
     * Flags this cell.
     */
    void flag();

}
