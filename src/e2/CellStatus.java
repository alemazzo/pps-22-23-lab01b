package e2;

import e2.cell.Cell;
import e2.cell.CellType;

public record CellStatus(boolean revealed, boolean flagged, boolean mined) {

    public static CellStatus fromCell(Cell cell) {
        return new CellStatus(cell.isRevealed(), cell.isFlagged(), cell.getCellType() == CellType.MINE);
    }

}
