package e1;

import e1.board.Board;
import e1.board.BoardFactory;
import e1.board.BoardFactoryImpl;
import e1.movement.MovementResult;
import e1.movement.Position;
import e1.piece.Piece;
import e1.piece.PieceType;

public class LogicsImpl implements Logics {
    private final BoardFactory factory = new BoardFactoryImpl();
    private Board board;
    private Piece knight;

    public LogicsImpl(int size) {
        this.setBoard(this.factory.createRandomBoardWithPawnAndKnight(size));
    }

    public LogicsImpl(int size, Position pawnPosition, Position knightPosition) {
        this.setBoard(this.factory.createBoardWithPawnAndKnightAt(pawnPosition, knightPosition, size));
    }

    private void setBoard(Board board) {
        this.board = board;
        this.knight = this.board.getPiecesOfType(PieceType.KNIGHT).stream()
                .findFirst()
                .orElseThrow();
    }

    @Override
    public boolean hit(final Position position) {
        if (!position.isValid(this.board.size())) {
            throw new IndexOutOfBoundsException();
        }
        return this.board.move(knight.getPosition(), position) == MovementResult.CAPTURE;
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
