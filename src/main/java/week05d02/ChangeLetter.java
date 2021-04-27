package week05d02;

public class ChangeLetter {

    public String changeVowels(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char item : chars) {
            if (isVowel(item)) {
                sb.append("*");
            } else {
                sb.append(item);
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
//A ChangeLetter osztályban írj meg egy String changeVowels(String) metódust, mely kicseréli a paraméterként átadott
// szövegben az angol magánhangzókat csillag (*) karakterre.
