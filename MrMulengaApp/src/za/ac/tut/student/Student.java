/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.student;

import static za.ac.tut.mulengadatainterface.MulengaDataInterface.ERROR_MESSAGE;
import static za.ac.tut.mulengadatainterface.MulengaDataInterface.STUD_LEGTH;
import za.ac.tut.mulengaexception.MulengaException;

/**
 *
 * @author hp
 */
public class Student {

    private String studentNo;
    private String name;
    private String surname;
    private double formativeAss;
    private double summativeAss;

    public Student() {
    }

    public Student(String studentNo, String name, String surname, double formativeAss, double summativeAss) throws MulengaException {
        setStudentNo(studentNo);
        this.name = name;
        this.surname = surname;
        this.formativeAss = formativeAss;
        this.summativeAss = summativeAss;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) throws MulengaException {
        if (isStudentNumberValid(studentNo)) {
            this.studentNo = studentNo;
        } else {
            throw new MulengaException(studentNo +" "+ ERROR_MESSAGE);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getFormativeAss() {
        return formativeAss;
    }

    public void setFormativeAss(double formativeAss) {
        this.formativeAss = formativeAss;
    }

    public double getSummativeAss() {
        return summativeAss;
    }

    public void setSummativeAss(double summativeAss) {
        this.summativeAss = summativeAss;
    }

    private boolean isStudentNumberValid(String studentNo) {
        boolean isValid = true;

        if (studentNo.length() == STUD_LEGTH) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }

}
