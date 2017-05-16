/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.StudentEntry;
import DLL.StudentDLL;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class StudentBLL {
    
    private final StudentDLL studentDLL;

    public StudentBLL() {
        this.studentDLL = new StudentDLL();
    }
    
    public ArrayList<StudentEntry> getAllStudent(){
        return studentDLL.getAllStudent();
    }
    
    public String saveStudentEntry(StudentEntry aStudent){
        if(this.studentDLL.saveStudentEntry(aStudent)){
            return "Student save done";
        }
        return "Something wrong";
    }
    
    
}
