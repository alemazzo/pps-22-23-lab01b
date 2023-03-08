package e1.board;

import e1.movement.Position;
import e1.piece.Piece;
import e1.piece.PieceType;

import java.util.Optional;
import java.util.Set;

public interface Board {

    /**
     * @return the size of the board
     */
    int size();

    /**
     * @return the Set of pieces on the board
     */
    Set<Piece> pieces();

    /**
     * Returns the piece at the given position if present, otherwise an empty Optional
     *
     * @param position the position of the piece
     * @return the piece
     */
    Optional<Piece> getPieceAt(Position position);

    /**
     * Returns the set of pieces of the given type
     *
     * @param type the type of the piece
     * @return the set of pieces
     */
    Set<Piece> getPiecesOfType(PieceType type);

    /**
     * Returns true if there is a piece of the given type at the given position
     *
     * @param position the position of the piece
     * @param pawn     the type of the piece
     * @return true if there is a piece of the given type at the given position
     */
    boolean hasPieceTypeAt(Position position, PieceType pawn);

    /**
     * Adds a piece to the board
     *
     * @param piece the piece to add
     * @return true if the piece was added, false otherwise
     */
    boolean addPiece(Piece piece);

    /**
     * Removes a piece from the board
     *
     * @param piece the piece to remove
     * @return true if the piece was removed, false otherwise
     */
    boolean removePiece(Piece piece);

    /**
     * Returns true if the movement from start to end is possible
     *
     * @param start the starting position
     * @param end   the ending position
     * @return true if the movement from start to end is possible
     */
    boolean isMovementPossible(Position start, Position end);

    /**
     * Moves the piece at start to end
     *
     * @param start the starting position
     * @param end   the ending position
     * @return the result of the movement
     */
    MovementResult move(Position start, Position end);

}
