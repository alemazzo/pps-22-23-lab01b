package e1;

import e1.movement.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    public static final int SIZE = 8;
    private final PieceFactory pieceFactory = new PieceFactoryImpl();
    private Board board;

    @BeforeEach
    void setup() {
        final var pieces = Set.of(
                this.pieceFactory.createPawn(new Position(2, 0)),
                this.pieceFactory.createKnight(new Position(0, 1))
        );
        this.board = new BoardImpl(pieces, SIZE);
    }

    @Test
    void testBoardHasSize() {
        assertEquals(SIZE, this.board.size());
    }

    @Test
    void testBoardHasPieces() {
        assertEquals(2, this.board.pieces().size());
    }

    @Test
    void testCanRetrievePieceAtPosition() {
        final var position = new Position(2, 0);
        final var piece = this.board.getPieceAt(position);
        assertTrue(piece.isPresent());
        assertEquals(position, piece.get().getPosition());
    }

    @Test
    void testCannotRetrievePieceAtPosition() {
        final var position = new Position(0, 0);
        final var piece = this.board.getPieceAt(position);
        assertTrue(piece.isEmpty());
    }

    
}
