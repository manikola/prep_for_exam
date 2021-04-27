package vizsga.workhours;

import java.time.LocalDate;

public class Work {

    private String name;
    private int hours;
    private LocalDate date;

    public Work(String name, int hours, LocalDate date) {
        this.name = name;
        this.hours = hours;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return name + " " + date;
    }
}
