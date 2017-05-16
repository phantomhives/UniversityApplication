/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAO.CourseEntry;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class CourseDLL extends DB{
    
    public ArrayList<CourseEntry> getAllCourse(){
        
        ArrayList<CourseEntry> courseEntrys = new ArrayList<>();
        
        try {
            this.SetConnection();
            
            String qurey = "SELECT * FROM course";
            this.statement = this.connection.prepareStatement(qurey);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next()){
                CourseEntry aEntry = new CourseEntry();
                aEntry.setCourse_name(this.resultSet.getString(1));
                aEntry.setCourse_code(this.resultSet.getString(2));
                aEntry.setCourse_credit(this.resultSet.getInt(3));
                courseEntrys.add(aEntry);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            this.DisconnectFromDb();
        }
        return courseEntrys;
    }
    
    public boolean saveCourseEntry(CourseEntry aEntry){
        this.SetConnection();
        int count = 0;
      
        try {
            String qurey = "INSERT INTO `course`(`course_name`, `course_code`, `course_credit`)  VALUES(?,?,?)";
            this.statement = this.connection.prepareStatement(qurey);
            this.statement.setString(1, aEntry.getCourse_name());
            this.statement.setString(2, aEntry.getCourse_code());
            this.statement.setInt(3, aEntry.getCourse_credit());
            count = this.statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            this.DisconnectFromDb();
        }
        if(count>0){
            return true;
        }
        return false;
    }
}
