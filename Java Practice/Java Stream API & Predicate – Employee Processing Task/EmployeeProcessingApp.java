import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Employee Entity Class
class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(int id, String name, int age, double salary, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', age=%d, salary=%.2f, department='%s'}",
                id, name, age, salary, department);
    }
}

public class EmployeeProcessingApp {

    public static void main(String[] args) {
        // Sample Employee Dataset
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", 28, 55000, "HR"),
                new Employee(102, "Bob", 35, 75000, "IT"),
                new Employee(103, "Charlie", 42, 95000, "Finance"),
                new Employee(104, "David", 32, 65000, "IT"),
                new Employee(105, "Eva", 26, 48000, "HR"),
                new Employee(106, "Frank", 31, 85000, "IT"),
                new Employee(107, "Grace", 29, 62000, "Finance")
        );

        System.out.println("=========================================================");
        System.out.println("            JAVA STREAM API & PREDICATE TASKS            ");
        System.out.println("=========================================================\n");

        // --- Task 01: Print employees whose salary is greater than ₹60,000 using Predicate ---
        System.out.println("--- Task 01: Employees with Salary > ₹60,000 ---");
        Predicate<Employee> highSalaryPredicate = emp -> emp.getSalary() > 60000;
        employees.stream()
                .filter(highSalaryPredicate)
                .forEach(System.out::println);

        // --- Task 02: Print employees who belong to IT department and are older than 30 ---
        System.out.println("\n--- Task 02: IT Department Employees Older Than 30 ---");
        Predicate<Employee> isITDept = emp -> "IT".equalsIgnoreCase(emp.getDepartment());
        Predicate<Employee> isOlderThan30 = emp -> emp.getAge() > 30;
        
        employees.stream()
                .filter(isITDept.and(isOlderThan30))
                .forEach(System.out::println);

        // --- Task 03: Count employees whose age is greater than 30 ---
        System.out.println("\n--- Task 03: Count of Employees Older Than 30 ---");
        long countAbove30 = employees.stream()
                .filter(isOlderThan30)
                .count();
        System.out.println("Total count: " + countAbove30);

        // --- Task 04: Find the highest-paid employee ---
        System.out.println("\n--- Task 04: Highest-Paid Employee ---");
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaid.ifPresent(System.out::println); // FIXED HERE: System.out::println

        // --- Task 05: Print employee names in uppercase ---
        System.out.println("\n--- Task 05: Employee Names in Uppercase ---");
        employees.stream()
                .map(emp -> emp.getName().toUpperCase())
                .forEach(System.out::println);

        // --- Task 06: Calculate the average salary ---
        System.out.println("\n--- Task 06: Average Salary ---");
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.printf("Average Salary: ₹%.2f\n", averageSalary);

        // --- Task 07: Group employees by department ---
        System.out.println("\n--- Task 07: Group Employees by Department ---");
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        
        groupedByDept.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(emp -> System.out.println("   " + emp));
        });

        // --- Task 08: Sort employees by salary in descending order ---
        System.out.println("\n--- Task 08: Employees Sorted by Salary (Descending) ---");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        // --- Task 09: Find the first employee whose salary is greater than ₹80,000 ---
        System.out.println("\n--- Task 09: First Employee with Salary > ₹80,000 ---");
        Predicate<Employee> salaryAbove80k = emp -> emp.getSalary() > 80000;
        Optional<Employee> firstAbove80k = employees.stream()
                .filter(salaryAbove80k)
                .findFirst();
        firstAbove80k.ifPresent(System.out::println); // FIXED HERE: System.out::println

        // --- Task 10: Find the second-highest salary ---
        System.out.println("\n--- Task 10: Second-Highest Salary ---");
        Optional<Double> secondHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondHighestSalary.ifPresent(salary -> System.out.printf("Second-Highest Salary: ₹%.2f\n", salary));
    }
}