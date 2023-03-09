package e2.grid;

public interface GridFactory {
    Grid createEmptyGrid(int gridSize);

    Grid createGridWithRandomMines(int gridSize, int minesCount);
}
