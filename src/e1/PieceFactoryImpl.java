package e1;

import e1.movement.Position;

import static e1.PieceType.PAWN;

public class PieceFactoryImpl implements PieceFactory {

    @Override
    public Piece createPawn(Position pawnPosition) {
        return new PieceImpl(PAWN, pawnPosition);
    }
}
