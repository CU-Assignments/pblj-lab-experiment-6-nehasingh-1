/*To implement a Java program that sorts a list of Employee objects (based on name, age, and salary) using lambda expressions and stream operations to demonstrate efficient data processing    */
import java.util.ArrayList;
import java.util.Comparator;
class Employee {
    private String name;
    private int age;
    private double salary;
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }
}
public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));
        employees.stream()
                 .sorted(Comparator.comparing(Employee::getName))
                 .forEach(Employee::display);
        System.out.println();
        employees.stream()
                 .sorted(Comparator.comparingInt(Employee::getAge))
                 .forEach(Employee::display);
        System.out.println();
        employees.stream()
                 .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                 .forEach(Employee::display);
        System.out.println();
        ArrayList<Employee> employees2 = new ArrayList<>();
        employees2.add(new Employee("Alex", 28, 45000));
        employees2.add(new Employee("Alex", 32, 47000));
        employees2.add(new Employee("Alex", 25, 46000));
        employees2.stream()
                  .sorted(Comparator.comparingInt(Employee::getAge))
                  .forEach(Employee::display);
        System.out.println();
        ArrayList<Employee> employees3 = new ArrayList<>();
        employees3.add(new Employee("David", 29, 50000));
        employees3.add(new Employee("Eve", 31, 50000));
        employees3.add(new Employee("Frank", 27, 50000));
        employees3.stream()
                  .sorted(Comparator.comparing(Employee::getName))
                  .forEach(Employee::display);
    }
}
