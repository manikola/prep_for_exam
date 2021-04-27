package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @Test
    void fill() {
        Bottle b = new Bottle(BottleType.GLASS_BOTTLE, 1);

        assertEquals(1, b.getFilledUntil());
        assertEquals(2, b.fill(1).getFilledUntil());

    }
}