package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if(name.isEmpty()){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark){

        if(mark == null){
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);

    }

    public double calculateAverage(){
        if (marks.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for(Mark item : marks){
            sum = sum + item.getMarkType().getValue();
        }double avg = sum / marks.size();
        return (Math.round(avg * 100) / 100.0);
    }

    public double calculateSubjectAverage(Subject subject) {
        if (marks.isEmpty()) {
            return 0;
        }
        double sum = 0;
        int counter = 0;
        for(Mark item : marks){
            if(item.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                sum += item.getMarkType().getValue();
                counter++;
            }

            }double avg = sum / counter;
        return Math.round(avg *100) /100.0;
        }



    @Override
    public String toString() {
        String temp = name + " marks: ";
        for (Mark item : marks) {
            temp += item.getSubject().getSubjectName() + ": " + item.toString() + " ";
        }
        return temp.trim();
    }


    private boolean isEmpty(String str) {
        return (str == null || str.isBlank());
    }
}
