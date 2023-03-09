package e2.cell;

import e2.Position;

public class CellFactoryImpl implements CellFactory {

    @Override
    public Cell createMineCell(Position position) {
        return new CellImpl(position, CellType.MINE);
    }

    @Override
    public Cell createEmptyCell(Position position) {
        return new CellImpl(position, CellType.EMPTY);
    }
    
}
