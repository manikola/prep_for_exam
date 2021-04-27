package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities = new ArrayList<>();

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity a){
        activities.add(a);
    }
    public int numberOfTrackActivities(){
        int count = 0;
        for(Activity item : activities){
            if(item instanceof ActivityWithTrack){
                count++;
            }
        }
        return count;
    }

    public int numberOfWithoutTrackActivities(){
        int count = 0;
        for(Activity item : activities){
            if(item instanceof ActivityWithoutTrack){
                count++;
            }
        }
        return count;
    }

    public List<Report> distancesByTypes(){
        List<Report> report = new ArrayList<>();
       for(Activity item : activities){
           report.add(new Report(ActivityType.BIKING,getDistanceByType(ActivityType.BIKING)));
           report.add(new Report(ActivityType.HIKING,getDistanceByType(ActivityType.HIKING)));
           report.add(new Report(ActivityType.RUNNING,getDistanceByType(ActivityType.RUNNING)));
           report.add(new Report(ActivityType.BASKETBALL,getDistanceByType(ActivityType.BASKETBALL)));
       }
       return report;
    }

    private double getDistanceByType(ActivityType at){
        double sum = 0;
        for(Activity item : activities){
            if(item.getType() == at){
                sum += item.getDistance();
            }
        }
        return sum;
    }
}

//Activities osztály: Activity-k listáját tartalmazza. Le lehet kérdezni a track-es illetve a track nélküli listaelemeket.
// Valamint típusonként külön-külön a távolságot egy Report-okat tartalmazó listába.
