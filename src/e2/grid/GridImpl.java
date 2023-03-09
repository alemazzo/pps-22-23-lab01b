package e2.grid;

public class GridImpl implements Grid {


    private final int size;

    public GridImpl(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
