package exam02;

public class ArraySelector {

    public String selectEvens(int[]arr){
        if(arr.length ==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i =0; i<arr.length; i=i+2){
            sb.append(arr[i]);
            sb.append(", ");
        }sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }


}

//Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből minden második elemet kiválogat, és egy
// szövegként összerak, szögletes zárójelek között!
//
//A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű
// elem páratlan, stb.
//Ha nulla elemű a tömb, akkor üres stringet adjon vissza!
