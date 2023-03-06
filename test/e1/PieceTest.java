package e1;

import e1.movement.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    private PieceFactory factory;

    @BeforeEach
    void setup() {
        this.factory = new PieceFactoryImpl();
    }

    @Test
    void testPawn() {
        final var pawnPosition = new Position(0, 0);
        final Piece pawn = this.factory.createPawn(pawnPosition);
        assertNotNull(pawn);
        assertEquals(pawnPosition, pawn.getPosition());
    }

    @Test
    void testPawnAsPawnType() {
        final var pawnPosition = new Position(0, 0);
        final Piece pawn = this.factory.createPawn(pawnPosition);
        assertEquals(PieceType.PAWN, pawn.getType());
    }

    @Test
    void testKnight() {
        final var knightPosition = new Position(0, 0);
        final Piece knight = this.factory.createKnight(knightPosition);
        assertNotNull(knight);
        assertEquals(knightPosition, knight.getPosition());
        assertEquals(PieceType.KNIGHT, knight.getType());
    }

    @Test
    void testPieceHasMovementStrategyInside() {
        final var knightPosition = new Position(0, 0);
        final var boardSize = 8;
        final Piece knight = this.factory.createKnight(knightPosition);
        final var moves = knight.getPossibleMoves(boardSize);
        assertEquals(2, moves.size());
        assertTrue(moves.contains(new Position(2, 1)));
        assertTrue(moves.contains(new Position(1, 2)));
    }
}
