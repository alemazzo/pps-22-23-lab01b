package e2.cell;

import e2.Position;

public interface Cell {
    Position getCellPosition();

    boolean isRevealed();

    void reveal();

    boolean isFlagged();
}
