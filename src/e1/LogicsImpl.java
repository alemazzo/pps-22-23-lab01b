package e1;

import e1.movement.Position;

public class LogicsImpl implements Logics {
    private final BoardFactory factory = new BoardFactoryImpl();
    private final Board board;
    private final Piece knight;

    public LogicsImpl(int size) {
        this.board = this.factory.createRandomBoardWithPawnAndKnight(size);
        this.knight = this.board.pieces().stream()
                .filter(piece -> piece.getType() == PieceType.KNIGHT)
                .findFirst()
                .orElseThrow();
    }

    public LogicsImpl(int size, Position pawnPosition, Position knightPosition) {
        this.board = this.factory.createBoardWithPawnAndKnightAt(
                pawnPosition,
                knightPosition,
                size
        );
        this.knight = this.board.pieces().stream()
                .filter(piece -> piece.getType() == PieceType.KNIGHT)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public boolean hit(final Position position) {

        if (!position.isValid(this.board.size())) {
            throw new IndexOutOfBoundsException();
        }

        final var moves = this.knight.getPossibleMoves(this.board.size());

        if (moves.contains(position)) {
            final boolean captured = this.board.getPieceAt(position).isPresent();
            this.knight.setPosition(position);
            return captured;
        }

        return false;

    }

    @Override
    public boolean hasKnight(final Position position) {
        return this.knight.getPosition().equals(position);
    }

    @Override
    public boolean hasPawn(final Position position) {
        return this.board.getPieceAt(position).isPresent() &&
                this.board.getPieceAt(position).get().getType() == PieceType.PAWN;
    }
}
