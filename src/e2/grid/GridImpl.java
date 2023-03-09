package e2.grid;

import e2.Pair;
import e2.grid.cell.Cell;
import e2.grid.cell.CellImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class GridImpl implements Grid {

    private final Map<Pair<Integer, Integer>, Cell> grid = new HashMap<>();

    private final int size;

    public GridImpl(int size) {
        this(size, Set.of());
    }


    public GridImpl(int size, Set<Pair<Integer, Integer>> minesPositions) {
        this.size = size;
        IntStream.range(0, size).forEach(i -> {
            IntStream.range(0, size).forEach(j -> {
                final var position = new Pair<>(i, j);
                final var cell = new CellImpl(minesPositions.contains(position));
                this.grid.put(position, cell);
            });
        });
    }

    @Override
    public Set<Cell> cells() {
        return Set.copyOf(this.grid.values());
    }

    @Override
    public int size() {
        return this.size;
    }

}
