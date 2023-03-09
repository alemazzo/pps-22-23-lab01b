package e2.grid;

import e2.Pair;
import e2.grid.cell.Cell;

import java.util.Set;

public interface Grid {

    Set<Cell> cells();

    int size();

    Set<Cell> getNeighboursOf(Pair<Integer, Integer> integerIntegerPair);
}
