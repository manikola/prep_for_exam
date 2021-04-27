package week07d05;

public class Car extends Vehicle{

    private int numberOfGears;
    private TransmissionType type;


    public Car() {
        this.numberOfGears = super.getNumberOfGears();
        this.type = TransmissionType.AUTOMATIC;
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
