package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String flightNumber;
    private Direction direction;
    private String city;
    private LocalTime time;

    public Flight(String flightNumber, Direction direction, String city, LocalTime time) {
        this.flightNumber = flightNumber;
        this.direction = direction;
        this.city = city;
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return flightNumber + " " + direction + " " + city + " " + time;
    }
}
//try (BufferedReader reader = new BufferedReader(new InputStreamReader(BalatonStormTest.class.getResourceAsStream("storm.json"))))