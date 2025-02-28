/*Implement Java program that uses lambda expressions and Stream API to filter students who scored above 75%, sort them by marks, and display their names.*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
class Student {
    private String name;
    private double marks;
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
    public void display() {
        System.out.println(name);
    }
    public String getName() {
        return name;
    }
    public double getMarks() {
        return marks;
    }
}
public class Project1{
    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
    }
    private static void runTest(List<Student> students) {
        List<Student> filteredSortedStudents = students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed()
                        .thenComparing(Student::getName))
                .collect(Collectors.toList());
        if (filteredSortedStudents.isEmpty()) {
            System.out.println("No output (Empty List)");
        } else {
            filteredSortedStudents.forEach(Student::display);
        }
        System.out.println();
    }
    private static void testCase1() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 80));
        students.add(new Student("Bob", 72));
        students.add(new Student("Charlie", 90));
        students.add(new Student("David", 65));
        students.add(new Student("Eve", 85));
        runTest(students);
    }
    private static void testCase2() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Bob", 70));
        students.add(new Student("David", 60));
        students.add(new Student("Frank", 65));
        runTest(students);
    }
    private static void testCase3() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 80));
        students.add(new Student("Bob", 80));
        students.add(new Student("Charlie", 85));
        runTest(students);
    }
    private static void testCase4() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 60));
        students.add(new Student("Bob", 50));
        students.add(new Student("Charlie", 90));
        runTest(students);
    }
}
