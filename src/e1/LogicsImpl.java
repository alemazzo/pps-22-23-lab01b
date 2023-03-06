package e1;

import e1.movement.Position;

import java.util.Random;

public class LogicsImpl implements Logics {

    private final PieceFactory pieceFactory = new PieceFactoryImpl();
    private final Piece pawn;
    private final Random random = new Random();
    private final int size;
    private Piece knight;

    public LogicsImpl(int size) {
        this.size = size;
        this.pawn = this.pieceFactory.createPawn(this.randomEmptyPosition());
        this.knight = this.pieceFactory.createKnight(this.randomEmptyPosition());
    }

    public LogicsImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight) {
        this.size = size;
        this.pawn = this.pieceFactory.createPawn(new Position(pawn.getX(), pawn.getY()));
        this.knight = this.pieceFactory.createKnight(new Position(knight.getX(), knight.getY()));
    }

    private Position randomEmptyPosition() {
        final var randomPosition = new Position(this.random.nextInt(size), this.random.nextInt(size));
        return this.pawn != null &&
                this.pawn.getPosition().equals(randomPosition) ?
                randomEmptyPosition() : randomPosition;
    }

    @Override
    public boolean hit(int row, int col) {

        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        final var moves = this.knight.getPossibleMoves(this.size);

        if (moves.contains(new Position(row, col))) {
            this.knight = this.pieceFactory.createKnight(new Position(row, col));
            return this.pawn.getPosition().equals(this.knight.getPosition());
        }

        return false;

    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.getPosition().equals(new Position(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.getPosition().equals(new Position(row, col));
    }
}
