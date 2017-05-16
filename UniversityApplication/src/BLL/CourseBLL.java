/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.CourseEntry;
import DLL.CourseDLL;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class CourseBLL {
    
    private final CourseDLL courseDLL;

    public CourseBLL() {
        this.courseDLL = new CourseDLL();
    }
    
    public ArrayList<CourseEntry> getAllCourse(){
        return courseDLL.getAllCourse();
    }
    
    public String saveCourseEntry(CourseEntry aEntry){
       if(this.courseDLL.saveCourseEntry(aEntry)){
           return "course saved successfully";
       }
       return "something went wrong";
    }
}
