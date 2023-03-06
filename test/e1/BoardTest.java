package e1;

import e1.movement.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    public static final Position KNIGHT_POSITION = new Position(0, 1);
    public static final Position PAWN_POSITION = new Position(2, 0);
    public static final int SIZE = 8;
    private final PieceFactory pieceFactory = new PieceFactoryImpl();
    private Board board;

    @BeforeEach
    void setup() {
        final var pieces = Set.of(
                this.pieceFactory.createPawn(PAWN_POSITION),
                this.pieceFactory.createKnight(KNIGHT_POSITION)
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
        final var piece = this.board.getPieceAt(PAWN_POSITION);
        assertTrue(piece.isPresent());
        assertEquals(PAWN_POSITION, piece.get().getPosition());
    }

    @Test
    void testCannotRetrievePieceAtPosition() {
        final var position = new Position(0, 0);
        final var piece = this.board.getPieceAt(position);
        assertTrue(piece.isEmpty());
    }

    @Test
    void testCanRetrieveAllPiecesOfType() {
        final Set<Piece> pieces = this.board.getPiecesOfType(PieceType.PAWN);
        assertEquals(1, pieces.size());

        final var pawn = pieces.stream().toList().get(0);
        assertEquals(PieceType.PAWN, pawn.getType());
        assertEquals(PAWN_POSITION, pawn.getPosition());

        final Set<Piece> pieces2 = this.board.getPiecesOfType(PieceType.KNIGHT);
        assertEquals(1, pieces2.size());

        final var knight = pieces2.stream().toList().get(0);
        assertEquals(PieceType.KNIGHT, knight.getType());
        assertEquals(KNIGHT_POSITION, knight.getPosition());
    }
}
