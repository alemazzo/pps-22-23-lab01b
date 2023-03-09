package e2.grid.factory;

import e2.Pair;
import e2.grid.Grid;
import e2.grid.GridImpl;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridFactoryImpl implements GridFactory {
    @Override
    public Grid emptyGrid(int size) {
        return this.gridWithMinesAt(size, Collections.emptySet());
    }

    @Override
    public Grid gridWithRandomMines(int size, int minesCount) {
        return this.gridWithMinesAt(size, this.getRandomPosition(size, minesCount));
    }

    @Override
    public Grid gridWithMinesAt(int size, Set<Pair<Integer, Integer>> minesPositions) {
        return new GridImpl(size, minesPositions);
    }

    /**
     * Get a set of random positions.
     * Those positions are in the range [0, size) x [0, size) and are unique.
     *
     * @param size  the size of the grid.
     * @param count the number of positions to return.
     * @return the set of random positions.
     */
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

}
