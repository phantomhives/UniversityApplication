/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAO.StudentEntry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class StudentDLL extends DB{
    
   
    
    public ArrayList<StudentEntry> getAllStudent(){
        
        ArrayList<StudentEntry> studentEntrys = new ArrayList<>();
        
        try {
            this.SetConnection();
            
            String qurey = "SELECT * FROM studententry";
            this.statement = this.connection.prepareStatement(qurey);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next()){
                StudentEntry astudent = new StudentEntry();
                astudent.setStudent_id(this.resultSet.getInt(1));
                astudent.setStudent_name(this.resultSet.getString(2));
                astudent.setStudent_address(this.resultSet.getString(3));
                astudent.setStudent_email(this.resultSet.getString(4));
                astudent.setStudent_department(this.resultSet.getString(5));
                
                studentEntrys.add(astudent);
                
            }
            
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }finally{
            this.DisconnectFromDb();
        }
        return studentEntrys;
    }
    
    
    public boolean saveStudentEntry(StudentEntry aStudent){
        this.SetConnection();
        int count = 0;
        
        try {
            String qurey = "INSERT INTO studententry(student_name, student_address,"
                    + " student_email, student_department) VALUES(?,?,?,?)";
            this.statement = this.connection.prepareStatement(qurey);
            this.statement.setString(1, aStudent.getStudent_name());
            this.statement.setString(2, aStudent.getStudent_address());
            this.statement.setString(3, aStudent.getStudent_email());
            this.statement.setString(4, aStudent.getStudent_department());
            count = this.statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            this.DisconnectFromDb();
        }
        if(count>0){
            return  true;
        }
        return false;
    }

    
   

  
}
