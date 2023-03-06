package e1;

import e1.movement.Position;

public interface Piece {
    Position getPosition();

    PieceType getType();
}
