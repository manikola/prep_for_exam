package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordEraserTest {

    @Test
    void eraseWord() {
        WordEraser we = new WordEraser();

        assertEquals("alma banán mandula és még egyszer ",we.eraseWord("alma banán mandula dió és még egyszer dió", "dió"));
    }
}