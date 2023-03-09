package e2.grid;

import e2.Pair;

import java.util.Set;

public interface GridFactory {
    Grid emptyGrid(int size);

    Grid gridWithRandomMines(int size, int minesCount);

    Grid gridWithMinesAt(int size, Set<Pair<Integer, Integer>> minesPositions);
}
