package e2;

import java.util.Set;

public interface Cell {
    boolean hasMine();

    Set<Cell> neighbours();
}
