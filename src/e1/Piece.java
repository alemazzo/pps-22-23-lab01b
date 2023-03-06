package e1;

import e1.movement.Position;

import java.util.Set;

public interface Piece {
    Position getPosition();

    PieceType getType();

    Set<Position> getPossibleMoves(int boardSize);
}
