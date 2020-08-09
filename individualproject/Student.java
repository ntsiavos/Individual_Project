/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import static individualproject.IndividualProject.sc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ntsia
 */
public class Student {
    private String fname;
    private String lname;
    private LocalDate dateOfBirth;
    private Integer tuition;
    private List<Course> courses;

    public Student() {
        
    }

    public Student(String fname, String lname) {
        this.courses = new ArrayList();
        this.fname = fname;
        this.lname = lname;
    }
    
    

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getTuition() {
        return tuition;
    }

    public void setTuition(Integer tuition) {
        this.tuition = tuition;
    }
    
        public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" + "fname=" + fname + ", lname=" + lname + ", dateOfBirth=" + dateOfBirth + ", tuition=" + tuition + ", courses=" + courses + '}';
    }
    
    
    
    public static void createStudent(){
        System.out.println("Please enter the first name of the student: ");
        String fname = sc.nextLine();
        System.out.println("Please enter the last name of the student: ");
        String lname = sc.nextLine();
        Student st = new Student(fname, lname);
        for (Course course : IndividualProject.courses) {
            System.out.println("Is " +st.getFname()+" "+st.getLname()+ " registered in " +course.getTitle()+ "? (y/n): ");
            String checkCourse = sc.next();
            if (checkCourse.equals("y")) {
                course.getCourseStudents().add(st);
                st.getCourses().add(course);
            }
        }
        IndividualProject.students.add(st);
        System.out.println("If you would like to register another student, please press 1. Otherwise, press 2 to complete registration: ");
        int studentCheck = sc.nextInt();
        sc.nextLine();
        if (studentCheck==1) createStudent();
        if (studentCheck==2){
            System.out.println("********************"); 
            System.out.println("Registration process complete!");
            IndividualProject.finalMenu();
        }
    }


}
