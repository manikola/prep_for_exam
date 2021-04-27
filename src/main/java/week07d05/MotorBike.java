package week07d05;

public class MotorBike extends Vehicle{

    private int numberOfGears;
    private TransmissionType type;

    public MotorBike() {
        this.numberOfGears = super.getNumberOfGears();
        this.type = TransmissionType.SEQUENTIAL;
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

