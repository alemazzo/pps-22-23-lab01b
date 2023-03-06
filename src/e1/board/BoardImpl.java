package e1.board;

import e1.movement.Position;
import e1.piece.Piece;
import e1.piece.PieceType;

import java.util.*;
import java.util.stream.Collectors;

public final class BoardImpl implements Board {

    private final Set<Piece> pieces;
    private final int size;

    public BoardImpl(Set<Piece> pieces, int size) {
        this.pieces = new HashSet<>(pieces);
        this.size = size;
    }

    @Override
    public Set<Piece> pieces() {
        return Collections.unmodifiableSet(this.pieces);
    }

    @Override
    public Optional<Piece> getPieceAt(Position position) {
        return this.pieces.stream()
                .filter(piece -> piece.getPosition().equals(position))
                .findFirst();
    }

    @Override
    public Set<Piece> getPiecesOfType(PieceType type) {
        return this.pieces.stream()
                .filter(piece -> piece.getType() == type)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean hasPieceTypeAt(Position position, PieceType pawn) {
        return this.getPieceAt(position)
                .map(piece -> piece.getType() == pawn)
                .orElse(false);
    }

    @Override
    public boolean addPiece(Piece piece) {
        return this.pieces.add(piece);
    }

    @Override
    public boolean removePiece(Piece piece) {
        return this.pieces.remove(piece);
    }

    @Override
    public boolean isMovementPossible(Position start, Position end) {
        return this.getPieceAt(start)
                .map(piece -> piece.getPossibleMoves(this.size).contains(end))
                .orElse(false);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BoardImpl) obj;
        return Objects.equals(this.pieces, that.pieces) &&
                this.size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieces, size);
    }

    @Override
    public String toString() {
        return "BoardImpl[" +
                "pieces=" + pieces + ", " +
                "size=" + size + ']';
    }


}
