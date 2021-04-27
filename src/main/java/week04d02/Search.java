package week04d02;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public List<Integer> getIndexesOfChar(String str, char c){
        char [] arr = str.toCharArray();
        List<Integer> results = new ArrayList<>();
        for( int i =0; i< arr.length; i++){
            if(arr[i] == c){
                results.add(i);
            }
        } return results;
    }
}

//A Search osztályban írj egy getIndexesOfChar() metódust, mely első paraméterként vár egy String értéket, második
// paraméterként egy char értéket! Visszaad egy listát, melyben visszaadja, hogy a karakter hanyadik indexeken szerepel
// az első paraméterként átadott listában.
//
//Pl.: almafa szóban a a karakter: 0, 3, 5.
