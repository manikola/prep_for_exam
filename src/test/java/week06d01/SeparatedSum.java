package week06d01;

import java.util.ArrayList;
import java.util.List;

public class SeparatedSum {

    public String sum(String str){
        List<Double> numbers= new ArrayList<>();
        double sumNegative = 0;
        double sumPositive = 0;
        str = str.replace(",", ".");
        String[] arr = str.split(";");
        for(int i=0; i< arr.length; i++){


            numbers.add(Double.parseDouble(arr[i]));
        }

        for(Double item : numbers){
            if( item >0){
                sumPositive += item;
            }
            if (item <0){
                sumNegative += item;
            }
        }
        return "Pozitív összeg: " + sumPositive + ", Negatív összeg: " + sumNegative;

    }
}
//Írj egy SeparatedSum.sum(String s) metódust, mely kap egy String-et, melyben lebegőpontos számok szerepelnek
// pontosvesszővel elválasztva. A számoknál vessző a tizedeselválasztó. Ezt szétszedi, és összeadja külön a pozitív és
// külön a negatív számokat. Mivel térnél vissza ebből a metódusból?
// "12,13;-14,15;-15,16;16,17;-20,18;18,19"