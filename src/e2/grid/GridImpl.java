package e2.grid;

import e2.Pair;
import e2.grid.cell.Cell;
import e2.grid.cell.CellImpl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridImpl implements Grid {

    private final Set<Cell> cells = new HashSet<>();
    private final int size;

    public GridImpl(int size, Set<Pair<Integer, Integer>> minesPositions) {
        this.size = size;
        IntStream.range(0, size).forEach(i -> {
            IntStream.range(0, size).forEach(j -> {
                final var position = new Pair<>(i, j);
                final var cell = new CellImpl(position, minesPositions.contains(position));
                this.cells.add(cell);
            });
        });
    }

    @Override
    public Set<Cell> cells() {
        return Collections.unmodifiableSet(this.cells);
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean areNeighbours(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        return Math.abs(a.getX() - b.getX()) <= 1 && Math.abs(a.getY() - b.getY()) <= 1;
    }

    @Override
    public Set<Cell> getNeighboursOf(Pair<Integer, Integer> position) {
        return this.cells.stream()
                .filter(cell -> !position.equals(cell.position()))
                .filter(cell -> this.areNeighbours(cell.position(), position))
                .collect(Collectors.toSet());
    }

    @Override
    public RevealResult reveal(Pair<Integer, Integer> position) {
        final var cell = this.cells.stream()
                .filter(c -> c.position().equals(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid position: " + position));

        if (cell.hasMine()) {
            return RevealResult.MINE;
        }

        final var neighbours = this.getNeighboursOf(position);
        final var minesCount = neighbours.stream()
                .filter(Cell::hasMine)
                .count();

        if (minesCount == 0) {
            neighbours.forEach(Cell::reveal);
        }

        cell.reveal();
        return RevealResult.EMPTY;
    }

}
