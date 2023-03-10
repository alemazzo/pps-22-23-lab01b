package e2.grid;

import e2.Position;
import e2.cell.Cell;
import e2.cell.CellFactory;
import e2.cell.CellFactoryImpl;
import e2.cell.CellType;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GridImpl implements Grid {

    private final CellFactory cellFactory = new CellFactoryImpl();

    private final Set<Cell> cells = new HashSet<>();

    public GridImpl(int size) {
        this(size, Set.of());
    }

    public GridImpl(int size, Set<Position> minesPositions) {
        build(size);
        for (Position position : minesPositions) {
            this.cells.removeIf(cell -> cell.getPosition().equals(position));
            this.cells.add(this.cellFactory.createMine(position));
        }
    }

    private void build(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells.add(this.cellFactory.createEmpty(new Position(i, j)));
            }
        }
    }

    @Override
    public int getSize() {
        return (int) Math.sqrt(this.cells.stream()
                .mapToInt(cell -> 1)
                .sum());
    }

    @Override
    public Optional<Cell> getCellAt(Position position) {
        return this.cells.stream()
                .filter(cell -> cell.getPosition().equals(position))
                .findFirst();
    }

    private boolean areNeighbours(Position position1, Position position2) {
        return !position1.equals(position2) &&
                Math.abs(position1.getX() - position2.getX()) <= 1 &&
                Math.abs(position1.getY() - position2.getY()) <= 1;
    }

    @Override
    public Set<Cell> getNeighboursOfCellAt(Position position) {
        return this.cells.stream()
                .filter(cell -> areNeighbours(position, cell.getPosition()))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean areAllEmptyCellsRevealed() {
        return this.cells.stream()
                .filter(cell -> cell.getType().equals(CellType.EMPTY))
                .allMatch(Cell::isRevealed);
    }

}
