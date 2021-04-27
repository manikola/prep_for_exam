package activity;

public class ActivityWithTrack implements Activity{

    private Track track;
    private ActivityType activityType;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        this.track = track;
        this.activityType = activityType;
    }

    @Override
    public double getDistance() {
        return track.getDistance();
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
//ActivityWithTrack osztály: Implementálja az Activity interface-t. Van egy Track adattagja. A getDistance()
// metódus a megadott track össztávolságát adja vissza míg a getType() a típust.