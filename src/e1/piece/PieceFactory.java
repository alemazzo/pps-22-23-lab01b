package e1.piece;

import e1.movement.Position;

/**
 * The piece factory
 */
public interface PieceFactory {

    /**
     * Creates a pawn at the given position
     *
     * @param pawnPosition the position of the pawn
     * @return the pawn
     */
    Piece createPawn(Position pawnPosition);

    /**
     * Creates a knight at the given position
     *
     * @param knightPosition the position of the knight
     * @return the knight
     */
    Piece createKnight(Position knightPosition);
}
