package week07d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {

    @Test
    void complete() {
        Lab lab = new Lab("matek");

        lab.complete();
        assertEquals(LocalDate.now(),lab.getCompletedAt());
    }

    @Test
    void testComplete() {
        Lab lab = new Lab("matek");
        lab.complete(LocalDate.of(2021, 02, 15));
        assertEquals(LocalDate.of(2021, 02, 15),lab.getCompletedAt());

    }
}