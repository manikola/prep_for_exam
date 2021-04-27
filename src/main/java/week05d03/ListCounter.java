package week05d03;

import java.util.List;

public class ListCounter {

    public int countAElements(List<String> wordsList) {
        int counter = 0;
        if (wordsList.size() == 0) {
            throw new IllegalArgumentException("List is empty");
        }
        for (String item : wordsList) {
            if (item.toLowerCase().startsWith("a")) {
                counter++;
            }

            if (counter ==0){
                throw new IllegalArgumentException("Not found any");
            }





        }  return counter;

}
}

//Írj egy olyan metódust a ListCounter osztályban, mely a kapott String listából összeszámolja azokat, amelyek a
// vagy A betűvel kezdődnek! Ha nulla elemű a tömb, vagy nincs benne ilyen elem, akkor nulla értéket adjon vissza!
