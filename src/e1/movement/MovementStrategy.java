package e1.movement;

import java.util.Set;

/**
 * The movement strategy for a piece
 */
public interface MovementStrategy {

    /**
     * Returns the set of possible moves for the given position
     *
     * @param position  the position
     * @param boardSize the size of the board
     * @return the set of possible moves
     */
    Set<Position> getPossibleMoves(Position position, int boardSize);

}
