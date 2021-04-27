package vaccination;

public class Citizen {

    private String fullName;
    private String zipCode;
    private int age;
    private String email;
    private String TAJ;

    public Citizen(String fullName, String zipCode, int age, String email, String TAJ) {
        this.fullName = fullName;
        this.zipCode = zipCode;
        this.age = age;
        this.email = email;
        this.TAJ = TAJ;
    }

    public String getFullName() {
        return fullName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTAJ() {
        return TAJ;
    }

    @Override
    public String toString() {
        return fullName + " " + zipCode + " " + age + " " + email + " " + TAJ;
    }
}

//Az állampolgár regisztrálja magát az oltásra. A következő adatokat kell megadnia:
//
//Teljes név
//Irányítószám
//Életkor
//E-mail cím
//TAJ száma
