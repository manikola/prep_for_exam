package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> stringListsUnion(List<String> first, List<String> second){
        for(String item : first){
            if(!second.contains(item)){
                second.add(item);
            }
        }
        return second;
    }

    public List<String> shortestWords(List<String> words){
        List<String> shortestWords = new ArrayList<>();
        int min = words.get(0).length();
        for(String item : words){
            if(item.length() < min){
                min= item.length();

            }
        }
        for(String item : words){
           if(item.length() == min){
               shortestWords.add(item);
           }
        }
        return shortestWords;
    }
}
