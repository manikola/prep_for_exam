package week02d03;

public class Product {

    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product pro){
        return (name.equals(pro.getName()));
    }

    public boolean areTheyEqualOther(Product pro){
        return ((Math.abs(code.length() - pro.getCode().length())) <= 1);
    }
}

//Írj egy Product oszályt String name és String code attribútumokkal! Legyen egy konstruktora a két attribútummal!
// Legyen egy areTheyEqual() metódusa, mely kap egy másik Product példányt, és eldönti, hogy azonos-e az adott példánnyal.
// Két termék akkor egyezik, ha a nevük megegyezik.
//
//Bónusz: szigorúbb egyelőség a feltételre: a két termék kódjának hosszának különbsége maximum egy karakter lehet.
