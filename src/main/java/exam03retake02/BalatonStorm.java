package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {


    public List<String> getStationsInStorm(BufferedReader br){
        List<String> results = new ArrayList<>();
        String station = null;
        try  {
            String line;
            while((line = br.readLine()) != null){
                if(line.contains("allomas")){
                   String[] arr =  line.split(": ");
                    station = arr[1].substring(1, arr[1].length()-2);
                }
                if (line.contains("level\": 3")) {
                    results.add(station);
                }

            }results.sort(Collator.getInstance(new Locale("hu", "HU")));

        } catch (IOException e) {
            e.printStackTrace();
        }


        return results;
    }
}





