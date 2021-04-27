package week06d05;

public enum BottleType {

    GLASS_BOTTLE(3),PET_BOTTLE(20);

    private int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
