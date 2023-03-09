package e2.grid;

import e2.Pair;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridFactoryImpl implements GridFactory {
    @Override
    public Grid emptyGrid(int size) {
        return new GridImpl(size);
    }

    @Override
    public Grid gridWithRandomMines(int size, int minesCount) {
        final var random = new Random();
        final var randomPositions = IntStream.range(0, minesCount)
                .mapToObj(i -> new Pair<>(random.nextInt(size), random.nextInt(size)))
                .collect(Collectors.toSet());
        return this.gridWithMinesAt(size, randomPositions);
    }

    @Override
    public Grid gridWithMinesAt(int size, Set<Pair<Integer, Integer>> minesPositions) {
        return new GridImpl(size, minesPositions);
    }
}
