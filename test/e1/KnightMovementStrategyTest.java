package e1;

import e1.Pair;
import e1.movement.KnightMovementStrategy;
import e1.movement.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightMovementStrategyTest {

    public static final int SIZE = 8;

    private KnightMovementStrategy strategy;


    @BeforeEach
    void setup() {
        this.strategy = new KnightMovementStrategy();
    }

    @Test
    void testGetPossibleMoves() {
        final var position = new Position(0, 0);
        final var moves = this.strategy.getPossibleMoves(position, SIZE);
        assertEquals(2, moves.size());
        assertTrue(moves.contains(new Position(2, 1)));
        assertTrue(moves.contains(new Position(1, 2)));
    }

    @Test
    void testNoPossibleMoves() {
        final var position = new Position(0, 0);
        final var boardSize = 2;
        final var moves = this.strategy.getPossibleMoves(position, boardSize);
        assertEquals(0, moves.size());
    }

}
