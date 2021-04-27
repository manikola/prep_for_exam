package week11d02;

public class Ride {

    private int day;
    private int serialNumber;
    private int km;

    public int getDay() {
        return day;
    }

    public  Ride(int day, int serialNumber, int km) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("Incorrect day");
        }
        this.day = day;
        if (serialNumber < 1) {
            throw new IllegalArgumentException("Incorrect ride");
        }
        this.serialNumber = serialNumber;
        if (km <= 0) {
            throw new IllegalArgumentException("Invalid km");
        }
        this.km = km;
        }




        public int getSerialNumber () {
            return serialNumber;
        }

        public int getKm () {
            return km;
        }
    }

