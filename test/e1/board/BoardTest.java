package e1.board;

import e1.movement.MovementResult;
import e1.movement.Position;
import e1.piece.Piece;
import e1.piece.PieceFactory;
import e1.piece.PieceFactoryImpl;
import e1.piece.PieceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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
    void testCanAddPieceToBoard() {
        final var piece = this.pieceFactory.createPawn(new Position(0, 0));
        this.board.addPiece(piece);
        assertEquals(3, this.board.pieces().size());
    }

    @Test
    void testCanRemovePieceFromBoard() {
        final var piece = this.pieceFactory.createPawn(PAWN_POSITION);
        this.board.removePiece(piece);
        assertEquals(1, this.board.pieces().size());
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

    @Test
    void testCanCheckIfBoardHasPieceAtPosition() {
        assertTrue(this.board.hasPieceTypeAt(PAWN_POSITION, PieceType.PAWN));
        assertTrue(this.board.hasPieceTypeAt(KNIGHT_POSITION, PieceType.KNIGHT));
        assertFalse(this.board.hasPieceTypeAt(new Position(0, 0), PieceType.PAWN));
    }

    @Test
    void testCanCheckIfAMovementIsPossible() {
        assertTrue(this.board.isMovementPossible(KNIGHT_POSITION, PAWN_POSITION));
        assertFalse(this.board.isMovementPossible(PAWN_POSITION, KNIGHT_POSITION));
    }

    @Test
    void testCanMoveAPiece() {
        final Position possibleMove = new Position(2, 2);
        assertEquals(MovementResult.SUCCESS, this.board.move(KNIGHT_POSITION, possibleMove));
        assertEquals(2, this.board.pieces().size());
        assertTrue(this.board.hasPieceTypeAt(possibleMove, PieceType.KNIGHT));
    }

    @Test
    void testCanTakeAPieceWithAMove() {
        assertEquals(MovementResult.CAPTURE, this.board.move(KNIGHT_POSITION, PAWN_POSITION));
        assertEquals(1, this.board.pieces().size());
        assertTrue(this.board.hasPieceTypeAt(PAWN_POSITION, PieceType.KNIGHT));
    }

}
