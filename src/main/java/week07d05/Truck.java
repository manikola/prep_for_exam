package week07d05;

public class Truck extends Vehicle{

    private int numberOfGears;
    private TransmissionType type;

    public Truck() {
        this.numberOfGears = super.getNumberOfGears();
        this.type = TransmissionType.MANUAL;
    }

    @Override
    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public TransmissionType getType() {
        return type;
    }
}
