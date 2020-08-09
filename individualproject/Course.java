/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import static individualproject.IndividualProject.sc;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ntsia
 */
public class Course {

    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Assignment> courseAssignments = new ArrayList();
    private List<Trainer> courseTrainers = new ArrayList();
    private List<Student> courseStudents = new ArrayList();
    
    
    public Course() {
    }

    public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Assignment> getCourseAssignments() {
        return courseAssignments;
    }

    public void setCourseAssignments(List<Assignment> courseAssignments) {
        this.courseAssignments = courseAssignments;
    }
    
           
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
   
    public List<Trainer> getCourseTrainers() {
        return courseTrainers;
    }

    public void setCourseTrainers(List<Trainer> courseTrainers) {
        this.courseTrainers = courseTrainers;
    }
    
        public List<Student> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(List<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", stream=" + stream + ", type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + ", courseAssignments=" + courseAssignments + ", courseTrainers=" + courseTrainers + ", courseStudents=" + courseStudents + '}';
    }
   
    
     //Course and assignments creation.
    public static void createCourse(){
        System.out.print("Please enter the title of the course: ");
        String title = sc.nextLine();
        System.out.print("Please enter the stream of the course: ");
        String stream = sc.nextLine();
        String type=checkType();
        
        
        System.out.print("Please enter the starting date of the course (dd/mm/yyyy): ");
        String s = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(s, formatter);
        
        System.out.print("Please enter the end date of the course (dd/mm/yyyy): ");
        s = sc.next();
        LocalDate endDate = LocalDate.parse(s, formatter);
        Course course = new Course(title, stream, type, startDate, endDate);
        IndividualProject.courses.add(course);
        System.out.print("Please enter the number of assignments for this course(0, 1, 2, 7, 45, etc): ");
        int assignNumber = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<assignNumber; i++){
            course.getCourseAssignments().add(Assignment.createAssignment());
        }
        
        System.out.println("********************");
        System.out.print("Course registered. If you would like to register another course, please press 1. Otherwise, press 2 to continue to trainer registration: ");
        int checkCourse= sc.nextInt();
        sc.nextLine();
        if (checkCourse==1) createCourse();
        if (checkCourse==2) IndividualProject.startCreateTrainers();
    }
        
        //full or part time selection
        public static String checkType(){
            
            System.out.print("If the course is part time, please press 1. If it is full time, press 2: ");
            String t="";
            int checkPart = sc.nextInt();
            sc.nextLine();
            switch (checkPart)  {
                case 1: 
                    t = "part time";
                    break;
                case 2: 
                    t = "full time";
                    break;
                default:
                    System.out.println("Incorrect input, please try again!");
                    checkType();
                    break;
            }
            return(t);
        }
    
}
    

    
    
    