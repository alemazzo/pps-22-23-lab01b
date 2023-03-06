package e1;

import e1.movement.Position;

public class PieceImpl implements Piece {

    private final PieceType type;
    private final Position position;
    public PieceImpl(PieceType type, Position position) {
        this.type = type;
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public PieceType getType() {
        return this.type;
    }
}
