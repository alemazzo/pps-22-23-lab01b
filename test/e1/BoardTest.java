package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    public static final int SIZE = 8;
    private Board board;

    @BeforeEach
    void setup() {
        this.board = new BoardImpl(SIZE);
    }

    @Test
    void testBoardHasSize() {
        assertEquals(SIZE, this.board.getSize());
    }

}
