package e1.movement;

import e1.Pair;

public class Position extends Pair<Integer, Integer> {
    public Position(int x, int y) {
        super(x, y);
    }

    public static Position random(int boardSize) {
        return new Position((int) (Math.random() * boardSize), (int) (Math.random() * boardSize));
    }

    public boolean isValid(int size) {
        return getX() >= 0 && getX() < size && getY() >= 0 && getY() < size;
    }
}
