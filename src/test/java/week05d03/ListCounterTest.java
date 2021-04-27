package week05d03;

import org.junit.jupiter.api.Test;
import vaccination.Citizen;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListCounterTest {

    @Test
    void countAElements() {
        ListCounter lc = new ListCounter();
        List<String> words = List.of("Alma", "ananász", "Béla", "Atilla", "Levi");


        assertEquals(3, lc.countAElements(words));
    }

    @Test
    public void emptyListShouldThrowException() throws IllegalArgumentException {
        ListCounter lc = new ListCounter();
        List<String> words2 = new ArrayList<>();

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
             lc.countAElements(words2));
        assertEquals("List is empty", ex.getMessage());
    }

    @Test
    public void notFoundShouldThrowException() throws IllegalArgumentException {
        ListCounter lc = new ListCounter();
        List<String> words3 = List.of("Ozzie", "Béla", "Mama", "Levi");

        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                lc.countAElements(words3));
        assertEquals("Not found any", ex.getMessage());
    }
}