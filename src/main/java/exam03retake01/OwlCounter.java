package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> birds = new HashMap<>();

    public void readFromFile(BufferedReader reader) {

        try(reader){
            String line;
            while ((line = reader.readLine()) != null) {
                String arr[] = line.split("=");
                birds.put(arr[0],Integer.parseInt(arr[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file.", ioe);
        }
    }
    public int getNumberOfOwls(String county){
        return birds.get(county);

    }
}

