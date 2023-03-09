package e2.grid;

import e2.Position;
import e2.cell.Cell;

import java.util.Optional;

public interface Grid {

    int getSize();

    Optional<Cell> getCellAt(Position position);
}
