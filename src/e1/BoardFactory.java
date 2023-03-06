package e1;

import java.util.Set;

public interface BoardFactory {
    Board createEmptyBoard(int size);

    Board createBoardWithPieces(Set<Piece> pieces, int boardSize);

    Board createRandomBoardWithPawnAndKnight(int boardSize);
}
