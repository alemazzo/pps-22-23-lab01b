package e2;

import e2.cell.CellStatus;

public interface Logics {

    RevealResult reveal(Position position);

    void toggleFlag(Position position);

    CellStatus getCellStatus(Position position);
}
