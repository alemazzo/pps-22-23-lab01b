package e2.grid.cell;

import java.util.Set;

public interface Cell {
    boolean hasMine();

    Set<Cell> neighbours();
}
