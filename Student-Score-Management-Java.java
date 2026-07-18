package studentmanagement;

import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int id = read.nextInt();

        read.nextLine();

        System.out.print("Enter student name: ");
        String name = read.nextLine();

        System.out.print("Enter number of courses: ");
        int numCourse = read.nextInt();

        Student s1 = new Student(id, name, numCourse);

        s1.fillScore();

        System.out.print("Enter index to get score: ");
        int index = read.nextInt();

        System.out.println("Score: " + s1.getOneScore(index));

        s1.print();

        read.close();
    }
}

class Student {

    private int id;
    private String name;
    private int numCourse;
    private int[] score;

    public Student(int id, String name, int numCourse) {
        this.id = id;
        this.name = name;
        this.numCourse = numCourse;
        score = new int[numCourse];
    }

    public void fillScore() {

        Scanner read = new Scanner(System.in);

        for (int i = 0; i < score.length; i++) {

            while (true) {

                try {
                    System.out.print("Enter score for course " + (i + 1) + ": ");
                    score[i] = read.nextInt();
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Please enter numbers only!");
                    read.nextLine();
                }
            }
        }
    }

    public int getOneScore(int index) {

        try {
            return score[index];

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index: " + index);
            return -1;
        }
    }

    public void print() {

        System.out.println("\n----- Student Information -----");

        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Number of courses: " + numCourse);

        System.out.println("Scores:");

        for (int m : score) {
            System.out.print(m + " ");
        }

        System.out.println();
    }
}