package week08d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {

    @Test
    void stringListsUnion() {
        StringLists sl = new StringLists();
        List<String> first =  new ArrayList<>();
        first.add("alma");
        first.add("barack");
        first.add("banán");
        first.add("szilva");
        List<String> second = new ArrayList<>();
        second.add("alma");
        second.add("mandula");
        second.add("dió");
        second.add("banán");

       assertEquals(6,(sl.stringListsUnion(first, second)).size());
    }

    @Test
    void shortestWords() {
        StringLists sl = new StringLists();
        List<String> first =  List.of("aaa", "aa", "bb", "cccc", "dd");
        System.out.println(sl.shortestWords(first) );
        assertEquals(3, (sl.shortestWords(first)).size());
    }
}