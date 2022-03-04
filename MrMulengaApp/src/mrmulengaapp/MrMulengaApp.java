/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrmulengaapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.lecturerthread.LecturerThread;
import za.ac.tut.mulengaexception.MulengaException;
import za.ac.tut.student.Student;

/**
 *
 * @author hp
 */
public class MrMulengaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        Map<String, Student> classList = new HashMap();
        Scanner sc = new Scanner(System.in);
        int choice;

        try {
            Student student1 = new Student("111111111", "David", "Mumpasa", 68.9, 78.9);
            Student student2 = new Student("222222222", "Enock", "Mulumba", 67.5, 70.5);
            Student student3 = new Student("333333333", "Kaaris", "Katolo", 56.9, 69.7);
            Student student4 = new Student("444444444", "Bnj", "Wetchi", 70.1, 62.5);
            Student student5 = new Student("555555555", "Maluleka", "Matlaba", 70.8, 63.7);

            classList.put("111111111", student1);
            classList.put("222222222", student2);
            classList.put("333333333", student3);
            classList.put("444444444", student4);
            classList.put("555555555", student5);

            System.out.println("Please select an option below:" + "\n"
                    + "1 --> Get and display the classlist" + "\n"
                    + "2 --> Edit the marks of a student for a specific test" + "\n"
                    + "3 --> Get and display the details of a specific student" + "\n"
                    + "4 --> Add a student record" + "\n"
                    + "5 --> Remove a student" + "\n"
                    + "6 --> Exit" + "\n"
                    + "Your choice: ");
            choice = sc.nextInt();

            while (choice != 6) {

                LecturerThread mulenga = new LecturerThread(classList, choice);
                LecturerThread Mulumba = new LecturerThread(classList, choice);
                LecturerThread Sibiya = new LecturerThread(classList, choice);

                mulenga.setName("Mr mulenga ");
                Mulumba.setName("Mr Mulumba ");
                Sibiya.setName("Mr Sibiya ");

                try {
                    mulenga.start();
                    mulenga.join();
                    
                    Mulumba.start();
                    Mulumba.join();

                    Sibiya.start();
                    Sibiya.join();

                } catch (InterruptedException ex) {
                    Logger.getLogger(MrMulengaApp.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("\n\n" + "Please select an option below:" + "\n"
                        + "1 --> Get and display the classlist" + "\n"
                        + "2 --> Edit the marks of a student for a specific test" + "\n"
                        + "3 --> Get and display the details of a specific student" + "\n"
                        + "4 --> Add a student record" + "\n"
                        + "5 --> Remove a student" + "\n"
                        + "6 --> Exit" + "\n"
                        + "Your choice: ");
                choice = sc.nextInt();

            }

        } catch (MulengaException ex) {
            Logger.getLogger(MrMulengaApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
