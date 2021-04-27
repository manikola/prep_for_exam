package exam03preexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VowelFilter {

    public String filterVowels(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            char[] letters = line.toCharArray();
            for (char item : letters) {
                if (!isVowel(item)) {
                    sb.append(item);
                }
            }sb.append("\n");


        } return sb.toString();
    }


    private boolean isVowel(char c){
       return (c == 'a'|| c == 'á'|| c == 'e'|| c == 'é'|| c == 'i'|| c == 'í'|| c == 'o'|| c == 'ó'|| c == 'ö'|| c == 'ő'||
               c == 'u'||c == 'ú'||c == 'ü'||c == 'ű'|| c == 'A'|| c == 'Á'|| c == 'E'|| c == 'É'|| c == 'I'|| c == 'Í'||
                c == 'O'|| c == 'Ó'|| c == 'Ö'|| c == 'Ő'|| c == 'U'||c == 'Ú'||c == 'Ü'||c == 'Ű');
    }


    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/vowels.txt"))) {
            VowelFilter c = new VowelFilter();
            System.out.println(c.filterVowels(br));

        } catch (IOException e) {
            throw new IllegalStateException("Can not find file", e);
        }
    }
}

//Írj egy VowelFilter.filterVowels(BufferedReader reader) metódust, mely beolvas egy
//fájlt soronként, kiszűri belőle a magánhangzókat, és visszaadja egy String-ként.
//Tehát a bemeneti fájl tartalma:
//Aprócska
//Kalapocska
//Benne
//Csacska
//Macska
//Mocska

//Kimenet Stringként:
//prcsk
//Klpcsk
//Bnn
//Cscsk
//Mcsk
//Mcsk
