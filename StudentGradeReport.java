import java.util.*;

class Student {
    String name;
    List<Double> marks = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addMark(double mark) {
        marks.add(mark);
    }

    double getAverage() {
        return marks.stream().mapToDouble(m -> m).average().orElse(0.0);
    }

    String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    void printSummary() {
        System.out.printf("Name: %-10s Marks: %-20s Average: %-6.2f Grade: %s\n",
                name, marks.toString(), getAverage(), getGrade());
    }
}

public class StudentGradeReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("\n--- Enter details for Student %d ---\n", i + 1);
            System.out.print("Name: ");
            String name = sc.nextLine();
            Student s = new Student(name);

            System.out.print("Enter number of marks: ");
            int numMarks = Integer.parseInt(sc.nextLine());

            for (int j = 0; j < numMarks; j++) {
                System.out.printf("Enter mark %d: ", j + 1);
                double mark = Double.parseDouble(sc.nextLine());
                s.addMark(mark);
            }

            students.add(s);
        }

        System.out.println("\n===== Student Grade Report =====");
        for (Student s : students) {
            s.printSummary();
        }
    }
}
