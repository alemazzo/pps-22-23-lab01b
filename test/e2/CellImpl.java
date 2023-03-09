package e2;

import java.util.Collections;
import java.util.Set;

public class CellImpl implements Cell {

    private final boolean hasMine;

    private final Set<Cell> neighbours;

    public CellImpl(boolean hasMine, Set<Cell> neighbours) {
        this.hasMine = hasMine;
        this.neighbours = neighbours;
    }

    @Override
    public boolean hasMine() {
        return this.hasMine;
    }

    @Override
    public Set<Cell> neighbours() {
        return Collections.unmodifiableSet(this.neighbours);
    }
}
