package week06d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @Test
    void calculateSeriesType() {
        Series s = new Series();
        List<Integer> increasing = List.of(2,34,56,74,80,90);
        List<Integer> decreasing = List.of(90,80,56,34,25,2);
        List<Integer> mixed = List.of(2,80,56,74,62,90);

        assertEquals("A sorozat: növekvő",s.calculateSeriesType(increasing));
        assertEquals("A sorozat: csökkenő",s.calculateSeriesType(decreasing));
        assertEquals("A sorozat: össze-vissza",s.calculateSeriesType(mixed));
    }
}