package e2.grid;

import e2.grid.cell.Cell;

import java.util.Set;

public record GridImpl() implements Grid {


    @Override
    public Set<Cell> cells() {
        return Set.of();
    }
}
