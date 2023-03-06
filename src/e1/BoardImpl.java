package e1;

import e1.movement.Position;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public record BoardImpl(Set<Piece> pieces, int size) implements Board {

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

}
