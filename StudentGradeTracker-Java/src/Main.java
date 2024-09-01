import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Using try-with-resources to automatically close the Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Student> students = new ArrayList<>();
            
            // Input student data
            System.out.println("Enter student information. Type 'done' when finished:");
            while (true) {
                System.out.print("Enter student name (or 'done' to finish): ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("done")) {
                    break;
                }
                
                System.out.print("Enter student ID: ");
                String id = scanner.nextLine();
                
                Student student = new Student(name, id);
                
                // Input grades
                while (true) {
                    System.out.print("Enter grade for " + name + " (or 'done' to finish): ");
                    String input = scanner.nextLine();
                    
                    if (input.equalsIgnoreCase("done")) {
                        break;
                    }
                    
                    try {
                        double grade = Double.parseDouble(input);
                        if (grade < 0 || grade > 100) {
                            System.out.println("Invalid input. Please enter a grade between 0 and 100.");
                        } else {
                            student.addGrade(grade);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }
                
                students.add(student);
            }
            
            // Ensure the data directory exists
            java.io.File dataDir = new java.io.File("data");
            if (!dataDir.exists()) {
                if (dataDir.mkdir()) {
                    System.out.println("Data directory created.");
                } else {
                    System.out.println("Failed to create data directory.");
                    return; // Exit if directory creation fails
                }
            }
            
            // Generate report
            try {
                ReportGenerator.generateCSVReport(students, "data/grades.csv");
                System.out.println("Report generated: data/grades.csv");
            } catch (Exception e) {
                System.out.println("An error occurred while generating the report: " + e.getMessage());
            }
        }
    }
}

