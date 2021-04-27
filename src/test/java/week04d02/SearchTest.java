package week04d02;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void getIndexesOfChar() {
        Search s = new Search();

        assertEquals("[0, 3, 5]", s.getIndexesOfChar("almafa", 'a').toString());
        assertEquals("[1, 3, 6]", s.getIndexesOfChar("Levente", 'e').toString());
    }
}