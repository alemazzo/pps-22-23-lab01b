package e1;

import org.junit.jupiter.api.BeforeEach;

public class BoardFactoryTest {

    private BoardFactory boardFactory;
    @BeforeEach
    void setup() {
        this.boardFactory = new BoardFactoryImpl();
    }
}
