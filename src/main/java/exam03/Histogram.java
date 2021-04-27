package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public String createHistogram(BufferedReader br) throws IOException{
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
           int number = Integer.parseInt(line);
           sb.append("*".repeat(number));
           sb.append("\n");
        }
        return sb.toString();
    }

}

//Olvass be egy szöveges fájlt soronként, melyben soronkont számok vannak. Majd hozz létre egy stringet, mely
// ugyanennyi sort tartalmaz, és annyi csillagot ír ki egymás mellé soronkont, amennyi a bemeneti fájlban lévő szám.
//
//Azaz a bemeneti fájl:

//3
//4
//1
//2
//A létrehozott String:

//***
//****
//*
//**
//Figyelj, hogy az algoritmusod lehetőleg hatékony legyen!
//
//A Histogram osztályba dolgozz, tesztje HistogramTest. Minden sor után legyen sortörés, az utolsó után is.
