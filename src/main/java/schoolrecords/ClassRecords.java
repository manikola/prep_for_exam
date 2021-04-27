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
//ClassRecords osztály, a régi papíralapú napló egyes funkcióit reprezentálja. Attribútuma az osztály neve, egy Random
// objektum (konstruktorból beállítva), valamint a diákok listája. Diákot adhatunk hozzá és el is távolíthatjuk, előbbi
// esetben már létező nevű diákot nem adhatunk hozzá, és eltávolítani csak olyat lehet, aki már ott van a listában
// (ismét név alapján). Osztályátlagot tud számolni általánosan és tantárgy alapján, véletlenszerűen ki tud választani
// egy diákot felelésre, meg tud keresni egy diákot név alapján, és ki tudja listázni a diákok neveit és átlagát a
// StudyResultByName osztály objektumainak listájaként.


//public Student repetition() //felelethez a listából random módon kiválaszt egy diákot
//public List<StudyResultByName> listStudyResults() //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
//// és azok listáját adja vissza
//public String listStudentNames() //kilistázza a diákok neveit, vesszővel elválasztva