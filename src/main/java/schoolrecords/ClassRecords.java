package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student){
        for(Student item : students) {
            if (item.getName().equals(student.getName())) {
                return false;
            }
        }
            return students.add(student);
        }

    public boolean removeStudent(Student student) {
        for(Student item : students) {
            if (item.getName().equals(student.getName())) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public double calculateClassAverage(){
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double classAverage = 0;
        int countStudent = 0;
        for (Student student : students){
            double studentAverage = student.calculateAverage();
            if (studentAverage != 0){
                classAverage += studentAverage;
                countStudent++;
            }
        }
        if (countStudent == 0){
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round(100 * classAverage / countStudent ) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject){
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double classAverage = 0;
        int countStudent = 0;
        for (Student student : students){
            double studentAverage = student.calculateSubjectAverage(subject);
            if (studentAverage != 0){
                classAverage += studentAverage;
                countStudent++;
            }
        }
        if (countStudent == 0){
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round(100 * classAverage / countStudent ) / 100.0;
    }
    public Student findStudentByName(String name){
        if (students.isEmpty()){
            throw new IllegalStateException("No students to search!");
        }
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        Student student = getStudentByNameOrNull(name);
        if (student == null) {
            throw new IllegalArgumentException("Student by this name cannot be found! " + name);
        }
        return student;
    }
    public Student repetition(){
        if (students.isEmpty()){
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(this.rnd.nextInt(students.size()));
    }

    public List<StudyResultByName> listStudyResults(){

        List<StudyResultByName> tempList = new ArrayList<>();
        for (Student student : students){
            tempList.add(new StudyResultByName(student.calculateAverage(), student.getName()));
        }
        return tempList;
    }

    public String listStudentNames(){
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.getName()).append(", ");
        }
        return sb.toString().substring(0, sb.toString().lastIndexOf(","));
    }



    private Student getStudentByNameOrNull(String name) {
        for (Student student : students){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }




    private boolean isEmpty(String str) {
        return (str == null || str.isBlank());
    }
}
//ClassRecords oszt??ly, a r??gi pap??ralap?? napl?? egyes funkci??it reprezent??lja. Attrib??tuma az oszt??ly neve, egy Random
// objektum (konstruktorb??l be??ll??tva), valamint a di??kok list??ja. Di??kot adhatunk hozz?? ??s el is t??vol??thatjuk, el??bbi
// esetben m??r l??tez?? nev?? di??kot nem adhatunk hozz??, ??s elt??vol??tani csak olyat lehet, aki m??r ott van a list??ban
// (ism??t n??v alapj??n). Oszt??ly??tlagot tud sz??molni ??ltal??nosan ??s tant??rgy alapj??n, v??letlenszer??en ki tud v??lasztani
// egy di??kot felel??sre, meg tud keresni egy di??kot n??v alapj??n, ??s ki tudja list??zni a di??kok neveit ??s ??tlag??t a
// StudyResultByName oszt??ly objektumainak list??jak??nt.


//public Student repetition() //felelethez a list??b??l random m??don kiv??laszt egy di??kot
//public List<StudyResultByName> listStudyResults() //a di??kok nev??t ??s tanulm??nyi ??tlag??t egy-egy ??j objektumba viszi,
//// ??s azok list??j??t adja vissza
//public String listStudentNames() //kilist??zza a di??kok neveit, vessz??vel elv??lasztva