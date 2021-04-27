package week02d02;

public class Phone {

    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }


}
//Írj egy Phone osztályt, type (String) és mem (int) attribútumokkal! Generálj konstruktort, gettert és settert!
// Írj bele egy main metódust, amivel példányosítasz egy osztályt, és kiírod az attribútumok értékeit!
