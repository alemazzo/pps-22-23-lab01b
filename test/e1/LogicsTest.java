package e1;

import org.junit.jupiter.api.BeforeEach;

public class LogicsTest {

    public static final int SIZE = 8;

    private Logics logics;

    @BeforeEach
    void setup() {
        this.logics = new LogicsImpl(SIZE);
    }

}
