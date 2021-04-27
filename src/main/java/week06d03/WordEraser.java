package week06d03;

public class WordEraser {

    public String eraseWord(String words, String word){
        StringBuilder sb = new StringBuilder();
        String[] arr = words.split(" ");
        for(String item : arr){
            if( !item.equals(word) ){
                sb.append(item);
                sb.append(" ");
            }
        } return sb.toString();
    }
}
