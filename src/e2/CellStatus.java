package e2;

import e2.cell.Cell;
import e2.cell.CellType;

public record CellStatus(boolean revealed, boolean flagged, boolean mined, int minesAround) {

    public static CellStatus fromCell(Cell cell, int minesAround) {
        return new CellStatus(cell.isRevealed(), cell.isFlagged(), cell.getCellType() == CellType.MINE, minesAround);
    }

}
