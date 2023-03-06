package e1;

import e1.movement.Position;

import java.util.Set;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {
    private final PieceFactory pieceFactory = new PieceFactoryImpl();
    private final Board board;
    private final Piece knight;

    public LogicsImpl(int size) {
        final var pawnPosition = Position.random(size);
        final var knightPosition = Stream.generate(() -> Position.random(size))
                .filter(position -> !position.equals(pawnPosition))
                .findFirst()
                .orElseThrow();
        this.knight = this.pieceFactory.createKnight(knightPosition);
        this.board = new BoardImpl(Set.of(
                this.pieceFactory.createPawn(pawnPosition),
                this.knight
        ), size);
    }

    public LogicsImpl(int size, Position pawnPosition, Position knightPosition) {
        final var pawn = this.pieceFactory.createPawn(pawnPosition);
        this.knight = this.pieceFactory.createKnight(knightPosition);
        this.board = new BoardImpl(Set.of(pawn, this.knight), size);
    }

    @Override
    public boolean hit(final Position position) {

        if (!position.isValid(this.board.size())) {
            throw new IndexOutOfBoundsException();
        }

        final var moves = this.knight.getPossibleMoves(this.board.size());
        System.out.println(moves);

        if (moves.contains(position)) {
            System.out.println("Knight moved to " + position);
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
