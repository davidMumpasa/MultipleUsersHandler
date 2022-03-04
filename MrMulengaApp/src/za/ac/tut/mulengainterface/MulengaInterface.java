/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.mulengainterface;

import java.util.Map;
import za.ac.tut.mulengaexception.MulengaException;
import za.ac.tut.student.Student;

/**
 *
 * @author hp
 */
public interface MulengaInterface {
    
    public void getAndDisplayClassList(Map <String,Student> classList);
    public void editStudentMarks(Map <String,Student> classList )throws MulengaException;
    public void getAndDisplayStudentDetail(Map <String,Student> classList)throws MulengaException;
    public void addStudentRecord(Map <String,Student> classList)throws MulengaException;
    public void removeStudent(Map <String,Student> classList )throws MulengaException;
}
