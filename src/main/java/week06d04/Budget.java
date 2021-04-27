package week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {

    private List<Item> items;

    public Budget(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItemsByMonth(int month){
        List<Item> results = new ArrayList<>();
        for(Item actual : items){
            if(actual.getMonth() == month){
                results.add(actual);
            }
        }return results;
    }


}