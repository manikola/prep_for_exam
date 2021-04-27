package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    Random rnd = new Random();

    public List<Integer> getNumbers(){
        List<Integer> winningNumbers = new ArrayList<>();
        for( int i=0; i<5; i++){
            int nextNumber = rnd.nextInt(91);

            if(winningNumbers.contains(nextNumber)){
                winningNumbers.remove(nextNumber);
            }
            winningNumbers.add(nextNumber);
        }
        return winningNumbers;
    }
}
