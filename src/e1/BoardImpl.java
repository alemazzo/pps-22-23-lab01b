package e1;

import e1.movement.Position;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

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

}