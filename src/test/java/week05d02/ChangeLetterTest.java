package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeLetterTest {

    @Test
    void changeVowels() {

        ChangeLetter cl = new ChangeLetter();

        assertEquals("m*n*k*l*",cl.changeVowels("manikola"));
    }
}