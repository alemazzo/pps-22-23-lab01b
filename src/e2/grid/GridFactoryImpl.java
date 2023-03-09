package e2.grid;

import e2.Pair;

import java.util.Random;
import java.util.Set;

public class GridFactoryImpl implements GridFactory {
    @Override
    public Grid emptyGrid(int size) {
        return new GridImpl(size);
    }

    @Override
    public Grid gridWithRandomMines(int size, int minesCount) {
        final var random = new Random();
        final var randomPositions = new Pair<>(
                random.nextInt(size),
                random.nextInt(size)
        );
        return new GridImpl(size, Set.of(randomPositions));
    }
}
