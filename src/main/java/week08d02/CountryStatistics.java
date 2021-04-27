package week08d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public void readFromFile(BufferedReader br){

        try  {
            String line;
            while((line = br.readLine()) != null){
                String[] arr = line.split(" ");
                countries.add(new Country(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));

            }


        } catch (IOException e) {
            throw new IllegalStateException("Can not read file",e);
        }
    }

    public Country maxPopulation(){
        Country result = countries.get(0);
        for(Country item : countries){
            if(item.getPopulation() > result.getPopulation()){
                result = item;

            }
        }
        return result;


    }



}
