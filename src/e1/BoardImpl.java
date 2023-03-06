package e1;

public class BoardImpl implements Board {

    private final int size;

    public BoardImpl(int size) {
        this.size = size;
    }


    @Override
    public int getSize() {
        return this.size;
    }
}
