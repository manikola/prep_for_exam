package exam02;

public class Skill {

    private String name;
    private int level;

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return name + " ("+ level + ")";
    }
}
//A skillek megadása a nevével, valamint a szintjével történik, pl. programming (5).
