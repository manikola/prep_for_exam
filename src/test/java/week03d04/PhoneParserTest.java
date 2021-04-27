package week03d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneParserTest {

    @Test
    void parse() {
        PhoneParser pp = new PhoneParser();
        Phone p = pp.parse("70-6256911");

        assertEquals("70", p.getPrefix());
        assertEquals("6256911", p.getNumber());
    }
}