package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {

    public static final int SIZE = 8;

    private Logics logics;

    @BeforeEach
    void setup() {
        this.logics = new LogicsImpl(SIZE);
    }

    private Pair<Integer, Integer> getPawnPosition() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (logics.hasPawn(i, j)) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    private Pair<Integer, Integer> getKnightPosition() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (logics.hasKnight(i, j)) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    @Test
    void testPawnIsPresent() {
        assertNotNull(this.getPawnPosition());
    }

    @Test
    void testKnightIsPresent() {
        assertNotNull(this.getKnightPosition());
    }

}
