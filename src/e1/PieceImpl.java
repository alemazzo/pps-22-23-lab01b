package e1;

import e1.movement.Position;

import java.util.Set;

public class PieceImpl implements Piece {

    private final MovementStrategy movementStrategy;
    private final PieceType type;
    private final Position position;
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
    public PieceType getType() {
        return this.type;
    }

    @Override
    public Set<Position> getPossibleMoves(int boardSize) {
        return this.movementStrategy.getPossibleMoves(this.position, boardSize);
    }
}
