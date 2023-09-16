package main;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String tshirtColor;
    private String tshirtSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTshirtColor() {
        return tshirtColor;
    }

    public void setTshirtColor(String tshirtColor) {
        this.tshirtColor = tshirtColor;
    }

    public String getTshirtSize() {
        return tshirtSize;
    }

    public void setTshirtSize(String tshirtSize) {
        this.tshirtSize = tshirtSize;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int tests;

        tests = Integer.parseInt(sc.nextLine());

        while (tests != 0) {

            for (int i = 0; i < tests; i++) {
                String studentName = sc.nextLine();
                String studentInfo = sc.nextLine();

                Student student = new Student();
                student.setName(studentName);
                student.setTshirtColor(studentInfo.split(" ")[0]);
                student.setTshirtSize(studentInfo.split(" ")[1]);

                students.add(student);
            }

            List<Student> studentsSorted = students.stream()
                    .sorted(Comparator.comparing(Student::getTshirtColor).thenComparing(Student::getTshirtSize).reversed().thenComparing(Student::getName))
                    .sorted(Comparator.comparing(Student::getTshirtColor))
                    .collect(Collectors.toList());

            studentsSorted.forEach(student ->
                    System.out.println(student.getTshirtColor() + " " + student.getTshirtSize() + " " + student.getName()));

            students.clear();
            tests = Integer.parseInt(sc.nextLine());
            if (tests != 0)
                System.out.println();
        }
    }
}