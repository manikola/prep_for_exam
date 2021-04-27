package week02d05;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("JavaScript");
        list.add("Abap");
        list.add("C#");
        list.add("sql");

        for(String item : list){
            if(item.length() >= 5){
                System.out.println(item);
            }
        }

    }
}
//Hozz létre egy Languages osztályt, main metódussal! Ebben hozz létre egy listát, mely karakterláncokat tartalmaz!
// Vegyetek fel 3 elemet: Java, Python, JavaScript!
//
//Írd ki, az öt karakternél hosszabb programozási nyelveket!