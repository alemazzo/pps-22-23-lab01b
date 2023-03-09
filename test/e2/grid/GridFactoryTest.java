package e2.grid;

import org.junit.jupiter.api.BeforeEach;

public class GridFactoryTest {

    private GridFactory factory;

    @BeforeEach
    void setup() {
        this.factory = new GridFactoryImpl();
    }


}
