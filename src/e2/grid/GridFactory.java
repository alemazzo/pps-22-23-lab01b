package e2.grid;

public interface GridFactory {
    Grid emptyGrid(int size);

    Grid gridWithRandomMines(int size, int minesCount);
}
