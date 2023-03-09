package e2.cell;

import e2.Position;

public class CellImpl implements Cell {

    private final CellType cellType;

    private final Position cellPosition;
    private boolean flagged = false;
    private boolean revealed = false;

    public CellImpl(Position cellPosition) {
        this(cellPosition, CellType.EMPTY);
    }

    public CellImpl(Position cellPosition, CellType cellType) {
        this.cellPosition = cellPosition;
        this.cellType = cellType;
    }

    @Override
    public CellType getCellType() {
        return this.cellType;
    }

    @Override
    public Position getCellPosition() {
        return cellPosition;
    }

    @Override
    public boolean isRevealed() {
        return this.revealed;
    }

    @Override
    public void reveal() {
        this.revealed = true;
    }

    @Override
    public boolean isFlagged() {
        return this.flagged;
    }

    @Override
    public void flag() {
        this.flagged = !this.flagged;
    }

}
