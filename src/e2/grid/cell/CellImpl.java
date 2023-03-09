package e2.grid.cell;

import e2.Pair;

public record CellImpl(Pair<Integer, Integer> position, boolean hasMine) implements Cell {

}
