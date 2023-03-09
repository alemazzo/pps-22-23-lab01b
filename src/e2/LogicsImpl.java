package e2;

import e2.grid.Grid;
import e2.grid.RevealResult;
import e2.grid.factory.GridFactoryImpl;

public class LogicsImpl implements Logics {
    
    private final Grid grid;

    public LogicsImpl(int size, int numMines) {
        this.grid = new GridFactoryImpl().gridWithRandomMines(size, numMines);
    }

    @Override
    public RevealResult reveal(Pair<Integer, Integer> position) {
        return this.grid.reveal(position);
    }

}
