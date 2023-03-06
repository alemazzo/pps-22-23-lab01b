package e1;

import e1.movement.Position;

public interface PieceFactory {


    Piece createPawn(Position pawnPosition);

    Piece createKnight(Position knightPosition);
}
