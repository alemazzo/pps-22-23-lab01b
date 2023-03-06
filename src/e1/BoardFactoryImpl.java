package e1;

import java.util.Set;

public class BoardFactoryImpl implements BoardFactory {

    @Override
    public Board createEmptyBoard(int size) {
        return this.createBoardWithPieces(Set.of(), size);
    }

    @Override
    public Board createBoardWithPieces(Set<Piece> pieces, int boardSize) {
        return new BoardImpl(pieces, boardSize);
    }
}
