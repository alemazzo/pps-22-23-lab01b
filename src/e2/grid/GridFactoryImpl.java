package e2.grid;

public class GridFactoryImpl implements GridFactory {
    @Override
    public Grid emptyGrid(int size) {
        return new GridImpl(size);
    }
}
