package e1;

import e1.movement.Position;

import java.util.Objects;
import java.util.Set;

public class PieceImpl implements Piece {

    private final MovementStrategy movementStrategy;
    private final PieceType type;
    private Position position;

    public PieceImpl(PieceType type, Position position, MovementStrategy movementStrategy) {
        this.type = type;
        this.position = position;
        this.movementStrategy = movementStrategy;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public PieceType getType() {
        return this.type;
    }

    @Override
    public Set<Position> getPossibleMoves(int boardSize) {
        return this.movementStrategy.getPossibleMoves(this.position, boardSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PieceImpl piece = (PieceImpl) o;
        return type == piece.type && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, position);
    }
}
