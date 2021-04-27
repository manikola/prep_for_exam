package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    @Test
    void isPrime() {

        assertTrue(MathAlgorithms.isPrime(7));
        assertTrue(MathAlgorithms.isPrime(13));
        assertTrue(MathAlgorithms.isPrime(3));
        assertFalse(MathAlgorithms.isPrime(9));
        assertFalse(MathAlgorithms.isPrime(21));
        assertFalse(MathAlgorithms.isPrime(15));
    }
}