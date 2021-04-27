package week06d03;

import java.util.List;

public class Series {

    public String calculateSeriesType(List<Integer> numbers) {
        String type = null;
        boolean incresing = true;
        boolean decreasing = true;
        for (int i = 0; i < numbers.size() - 1 && (decreasing || incresing); i++) {
            if (numbers.get(i) < numbers.get(i + 1)) {
                decreasing = false;
            } else if (numbers.get(i) > numbers.get(i + 1)) {
                incresing = false;
            }

        }if (incresing) {
            return "A sorozat: növekvő";
        }
        if (decreasing) {
            return "A sorozat: csökkenő";
        }
        return "A sorozat: össze-vissza";
    }
}