package week04d01;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {
        if(fullName == null || fullName.isBlank() || fullName.isEmpty()){
            throw new IllegalArgumentException("Invalid name:" + fullName);
        }
        this.fullName = fullName;
    }
    public String changeFirstName(String firstName){
        String[] arr = fullName.split(" ");
        return firstName + " " + arr[1];

    }
}

//Készítsd el a NameChanger osztályt, melynek privát attribútuma legyen a String fullName, mely egy ember teljes nevét
// reprezentálja! A fullName attribútum [vezetéknév][szóköz][keresztnév] formátumban épül fel. A konstruktor állítsa
// be a paraméterül kapott értékre az adattagot, de ha az érték null, vagy üres String, akkor dobjon egy
// IllegalAgrumentException kivételt a következő üzenettel: Invalid name:[paraméter értéke]!
//
//Legyen egy changeFirstName(String firstName) metódusa, mely megváltoztatja az objektum állapotát és kicseréli a
// keresztnevet a paraméterül kapott értékre!
