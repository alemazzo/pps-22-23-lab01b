package e2.grid.cell;

import java.util.Collections;
import java.util.Set;

public record CellImpl(boolean hasMine, Set<Cell> neighbours) implements Cell {

    @Override
    public Set<Cell> neighbours() {
        return Collections.unmodifiableSet(this.neighbours);
    }
}
