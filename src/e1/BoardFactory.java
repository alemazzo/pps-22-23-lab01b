package e1;

import e1.movement.Position;

import java.util.Set;

public interface BoardFactory {
    Board createEmptyBoard(int size);

    Board createBoardWithPieces(Set<Piece> pieces, int boardSize);

    Board createRandomBoardWithPawnAndKnight(int boardSize);

    Board createBoardWithPawnAndKnightAt(Position pawnPosition, Position knightPosition, int boardSize);
}
