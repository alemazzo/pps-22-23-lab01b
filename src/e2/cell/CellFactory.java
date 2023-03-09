package e2.cell;

import e2.Position;

public interface CellFactory {
    Cell createMineCell(Position position);

    Cell createEmptyCell(Position position);
}
