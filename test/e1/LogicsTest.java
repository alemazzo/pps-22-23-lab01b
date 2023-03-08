package e1;

import e1.movement.Position;
import e1.piece.PieceType;
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

    private Position getPiecePosition(PieceType type) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (type == PieceType.PAWN && logics.hasPawn(new Position(i, j))) {
                    return new Position(i, j);
                } else if (type == PieceType.KNIGHT && logics.hasKnight(new Position(i, j))) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    @Test
    void testPawnIsPresent() {
        assertNotNull(this.getPiecePosition(PieceType.PAWN));
    }

    @Test
    void testKnightIsPresent() {
        assertNotNull(this.getPiecePosition(PieceType.KNIGHT));
    }

    @Test
    void testPawnAndKnightAreOnDifferentPosition() {
        assertNotEquals(this.getPiecePosition(PieceType.PAWN), this.getPiecePosition(PieceType.KNIGHT));
    }

    @Test
    void testKnightCanMove() {
        final var pawnPosition = new Position(2, 1);
        final var knightPosition = new Position(0, 0);
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
