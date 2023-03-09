package e2.grid.cell;

import e2.Pair;

public interface Cell {

    Pair<Integer, Integer> position();

    boolean hasMine();

}
