package e2.cell;

public record CellStatus(boolean revealed, boolean flagged, boolean mined, int minesAround) {

    public static CellStatus fromCell(Cell cell, int minesAround) {
        return new CellStatus(cell.isRevealed(), cell.isFlagged(), cell.getType() == CellType.MINE, minesAround);
    }

}
