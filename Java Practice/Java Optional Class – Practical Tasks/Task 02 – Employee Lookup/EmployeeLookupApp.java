import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Employee Entity Class
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Employee[ID=%d, Name='%s', Salary=₹%.2f]", id, name, salary);
    }
}

// Service / Repository Class
class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        // Pre-populating sample employee records
        employees.add(new Employee(101, "David", 65000.00));
        employees.add(new Employee(102, "Emma", 72000.00));
        employees.add(new Employee(103, "Frank", 58000.00));
    }

    // Finds an employee by ID and returns an Optional<Employee>
    public Optional<Employee> findEmployee(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst(); // Returns Optional.empty() if no match is found
    }
}

public class EmployeeLookupApp {

    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();

        // Default Employee Object used as fallback
        Employee defaultEmployee = new Employee(0, "Default Employee", 0.0);

        System.out.println("=========================================");
        System.out.println("        EMPLOYEE LOOKUP SYSTEM           ");
        System.out.println("=========================================\n");

        // Case 1: Searching for an existing employee (ID: 102)
        int searchId1 = 102;
        System.out.println("Searching for Employee ID: " + searchId1);
        Employee emp1 = repository.findEmployee(searchId1)
                                 .orElse(defaultEmployee);
        System.out.println("Result: " + emp1);

        System.out.println();

        // Case 2: Searching for a non-existing employee (ID: 999)
        int searchId2 = 999;
        System.out.println("Searching for Employee ID: " + searchId2);
        Employee emp2 = repository.findEmployee(searchId2)
                                 .orElse(defaultEmployee);
        System.out.println("Result: " + emp2);
    }
}