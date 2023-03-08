package e1.movement;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightMovementStrategyTest {

    public static final int SIZE = 8;

    private final MovementStrategy strategy = new KnightMovementStrategy();


    @Test
    void testGetPossibleMoves() {
        final var position = new Position(0, 0);
        final var moves = this.strategy.getPossibleMoves(position, SIZE);
        final var expectedMoves = Set.of(
                new Position(2, 1),
                new Position(1, 2)
        );
        assertEquals(2, moves.size());
        assertTrue(moves.containsAll(expectedMoves));
    }

    @Test
    void testNoPossibleMoves() {
        final var position = new Position(0, 0);
        final var boardSize = 2;
        final var moves = this.strategy.getPossibleMoves(position, boardSize);
        assertEquals(0, moves.size());
    }

}
