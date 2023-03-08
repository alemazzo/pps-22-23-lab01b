package e1.piece;

import e1.movement.Position;

import java.util.Set;

/**
 * The piece
 */
public interface Piece {

    /**
     * @return the position of the piece
     */
    Position getPosition();

    /**
     * Sets the position of the piece
     *
     * @param position the position
     */
    void setPosition(Position position);

    /**
     * @return the type of the piece
     */
    PieceType getType();

    /**
     * @return the set of possible moves for the piece
     */
    Set<Position> getPossibleMoves(int boardSize);
}
