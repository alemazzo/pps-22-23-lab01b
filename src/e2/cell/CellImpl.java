package e2.cell;

import e2.Position;

public class CellImpl implements Cell {

    private final Position cellPosition;

    private final boolean revealed = false;

    public CellImpl(Position cellPosition) {
        this.cellPosition = cellPosition;
    }

    @Override
    public Position getCellPosition() {
        return cellPosition;
    }

    @Override
    public boolean isRevealed() {
        return this.revealed;
    }
}
