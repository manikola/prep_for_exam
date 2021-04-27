package week03d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void getResult() {
        Operation op = new Operation(12, 68);

        assertEquals(80,op.getResult());
    }
}