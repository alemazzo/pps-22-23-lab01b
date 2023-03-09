package e2.grid.cell;

import e2.Pair;

import java.util.Objects;

public final class CellImpl implements Cell {

    private final Pair<Integer, Integer> position;
    private final boolean hasMine;
    private boolean revealed = false;

    public CellImpl(Pair<Integer, Integer> position, boolean hasMine) {
        this.position = position;
        this.hasMine = hasMine;
    }

    @Override
    public Pair<Integer, Integer> position() {
        return position;
    }

    @Override
    public boolean hasMine() {
        return hasMine;
    }

    @Override
    public boolean isRevealed() {
        return this.revealed;
    }

    @Override
    public void reveal() {
        this.revealed = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CellImpl) obj;
        return Objects.equals(this.position, that.position) &&
                this.hasMine == that.hasMine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, hasMine);
    }

    @Override
    public String toString() {
        return "CellImpl[" +
                "position=" + position + ", " +
                "hasMine=" + hasMine + ']';
    }

}
