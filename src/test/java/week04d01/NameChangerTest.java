package week04d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameChangerTest {

    @Test
    void changeFirstName() {
        NameChanger nc = new NameChanger("Attila Bicer");

        assertEquals("Atilla Bicer", nc.changeFirstName("Atilla"));
    }
}