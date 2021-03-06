package exam03preexam;

public enum CanoeType {

    RED(1.0), GREEN(1.2), BLUE(1.5);

    private double value;

    CanoeType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
