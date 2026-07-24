import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Student Entity Class
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Student Repository / Service
class StudentRepository {
    private List<Student> studentList = new ArrayList<>();

    public StudentRepository() {
        // Pre-populating sample student data
        studentList.add(new Student(101, "Alex"));
        studentList.add(new Student(102, "Brenda"));
        studentList.add(new Student(103, "Charlie"));
    }

    // Method returning Optional<Student> to safely manage missing records
    public Optional<Student> findStudentById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id)
                .findFirst(); // Returns Optional containing the student if found, or Optional.empty()
    }
}

public class StudentSearchApp {

    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();

        System.out.println("=========================================");
        System.out.println("        STUDENT SEARCH APPLICATION       ");
        System.out.println("=========================================\n");

        // Case 1: Searching for an existing student ID (102)
        int searchId1 = 102;
        System.out.println("Searching for Student ID: " + searchId1);
        Optional<Student> student1 = repository.findStudentById(searchId1);

        if (student1.isPresent()) {
            System.out.println("Student Found: " + student1.get().getName());
        } else {
            System.out.println("Student not found");
        }

        System.out.println();

        // Case 2: Searching for a non-existing student ID (999)
        int searchId2 = 999;
        System.out.println("Searching for Student ID: " + searchId2);
        Optional<Student> student2 = repository.findStudentById(searchId2);

        // Using ifPresentOrElse (or simple if-else) to print result
        student2.ifPresentOrElse(
            s -> System.out.println("Student Found: " + s.getName()),
            () -> System.out.println("Student not found")
        );
    }
}