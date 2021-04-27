package week12d02;

public enum Side {

    EVEN(0),ODD(1);

    private int value;

    Side(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
