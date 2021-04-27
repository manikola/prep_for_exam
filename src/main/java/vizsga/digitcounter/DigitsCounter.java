package vizsga.digitcounter;

import java.util.*;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s==null) {
            return 0;
        }
        Set<Character> numbers = new HashSet<>();
        for (char item: s.toCharArray()) {
            if (Character.isDigit(item)) {
                numbers.add(item);
            }
        }
        return numbers.size();
    }

}
//A DigitsCounter osztálynak legyen egy int getCountOfDigits(String s) metódusa, mely megszámolja,
// hogy hány különböző számjegy van a bemeneti Stringben.