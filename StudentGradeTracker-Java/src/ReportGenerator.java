import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
public class ReportGenerator {

    public static void generateCSVReport(ArrayList<Student> students, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Name,ID,Average,Highest,Lowest\n");
            for (Student student : students) {
                ArrayList<Double> grades = student.getGrades();
                double average = GradeCalculator.calculateAverage(grades);
                double highest = GradeCalculator.findHighest(grades);
                double lowest = GradeCalculator.findLowest(grades);
                writer.append(String.format("%s,%s,%.2f,%.2f,%.2f\n", student.getName(), student.getId(), average, highest, lowest));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while generating the report.");
            e.printStackTrace();
        }
    }
}
