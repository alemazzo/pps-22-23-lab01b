package e2.grid;

import e2.Position;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GridFactoryImpl implements GridFactory {

    @Override
    public Grid createEmptyGrid(int gridSize) {
        return this.createGridWithSpecifiedMines(gridSize, Set.of());
    }

    @Override
    public Grid createGridWithRandomMines(int gridSize, int minesCount) {
        return this.createGridWithSpecifiedMines(gridSize, getRandomPositions(gridSize, minesCount));
    }

    @Override
    public Grid createGridWithSpecifiedMines(int gridSize, Set<Position> minesPositions) {
        return new GridImpl(gridSize, minesPositions);
    }

    private Set<Position> getRandomPositions(int gridSize, int minesCount) {
        final List<Position> allPositions = IntStream.range(0, gridSize)
                .mapToObj(x -> IntStream.range(0, gridSize)
                        .mapToObj(y -> new Position(x, y)))
                .flatMap(x -> x)
                .collect(Collectors.toList());

        Collections.shuffle(allPositions);

        return allPositions.stream()
                .limit(minesCount)
                .collect(Collectors.toSet());
    }

}
