package e1.piece;

import e1.movement.Position;

public interface PieceFactory {


    Piece createPawn(Position pawnPosition);

    Piece createKnight(Position knightPosition);
}
