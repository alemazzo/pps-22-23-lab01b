package e1.piece;

import e1.movement.Position;

import java.util.Set;

public interface Piece {
    Position getPosition();

    void setPosition(Position position);

    PieceType getType();

    Set<Position> getPossibleMoves(int boardSize);
}
