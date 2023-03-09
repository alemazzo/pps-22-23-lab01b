package e2;

public class CellImpl implements Cell {

    private final boolean hasMine;

    public CellImpl(boolean hasMine) {
        this.hasMine = hasMine;
    }

    @Override
    public boolean hasMine() {
        return this.hasMine;
    }
}
