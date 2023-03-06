package e1;

import e1.movement.Position;

import java.util.Set;

public interface MovementStrategy {
    Set<Position> getPossibleMoves(Position position, int boardSize);
}
