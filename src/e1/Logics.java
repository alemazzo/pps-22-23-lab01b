package e1;

import e1.movement.Position;

public interface Logics {

    /**
     * attempt to move Knight on position row,col, if possible
     *
     * @param row
     * @param col
     * @return whether the pawn has been hit
     */
    boolean hit(Position position);

    /**
     * @param row
     * @param col
     * @return whether position row,col has the knight
     */
    boolean hasKnight(Position position);

    /**
     * @param row
     * @param col
     * @return whether position row,col has the pawn
     */
    boolean hasPawn(Position position);
}
