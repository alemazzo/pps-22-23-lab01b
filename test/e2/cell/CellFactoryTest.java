package e2.cell;

import org.junit.jupiter.api.BeforeEach;

public class CellFactoryTest {

    private CellFactory factory;

    @BeforeEach
    public void setup() {
        factory = new CellFactoryImpl();
    }
    
}
