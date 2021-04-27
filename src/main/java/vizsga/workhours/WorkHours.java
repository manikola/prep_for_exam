package vizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkHours {

    public String minWork(String file){
        List<Work> results = new ArrayList<>();

            Path path = Path.of("src/main/resources/" + file);

            try (BufferedReader br = Files.newBufferedReader(path)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] temp = line.split(",");
                    String name = temp[0];
                    int hours = Integer.parseInt(temp[1]);
                    String[] date = temp[2].split("-");
                    results.add(new Work(name,hours,LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]))));
                }

                results.sort(Comparator.comparing(Work::getHours,Comparator.reverseOrder()));
                return results.get(0).toString();


            } catch (IOException e) {
                throw new IllegalStateException("Can not read file", e);
            }
        }



}
