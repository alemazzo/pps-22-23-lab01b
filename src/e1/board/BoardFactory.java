package e1.board;

import e1.movement.Position;
import e1.piece.Piece;

import java.util.Set;

/**
 * The factory for the board
 */
public interface BoardFactory {

    /**
     * Creates an empty board
     *
     * @param size the size of the board
     * @return the board
     */
    Board createEmptyBoard(int size);

    /**
     * Creates a board with the given pieces
     *
     * @param pieces    the pieces to add to the board
     * @param boardSize the size of the board
     * @return the board
     */
    Board createBoardWithPieces(Set<Piece> pieces, int boardSize);

    /**
     * Creates a random board with a pawn and a knight
     *
     * @param boardSize the size of the board
     * @return the board
     */
    Board createRandomBoardWithPawnAndKnight(int boardSize);

    /**
     * Creates a board with a pawn and a knight at the given positions
     *
     * @param pawnPosition   the position of the pawn
     * @param knightPosition the position of the knight
     * @param boardSize      the size of the board
     * @return the board
     */
    Board createBoardWithPawnAndKnightAt(Position pawnPosition, Position knightPosition, int boardSize);
}
