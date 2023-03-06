package e1.board;

import e1.movement.Position;
import e1.piece.Piece;
import e1.piece.PieceType;

import java.util.Optional;
import java.util.Set;

public interface Board {
    
    int size();

    Set<Piece> pieces();

    Optional<Piece> getPieceAt(Position position);

    Set<Piece> getPiecesOfType(PieceType pawn);

    boolean hasPieceTypeAt(Position pawnPosition, PieceType pawn);

    boolean addPiece(Piece piece);

    boolean removePiece(Piece piece);

    boolean isMovementPossible(Position start, Position end);
}
