package e2.grid;

import e2.Pair;

import java.util.Collections;
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
        final var minesPositions = getRandomPosition(size, minesCount);
        return new GridImpl(size, minesPositions);
    }

    private Set<Pair<Integer, Integer>> getRandomPosition(int size, int count) {
        final Set<Pair<Integer, Integer>> allPosition = IntStream.range(0, size)
                .boxed()
                .flatMap(i -> IntStream.range(0, size)
                        .mapToObj(j -> new Pair<>(i, j)))
                .collect(Collectors.toSet());

        // Return random positions by shuffling and taking the first count
        return allPosition.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.shuffle(list);
                    return list.stream();
                }))
                .limit(count)
                .collect(Collectors.toSet());
    }

    @Override
    public Grid gridWithMinesAt(int size, Set<Pair<Integer, Integer>> minesPositions) {
        return new GridImpl(size, minesPositions);
    }
}
