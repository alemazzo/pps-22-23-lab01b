package e1;

import e1.movement.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(SIZE, this.board.getSize());
    }

    @Test
    void testBoardHasPieces() {
        assertEquals(2, this.board.getPieces().size());
    }

}
