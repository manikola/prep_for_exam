package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitSumTest {

    @Test
    void sumOfDigits() {
        assertEquals(6,DigitSum.sumOfDigits(123));
        assertEquals(10,DigitSum.sumOfDigits(1234));
    }
}