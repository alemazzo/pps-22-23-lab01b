package e2.grid;

public class GridFactoryImpl implements GridFactory {
    @Override
    public Grid createEmptyGrid(int gridSize) {
        return new GridImpl(gridSize);
    }
}
