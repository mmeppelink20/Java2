package en.codegym.task.pro.task13.task1309;

import java.util.HashMap;

/*
Student performance
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Adam", 99.2d);
        grades.put("Charlie", 72.9d);
        grades.put("Paul", 88.2d);
        grades.put("Steve", 62.8d);
        grades.put("Marry", 93.2d);
    }
}