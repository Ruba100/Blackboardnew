/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackboard1;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author RRRRRRRRRRRRRRRRua
 */
public class Student extends User implements CourseManager {

    Scanner input = new Scanner(System.in);
    private int level;
    private int year;
    private Assignment assignment;
    private Grade grade;

    private ArrayList<Courses> Allcourses = new ArrayList<>();

    public Student() {

    }

    public Student(Grade grade) {

        this.grade = grade;
    }

    public Student(String name, int Id, int level, int year) {
        super(name, Id);
        this.level = level;
        this.year = year;
    }

    public int getLevel() {
        return level;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Courses> getAllcourses() {
        return Allcourses;
    }

    public void setAllcourses(ArrayList<Courses> Allcourses) {
        this.Allcourses = Allcourses;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Grade getGrade() {
        return grade;
    }

    @Override
    public void AddCourse() {
        System.out.println("Enter ID");
        int ID = input.nextInt();

        System.out.println("Enter name Of course");
        String nameOfcourses = input.next();

        System.out.println("Enter Course Professor name");
        String NameProf = input.next();

        Courses course = new Courses(ID, nameOfcourses, new Professor(NameProf));
        Allcourses.add(course);

    }

    @Override
    public void removeCourse(String courseName) {
        if (Allcourses.isEmpty()) {
            System.out.println("You do not have any course to remove !");
        } else {
            for (Courses course : Allcourses) {
                if (course.getNameCourse().equals(courseName)) {
                    Allcourses.remove(course);
                    break;
                }
            }
        }
    }

    @Override
    public void showCourses() {

        if (Allcourses.isEmpty()) {
            System.out.println("you dont have any Courses ");
        } else {
            System.out.println("Your Courses is :");

            for (int i = 0; i < Allcourses.size(); i++) {
                Collections.sort(Allcourses);
                System.out.println(Allcourses.get(i));
            }
        }
    }

    public String CreateEmail() {
        String emailset = "s";
        emailset = emailset + getYear();

        for (int i = 0; i < 7; i++) {
            int rand = (int) (Math.random() * 7);
            emailset = emailset + rand;
        }
        emailset = emailset + "@st.uqu.edu.sa";
        return emailset;
    }

    @Override
    public void showInfo() {
        System.out.println("Log in successful , your information :");
        System.out.println("Name:" + getName() + " Level:" + getLevel() + " Email: " + CreateEmail());
    }

}
