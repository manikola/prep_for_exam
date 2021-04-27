package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints= new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public double getFullElevation() {
        double sum = 0.0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i).getElevation() < trackPoints.get(i + 1).getElevation()) {
                sum += (trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation());
            }
        }
        return sum;
    }

    public double getFullDecrease() {
        double sum = 0.0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i).getElevation() > trackPoints.get(i + 1).getElevation()) {
                sum += (trackPoints.get(i).getElevation() - trackPoints.get(i + 1).getElevation());
            }
        }
        return sum;
    }

    public double getDistance() {
        double sum = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            sum += trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1));
        }
        return sum;
    }

    public Coordinate findMinimumCoordinate() {
        double minLatitude = Integer.MAX_VALUE;
        double minLongitude = Integer.MAX_VALUE;

        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLatitude() < minLatitude) {
                minLatitude = item.getCoordinate().getLatitude();
            }
        }
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLongitude() < minLongitude) {
                minLongitude = item.getCoordinate().getLongitude();
            }
        }
        Coordinate minCoordinate = new Coordinate(minLatitude, minLongitude);
        return minCoordinate;
    }

    public Coordinate findMaximumCoordinate() {
        double maxLatitude = Integer.MIN_VALUE;
        double maxLongitude = Integer.MIN_VALUE;

        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLatitude() > maxLatitude) {
                maxLatitude = item.getCoordinate().getLatitude();
            }
        }
        for (TrackPoint item : trackPoints) {
            if (item.getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = item.getCoordinate().getLongitude();
            }
        }
        Coordinate maxCoordinate = new Coordinate(maxLatitude, maxLongitude);
        return maxCoordinate;
    }

    public double getRectangleArea() {
        double area = 0.0;

        for (TrackPoint item : trackPoints) {
            area = (findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude()) *
                    (findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude());
        }
        return area;

    }

    public void loadFromGpx(InputStream is) {
        Coordinate c = null;
        double elevation = 0.0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("<trkpt")) {
                    String[] arr = line.split("\"");
                    c = new Coordinate(Double.parseDouble(arr[1]), Double.parseDouble(arr[3]));
                }
                if (line.contains("<ele")) {
                    elevation = Double.parseDouble(line.substring(line.length() - 11, line.length() - 6));

                    addTrackPoint(new TrackPoint(c, elevation));
                }
            }



        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);

        }

    }
}
// <trkpt lat="47.2166800" lon="18.5414340">
//  <ele>150.6</ele>