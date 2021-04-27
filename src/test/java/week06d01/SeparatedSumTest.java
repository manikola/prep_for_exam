package week06d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    @Test
    void sum() {
        SeparatedSum ss = new SeparatedSum();

        assertEquals("Pozitív összeg: 34.36, Negatív összeg: -49.49",ss.sum("-14,15;-15,16;16,17;-20,18;18,19"));
    }
}