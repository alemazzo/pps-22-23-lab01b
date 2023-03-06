package e1.movement;

import java.util.Set;

public interface MovementStrategy {
    Set<Position> getPossibleMoves(Position position, int boardSize);
}
