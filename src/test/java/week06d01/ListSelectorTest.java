package week06d01;

import org.junit.jupiter.api.Test;
import week05d03.ListCounter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListSelectorTest {

    @Test
    void selectEvens() {
        ListSelector ls = new ListSelector();
        List<String> text = List.of("alma","banán","narancs","mandarin","kókusz", "eper");

        assertEquals("[alma narancs kókusz]", ls.selectEvens(text).toString());
    }



}