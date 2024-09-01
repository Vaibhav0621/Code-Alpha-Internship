import java.util.ArrayList;
public class Student {
    private String name;
    private String id;
    private ArrayList<Double> grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
