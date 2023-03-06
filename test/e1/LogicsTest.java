package e1;

import e1.movement.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {

    public static final int SIZE = 8;

    private Logics logics;

    @BeforeEach
    void setup() {
        this.logics = new LogicsImpl(SIZE);
    }

    private Pair<Integer, Integer> getPawnPosition() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (logics.hasPawn(new Position(i, j))) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    private Pair<Integer, Integer> getKnightPosition() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (logics.hasKnight(new Position(i, j))) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    @Test
    void testPawnIsPresent() {
        assertNotNull(this.getPawnPosition());
    }

    @Test
    void testKnightIsPresent() {
        assertNotNull(this.getKnightPosition());
    }

    @Test
    void testPawnAndKnightAreOnDifferentPosition() {
        assertNotEquals(this.getPawnPosition(), this.getKnightPosition());
    }

    @Test
    void testKnightCanMove() {
        final var knightPosition = new Position(0, 0);
        final var pawnPosition = new Position(2, 1);
        this.logics = new LogicsImpl(SIZE, pawnPosition, knightPosition);
        assertTrue(this.logics.hasKnight(knightPosition));
        assertFalse(this.logics.hit(new Position(1, 2)));
        assertTrue(this.logics.hasKnight(new Position(1, 2)));
    }

    @Test
    void testKnightCanHitPawn() {
        final var knightPosition = new Position(0, 0);
        final var pawnPosition = new Position(1, 2);
        this.logics = new LogicsImpl(SIZE, pawnPosition, knightPosition);
        assertTrue(this.logics.hit(pawnPosition));
        assertTrue(this.logics.hasKnight(pawnPosition));
    }
}
