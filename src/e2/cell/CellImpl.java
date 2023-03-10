package e2.cell;

import e2.Position;

public class CellImpl implements Cell {

    private final CellType type;

    private final Position position;

    private boolean flagged = false;

    private boolean revealed = false;

    public CellImpl(Position cellPosition) {
        this(cellPosition, CellType.EMPTY);
    }

    public CellImpl(Position position, CellType type) {
        this.position = position;
        this.type = type;
    }

    @Override
    public CellType getType() {
        return this.type;
    }

    @Override
    public Position getPosition() {
        return position;
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
