package e1.movement;

import java.util.Set;
import java.util.stream.Collectors;

public class KnightMovementStrategy implements MovementStrategy {

    @Override
    public Set<Position> getPossibleMoves(Position position, int size) {
        int x = position.getX();
        int y = position.getY();

        return Set.of(
                        new Position(x + 2, y + 1),
                        new Position(x + 2, y - 1),
                        new Position(x - 2, y + 1),
                        new Position(x - 2, y - 1),
                        new Position(x + 1, y + 2),
                        new Position(x + 1, y - 2),
                        new Position(x - 1, y + 2),
                        new Position(x - 1, y - 2)
                ).stream()
                .filter(p -> p.getX() >= 0 && p.getY() >= 0)
                .filter(p -> p.getX() < size && p.getY() < size)
                .collect(Collectors.toSet());

    }
}
