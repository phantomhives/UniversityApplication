/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author LENOVO
 */
public class CourseEntry {
    
    private String course_name;
    private String course_code;
    private int course_credit;

    public CourseEntry(String course_name, String course_code, int course_credit) {
        this.course_name = course_name;
        this.course_code = course_code;
        this.course_credit = course_credit;
    }

    public CourseEntry() {
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public int getCourse_credit() {
        return course_credit;
    }

    public void setCourse_credit(int course_credit) {
        this.course_credit = course_credit;
    }
    
    
}
