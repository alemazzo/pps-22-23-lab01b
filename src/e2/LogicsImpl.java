package e2;

import e2.cell.Cell;
import e2.cell.CellStatus;
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
        cell.reveal();

        if (cell.getType() == CellType.MINE) {
            return RevealResult.LOSE;
        }

        final Set<Cell> neighbours = grid.getNeighboursOfCellAt(position);
        final long numMines = neighbours.stream()
                .filter(neighbour -> neighbour.getType() == CellType.MINE)
                .count();

        if (numMines == 0) {
            neighbours.stream()
                    .filter(neighbour -> !neighbour.isRevealed())
                    .forEach(neighbour -> reveal(neighbour.getPosition()));
        }

        if (grid.areAllEmptyCellsRevealed()) {
            return RevealResult.WIN;
        }

        return RevealResult.EMPTY;

    }

    @Override
    public void toggleFlag(Position position) {
        this.grid.getCellAt(position).ifPresent(Cell::flag);
    }

    @Override
    public CellStatus getCellStatus(Position position) {
        final var minesAround = (int) grid.getNeighboursOfCellAt(position).stream()
                .filter(cell -> cell.getType() == CellType.MINE)
                .count();
        return CellStatus.fromCell(this.grid.getCellAt(position).orElseThrow(), minesAround);
    }
}
