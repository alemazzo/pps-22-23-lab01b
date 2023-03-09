package e2.cell;

import e2.Position;

public class CellImpl implements Cell {

    private final Position cellPosition;

    public CellImpl(Position cellPosition) {
        this.cellPosition = cellPosition;
    }

    @Override
    public Position getCellPosition() {
        return cellPosition;
    }
}
