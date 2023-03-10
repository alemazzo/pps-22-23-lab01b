package e2;

public interface Logics {

    RevealResult reveal(Position position);

    void toggleFlag(Position position);

    CellStatus getCellStatus(Position position);
}
