package e1;

import e1.movement.KnightMovementStrategy;
import e1.movement.Position;

import java.util.*;

public class LogicsImpl implements Logics {

	private final KnightMovementStrategy strategy = new KnightMovementStrategy();
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();	
    }

	public LogicsImpl(int size, Pair<Integer,Integer> pawn, Pair<Integer,Integer> knight){
		this.size = size;
		this.pawn = pawn;
		this.knight = knight;
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {

		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}

		final var moves = this.strategy.getPossibleMoves(
				new Position(this.knight.getX(), this.knight.getY()),
				size
		);

		if (moves.contains(new Position(row, col))) {
			this.knight = new Pair<>(row, col);
			return this.pawn.equals(this.knight);
		}

		return false;

	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
