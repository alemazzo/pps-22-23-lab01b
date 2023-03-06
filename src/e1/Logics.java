package e1;

import e1.movement.Position;

public interface Logics {

    /**
     * Try to move the knight to the specified position
     *
     * @param position the position to move the knight to
     * @return true if the knight captured the pawn, false otherwise
     */
    boolean hit(Position position);

    /**
     * Check if the knight is on the board at specified position
     *
     * @param position the position to check
     * @return true if the knight is on the board at specified position
     */
    boolean hasKnight(Position position);

    /**
     * Check if the pawn is on the board at specified position
     *
     * @param position the position to check
     * @return true if the pawn is on the board at specified position
     */
    boolean hasPawn(Position position);
}
