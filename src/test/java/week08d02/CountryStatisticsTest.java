package week08d02;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CountryStatisticsTest {

    @Test
    void maxPopulation() {
        try(BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/countries.txt"))){
            CountryStatistics cs = new CountryStatistics();
            cs.readFromFile(br);

            assertEquals("Kongoi_Demokratikus_Koztarsasag", cs.maxPopulation().getName());

        }catch (IOException e) {
            throw new IllegalStateException("Can not find file",e);
        }

    }
}