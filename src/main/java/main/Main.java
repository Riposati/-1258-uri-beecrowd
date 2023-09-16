package main;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String colorTshirt;
    private String sizeTshirt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorTshirt() {
        return colorTshirt;
    }

    public void setColorTshirt(String colorTshirt) {
        this.colorTshirt = colorTshirt;
    }

    public String getSizeTshirt() {
        return sizeTshirt;
    }

    public void setSizeTshirt(String sizeTshirt) {
        this.sizeTshirt = sizeTshirt;
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
                String nomeStudent = sc.nextLine();
                String infoStudent = sc.nextLine();

                Student student = new Student();
                student.setName(nomeStudent);
                student.setColorTshirt(infoStudent.split(" ")[0]);
                student.setSizeTshirt(infoStudent.split(" ")[1]);

                students.add(student);
            }

            List<Student> sortedStudents = students.stream()
                    .sorted(Comparator.comparing(Student::getColorTshirt).thenComparing(Student::getSizeTshirt).reversed().thenComparing(Student::getName))
                    .sorted(Comparator.comparing(Student::getColorTshirt))
                    .collect(Collectors.toList());

            sortedStudents.forEach(student ->
                    System.out.println(student.getColorTshirt() + " " + student.getSizeTshirt() + " " + student.getName()));

            students.clear();
            tests = Integer.parseInt(sc.nextLine());
            if (tests != 0)
                System.out.println();
        }
    }
}