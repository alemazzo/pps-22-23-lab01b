package e1.board;

import e1.movement.Position;
import e1.piece.Piece;
import e1.piece.PieceFactory;
import e1.piece.PieceFactoryImpl;

import java.util.Set;

public class BoardFactoryImpl implements BoardFactory {

    private final PieceFactory pieceFactory = new PieceFactoryImpl();

    @Override
    public Board createEmptyBoard(int size) {
        return this.createBoardWithPieces(Set.of(), size);
    }

    @Override
    public Board createBoardWithPieces(Set<Piece> pieces, int boardSize) {
        return new BoardImpl(pieces, boardSize);
    }

    @Override
    public Board createRandomBoardWithPawnAndKnight(int boardSize) {
        return this.createBoardWithPieces(Set.of(
                this.pieceFactory.createPawn(Position.random(boardSize)),
                this.pieceFactory.createKnight(Position.random(boardSize))
        ), boardSize);
    }

    @Override
    public Board createBoardWithPawnAndKnightAt(Position pawnPosition, Position knightPosition, int boardSize) {
        return this.createBoardWithPieces(Set.of(
                this.pieceFactory.createPawn(pawnPosition),
                this.pieceFactory.createKnight(knightPosition)
        ), boardSize);
    }
}
