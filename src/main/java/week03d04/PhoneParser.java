package week03d04;

public class PhoneParser {

    public Phone parse(String str){
        String[]arr = str.split("-");
        return new Phone(arr[0],arr[1]);
    }
}

//Írj egy Phone oszályt, melynek van egy prefix és egy number String attribútuma! Írj egy PhoneParser osztályt egy
// parse(String) metódussal, ami beolvas egy 10-1234567 formátumú szöveget, és visszaad egy Phone objektumot,
// feltöltve a prefix értékét 10, a number értékét 1234567 értékekkel!
