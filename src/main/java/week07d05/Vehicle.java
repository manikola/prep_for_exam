package week07d05;

public class Vehicle {

    private int numberOfGears;
    private TransmissionType type;

    public Vehicle(int numberOfGears, TransmissionType type) {
        this.numberOfGears = 5;
        this.type = TransmissionType.MANUAL;
    }

    public Vehicle() {
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public TransmissionType getType() {
        return type;
    }
}
