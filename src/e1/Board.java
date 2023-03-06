package e1;

import e1.movement.Position;

import java.util.Optional;
import java.util.Set;

public interface Board {
    int size();

    Set<Piece> pieces();

    Optional<Piece> getPieceAt(Position position);
}
