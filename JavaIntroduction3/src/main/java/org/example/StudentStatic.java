package org.example;

public class StudentStatic {
    private static String name;

    public StudentStatic() {
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        StudentStatic.name = name;
    }

    public static String createStudent(){
        return "nuevo estudiante";
    }
}
