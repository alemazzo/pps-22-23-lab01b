package e1;

import e1.movement.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardFactoryTest {

    private BoardFactory boardFactory;

    @BeforeEach
    void setup() {
        this.boardFactory = new BoardFactoryImpl();
    }

    @Test
    void testCanCreateAnEmptyBoard() {
        final int boardSize = 8;
        final var board = this.boardFactory.createEmptyBoard(boardSize);
        assertEquals(boardSize, board.size());
    }

    @Test
    void testCanCreateABoardWithPieces() {
        final int boardSize = 8;
        final PieceFactory pieceFactory = new PieceFactoryImpl();
        final Set<Piece> pieces = Set.of(
                pieceFactory.createPawn(new Position(2, 0)),
                pieceFactory.createKnight(new Position(0, 1))
        );
        final var board = this.boardFactory.createBoardWithPieces(pieces, boardSize);
        assertEquals(boardSize, board.size());
        assertEquals(2, board.pieces().size());
    }

    @Test
    void testCanCreateRandomBoardWithPawnAndKnight() {
        final int boardSize = 8;
        final var board = this.boardFactory.createRandomBoardWithPawnAndKnight(boardSize);
        assertEquals(boardSize, board.size());
        assertEquals(2, board.pieces().size());

        final var pawnCount = board.pieces().stream()
                .filter(p -> p.getType() == PieceType.PAWN)
                .count();

        final var knightCount = board.pieces().stream()
                .filter(p -> p.getType() == PieceType.KNIGHT)
                .count();

        assertEquals(1, pawnCount);
        assertEquals(1, knightCount);
    }
}
