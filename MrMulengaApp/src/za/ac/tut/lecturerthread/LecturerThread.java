/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.lecturerthread;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.mulengaexception.MulengaException;
import za.ac.tut.mulengainterface.MulengaInterface;
import za.ac.tut.student.Student;

/**
 *
 * @author hp
 */
public class LecturerThread extends Thread implements MulengaInterface {

    private Map<String, Student> classList;
    private int choice;

    public LecturerThread(Map<String, Student> classList, int choice) {
        this.choice = choice;
        this.classList = classList;

    }

    @Override
    public void run() {

        try {
            switch (choice) {
                case 1:
                    getAndDisplayClassList(classList);
                    break;
                case 2:
                    editStudentMarks(classList);
                    break;
                case 3:
                    getAndDisplayStudentDetail(classList);
                    break;
                case 4:
                    addStudentRecord(classList);
                    break;
                default:
                    removeStudent(classList);

            }

        } catch (MulengaException ex) {
            Logger.getLogger(LecturerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public synchronized void getAndDisplayClassList(Map<String, Student> classList) {

        System.out.println(Thread.currentThread().getName() + "The class list is" + "\n"
                + "--------------------------------------------------------------");
        for (Map.Entry student : classList.entrySet()) {

            System.out.println("Name: " + ((Student) (student.getValue())).getName() + "\n"
                    + "Surname: " + ((Student) (student.getValue())).getSurname() + "\n"
                    + "Student number: " + ((Student) (student.getValue())).getStudentNo() + "\n"
                    + "Formative Assessment: " + ((Student) (student.getValue())).getFormativeAss() + "\n"
                    + "Sumative Assessment: " + ((Student) (student.getValue())).getSummativeAss() + "\n");

        }

    }

    @Override
    public synchronized void editStudentMarks(Map<String, Student> classList) throws MulengaException {
        Scanner sc = new Scanner(System.in);

        String studentNum;
        int testChoice;
        double marks;

        System.out.println(Thread.currentThread().getName() + "Which student are you looking for?" + "\n"
                + "Please enter his student number: ");
        studentNum = sc.next();

        Student student = classList.get(studentNum);

        if (student != null) {
            System.out.println("Student found");

            System.out.println(Thread.currentThread().getName() + "Which test would you like to change? " + "\n"
                    + "1 --> Formative Assessment" + "\n"
                    + "2 --> Sumative Assessment" + "\n"
                    + "Your choice: ");
            testChoice = sc.nextInt();

            if (testChoice == 1) {

                System.out.println(Thread.currentThread().getName() + "Please enter the marks for the Formative assessment");
                marks = sc.nextDouble();
                student.setFormativeAss(marks);
                System.out.println("The new formative marks are: " + student.getFormativeAss());

            } else if (testChoice == 2) {

                System.out.println(Thread.currentThread().getName() + "Please enter the marks for the sumative assessment");
                marks = sc.nextDouble();
                student.setSummativeAss(marks);
                System.out.println("The new sumative marks are: " + student.getSummativeAss());

            }

            System.out.println("Marks Edited");

        }

    }

    @Override
    public synchronized void getAndDisplayStudentDetail(Map<String, Student> classList) throws MulengaException {
        String studentNum;
        Scanner sc = new Scanner(System.in);

        System.out.println(Thread.currentThread().getName() + "Which student are you looking for?" + "\n"
                + "Please enter his student number: ");
        studentNum = sc.next();

        Student student = classList.get(studentNum);

        if (student != null) {
            System.out.println("Student Details" + "\n"
                    + "----------------" + "\n");

            System.out.println("Name: " + student.getName() + "\n"
                    + "Surname: " + student.getSurname() + "\n"
                    + "Student number: " + student.getStudentNo() + "\n"
                    + "Formative Assessment: " + student.getFormativeAss() + "\n"
                    + "Sumative Assessment: " + student.getSummativeAss());

        } else {
            System.out.println("Student not found...");
        }

    }

    @Override
    public synchronized void addStudentRecord(Map<String, Student> classList) throws MulengaException {
        Scanner sc = new Scanner(System.in);
        String studentNum;
        String name;
        String surname;
        double formativeAss;
        double summativeAss;

        System.out.println(Thread.currentThread().getName() + " Please enter student number: ");
        studentNum = sc.next();

        System.out.println(Thread.currentThread().getName() + "Please enter the student name: ");
        name = sc.next();

        System.out.println(Thread.currentThread().getName() + "Please enter the student surname:");
        surname = sc.next();

        System.out.println(Thread.currentThread().getName() + "Please enter the formative marks: ");
        formativeAss = sc.nextDouble();

        System.out.println(Thread.currentThread().getName() + "Please enter the sumative marks: ");
        summativeAss = sc.nextDouble();

        Student stud = new Student(studentNum, name, surname, formativeAss, summativeAss);
        classList.put(studentNum, stud);

        System.out.println("The student has been successfully added");

        System.out.println(Thread.currentThread().getName() + "The class list is" + "\n"
                + "--------------------------------------------------------------");
        for (Map.Entry student : classList.entrySet()) {

            System.out.println("Name: " + ((Student) (student.getValue())).getName() + "\n"
                    + "Surname: " + ((Student) (student.getValue())).getSurname() + "\n"
                    + "Student number: " + ((Student) (student.getValue())).getStudentNo() + "\n"
                    + "Formative Assessment: " + ((Student) (student.getValue())).getFormativeAss() + "\n"
                    + "Sumative Assessment: " + ((Student) (student.getValue())).getSummativeAss() + "\n");
        }

    }

    @Override
    public synchronized void removeStudent(Map<String, Student> classList) throws MulengaException {
        Scanner sc = new Scanner(System.in);
        String studentNum;

        System.out.println(Thread.currentThread().getName() + "Which student do you want to remove?" + "\n"
                + "Please enter his student number: ");
        studentNum = sc.next();

        classList.remove(studentNum);
        System.out.println("The student has been successfully removed" + "\n");

        System.out.println(Thread.currentThread().getName() + "The class list is" + "\n"
                + "--------------------------------------------------------------");
        for (Map.Entry student : classList.entrySet()) {

            System.out.println("Name: " + ((Student) (student.getValue())).getName() + "\n"
                    + "Surname: " + ((Student) (student.getValue())).getSurname() + "\n"
                    + "Student number: " + ((Student) (student.getValue())).getStudentNo() + "\n"
                    + "Formative Assessment: " + ((Student) (student.getValue())).getFormativeAss() + "\n"
                    + "Sumative Assessment: " + ((Student) (student.getValue())).getSummativeAss() + "\n");

        }

    }

}
