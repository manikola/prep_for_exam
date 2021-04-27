package week08d02;

public class Country {

    private String name;
    private int population;
    private int flagColours;
    private int neighbours;

    public Country(String name, int population, int flagColours, int neighbours) {
        this.name = name;
        this.population = population;
        this.flagColours = flagColours;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getFlagColours() {
        return flagColours;
    }

    public int getNeighbours() {
        return neighbours;
    }

    @Override
    public String toString() {
        return name + '\'' + " " + population + " " + flagColours + " " + neighbours;
    }
}
