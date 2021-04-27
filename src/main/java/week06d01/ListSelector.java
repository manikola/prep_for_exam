package week06d01;

import java.util.List;

public class ListSelector {

    public String selectEvens(List<String> text){
        StringBuilder sb = new StringBuilder();
        if(text == null){
            throw new IllegalArgumentException("List empty!");
        }
        sb.append("[");
        for(int i=0; i<text.size(); i+=2){
            sb.append(text.get(i));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        sb.append("]");
        return sb.toString();
    }
}

//Írj egy olyan metódust az ListSelector osztályban, mely egy kapott listából minden második elemet kiválogat, és egy
// szövegként összerak, szögletes zárójelek között. A páros megállapítása index szerint működik. Azaz az első, nulla
// indexű elem páros, a második, azaz egyes indexű elem páratlan, stb. Ha üres a lista, akkor üres stringet adjunk vissza.
// Ha a paraméterül kapott lista null, akkor dobj IllegalArgumentExceptiont a metódusban!
