package e1;

import e1.board.Board;
import e1.board.BoardFactory;
import e1.board.BoardFactoryImpl;
import e1.movement.Position;
import e1.piece.Piece;
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
        final Piece knight = this.board.getPiecesOfType(PieceType.KNIGHT).iterator().next();
        final var moves = knight.getPossibleMoves(this.board.size());

        if (moves.contains(position)) {
            final boolean captured = this.board.getPieceAt(position).isPresent();
            if (captured) {
                this.board.removePiece(this.board.getPieceAt(position).get());
            }
            knight.setPosition(position);
            return captured;
        }
        return false;
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
