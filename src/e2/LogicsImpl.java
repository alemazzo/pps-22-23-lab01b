package e2;

import e2.cell.Cell;
import e2.cell.CellType;
import e2.grid.Grid;
import e2.grid.GridFactory;
import e2.grid.GridFactoryImpl;

import java.util.Optional;
import java.util.Set;

public class LogicsImpl implements Logics {

    private final GridFactory gridFactory = new GridFactoryImpl();

    private final Grid grid;

    public LogicsImpl(int size, int numMines) {
        this.grid = gridFactory.createGridWithRandomMines(size, numMines);
    }

    public LogicsImpl(int size, Set<Position> minesPositions) {
        this.grid = gridFactory.createGridWithSpecifiedMines(size, minesPositions);
    }

    @Override
    public RevealResult reveal(Position position) {
        final Optional<Cell> optCell = grid.getCellAt(position);
        if (optCell.isEmpty()) {
            throw new IllegalArgumentException("Invalid position");
        }

        final Cell cell = optCell.get();
        if (cell.getCellType().equals(CellType.MINE)) {
            return RevealResult.LOSE;
        } else {
            return RevealResult.EMPTY;
        }
    }
}
