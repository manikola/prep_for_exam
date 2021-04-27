package week06d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiscuitTest {

    @Test
    void testToString() {
        Assertions.assertEquals("GYORI_EDES: 100 g", Biscuit.of(BiscuitType.GYORI_EDES, 100).toString());
    }
    }
