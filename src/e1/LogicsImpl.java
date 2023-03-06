package e1;

import e1.board.Board;
import e1.board.BoardFactory;
import e1.board.BoardFactoryImpl;
import e1.movement.Position;
import e1.piece.PieceType;

public class LogicsImpl implements Logics {
    private final BoardFactory factory = new BoardFactoryImpl();
    private final Board board;

    public LogicsImpl(int size) {
        this.board = this.factory.createRandomBoardWithPawnAndKnight(size);
    }

    public LogicsImpl(int size, Position pawnPosition, Position knightPosition) {
        this.board = this.factory.createBoardWithPawnAndKnightAt(pawnPosition, knightPosition, size);
    }

    @Override
    public boolean hit(final Position position) {
        if (!position.isValid(this.board.size())) {
            throw new IndexOutOfBoundsException();
        }
        final var knight = this.board.getPiecesOfType(PieceType.KNIGHT).stream()
                .findFirst()
                .orElseThrow();
        return this.board.move(knight.getPosition(), position);
    }

    @Override
    public boolean hasKnight(final Position position) {
        return this.board.hasPieceTypeAt(position, PieceType.KNIGHT);
    }

    @Override
    public boolean hasPawn(final Position position) {
        return this.board.hasPieceTypeAt(position, PieceType.PAWN);
    }

}
