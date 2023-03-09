package e2.grid;

import e2.Position;
import e2.cell.Cell;
import e2.cell.CellFactory;
import e2.cell.CellFactoryImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GridImpl implements Grid {

    private final CellFactory cellFactory = new CellFactoryImpl();
    private final int size;

    private final Set<Cell> cells = new HashSet<>();

    public GridImpl(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells.add(this.cellFactory.createEmptyCell(new Position(i, j)));
            }
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Optional<Cell> getCellAt(Position position) {
        return this.cells.stream()
                .filter(cell -> cell.getCellPosition().equals(position))
                .findFirst();
    }
}
