package e1.piece;

import e1.movement.KnightMovementStrategy;
import e1.movement.MovementStrategy;
import e1.movement.Position;

import java.util.Set;

import static e1.piece.PieceType.PAWN;

public class PieceFactoryImpl implements PieceFactory {

    @Override
    public Piece createPawn(Position pawnPosition) {
        return new PieceImpl(PAWN, pawnPosition, new MovementStrategy() {
            @Override
            public Set<Position> getPossibleMoves(Position position, int boardSize) {
                return Set.of();
            }
        });
    }

    @Override
    public Piece createKnight(Position knightPosition) {
        return new PieceImpl(PieceType.KNIGHT, knightPosition, new KnightMovementStrategy());
    }
}
