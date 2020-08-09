/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author ntsia
 */
public class IndividualProject {
    static Scanner sc = new Scanner(System.in);
    static List <Course> courses = new ArrayList();
    static List<Assignment>assignments = new ArrayList();
    static List<Trainer> trainers = new ArrayList();
    static List<Student> students = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                        
        welcome();
    }
    
    //greeting and choice between user input or default data
    public static void welcome(){
        System.out.print("Welcome to the Java Island University! Please press 1 to register a new semester or press 2 to use our default data: ");
        int checkData = sc.nextInt();
        sc.nextLine();
        switch (checkData) {
            case 1:
                startDataEntry();
                break;
            case 2:
                defaultData();
                break;
            default:
                System.out.println("Incorrect input, please try again!");
                welcome();
                break;
        }
        
        } 
    
    //default data process
    public static void defaultData(){
        System.out.println("Loading data, please wait");
        System.out.println("*********************");
        //creating courses
        Course c1 = new Course("Java 101", "Programming", "full time", LocalDate.of(2020, 9, 1), LocalDate.of(2020, 11, 30));
        Course c2 = new Course("Intro to PHP", "Programming", "part time", LocalDate.of(2020, 10, 1), LocalDate.of(2020, 12, 30));
        Course c3 = new Course("MySQL and I", "Programming", "full time", LocalDate.of(2020, 9, 15), LocalDate.of(2021, 1, 15));
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        
        //creating assignments
        Assignment a1 = new Assignment("Using Methods", LocalDate.of(2020, 9, 18));
        Assignment a2 = new Assignment("Create FB lite", LocalDate.of(2020, 10, 6));
        Assignment a3 = new Assignment("Rebuilding WWW", LocalDate.of(2020, 11, 17));
        Assignment a4 = new Assignment("Using MyAdmin", LocalDate.of(2020, 10, 12));
        Assignment a5 = new Assignment("Connect Amazon and Google DBs", LocalDate.of(2020, 11, 19));
        Assignment a6 = new Assignment("One DB to rule them all", LocalDate.of(2020, 9, 23));
        
        assignments.add(a1);
        assignments.add(a2);
        assignments.add(a3);
        assignments.add(a4);
        assignments.add(a5);
        assignments.add(a6);
        
        //adding assignments to courses
        c1.getCourseAssignments().add(a1);
        c1.getCourseAssignments().add(a2);
        c1.getCourseAssignments().add(a3);
        c2.getCourseAssignments().add(a4);
        c2.getCourseAssignments().add(a5);
        c3.getCourseAssignments().add(a6);
        
        //creating trainers
        Trainer t1 = new Trainer("Nikolaos", "Tsiavos", "How to be a noob");
        Trainer t2 = new Trainer("Mpampis", "Osougias", "Programming Hacks");
        Trainer t3 = new Trainer("Nikos", "Petaloudas", "Learning programming on the fly");
        Trainer t4 = new Trainer("Vasiliki", "Delizisi", "How to be awesome");
        
        trainers.add(t1);
        trainers.add(t2);
        trainers.add(t3);
        trainers.add(t4);
        
        //assigning to courses
        c1.getCourseTrainers().add(t1);
        c1.getCourseTrainers().add(t4);
        c2.getCourseTrainers().add(t2);
        c2.getCourseTrainers().add(t4);
        c3.getCourseTrainers().add(t3);
        c3.getCourseTrainers().add(t4);
        
        //creating students
        Student st1 = new Student("Thalia", "Tsiavou");
        Student st2 = new Student("Eleutherios", "Tsiavos");
        Student st3 = new Student("Thanasis", "Delizisis");
        Student st4 = new Student("Thodoros", "Markos");
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        
        //adding them to courses
        c1.getCourseStudents().add(st1);
        c1.getCourseStudents().add(st2);
        c1.getCourseStudents().add(st3);
        c1.getCourseStudents().add(st4);
        
        c2.getCourseStudents().add(st1);
        c2.getCourseStudents().add(st2);
        c2.getCourseStudents().add(st4);
        
        c3.getCourseStudents().add(st1);
        c3.getCourseStudents().add(st4);
        
        //adding courses to students
        st1.getCourses().add(c1);
        st1.getCourses().add(c2);
        st1.getCourses().add(c3);
        
        st2.getCourses().add(c1);
        st2.getCourses().add(c2);
        
        st3.getCourses().add(c1);
        
        st4.getCourses().add(c1);
        st4.getCourses().add(c2);
        st4.getCourses().add(c3);
        
        System.out.println("Loading complete");
        
        finalMenu();
    }
    
    //First user input method, start with courses. We could merge this and createCourse but I am keeping it seperate in case we want to add more later on the project
    public static void startDataEntry(){
        System.out.println("*********************");
        System.out.println("Course registration section.");
        Course.createCourse();
        
    }
      
    //Start Trainer section
    public static void startCreateTrainers(){
      System.out.println("**********************");
      System.out.println("Trainer registration section.");
      Trainer.createTrainer();
    }
    
    //Start Student section
    public static void startCreateStudents(){
      System.out.println("**********************");
      System.out.println("Student registration section.");
      Student.createStudent();
    }
    
    //The options menu after data has been generated
    public static void finalMenu(){
    System.out.println("**********************");
    System.out.println("Welcome to the main menu");
    System.out.println("1. Print all students");
    System.out.println("2. Print all trainers");
    System.out.println("3. Print all assignments");
    System.out.println("4. Print all courses");
    System.out.println("5. Print all students per course");
    System.out.println("6. Print all trainers per course");
    System.out.println("7. Print all assignments per course");
    System.out.println("8. Print all assignments per student");
    System.out.println("9. Print all students registered to multiple courses");
    System.out.println("10. Print all students with due assignments on a specific week");
    System.out.println("11. Close this program. Attention, all user-registered data will be lost!");
    System.out.println("");
    System.out.print("Please select one of the options above (1-11): ");
    
    //try-catch for non-int user input
    try{
    int option = sc.nextInt();
    
    switch (option){
        case 1:
            System.out.println("**********************");
            System.out.println("");
            System.out.println("List of students");
            int studentCounter =1;
            for (Student student : students) {
                System.out.println(studentCounter+ ". " +student.getFname()+ " " +student.getLname());
                studentCounter++;
            }
            System.out.println("");
            finalMenu();
            break;
        case 2:
             System.out.println("**********************");
             System.out.println("");
            System.out.println("List of trainers");
            int trainerCounter =1;
            for (Trainer trainer : trainers) {
                System.out.println(trainerCounter+ ". " +trainer.getfName()+ " " +trainer.getlName());
                trainerCounter++;
            }
            System.out.println("");
            finalMenu();
            break;
        case 3:
            System.out.println("**********************");
            System.out.println("");
            System.out.println("List of assignments");
            int assignCounter = 1;
            for (Assignment assignment : assignments) {
                System.out.println(assignCounter+ ". " +assignment.getTitle()+", due date: " +assignment.getSubDateTIme());
                assignCounter++;
            }
            
            System.out.println("");
            finalMenu();
            break;
        case 4:
            System.out.println("**********************");
            System.out.println("");
            System.out.println("List of courses");
            int courseCounter = 1;
            for (Course course : courses) {
                System.out.println(courseCounter+ ". " +course.getTitle());
                courseCounter++;
            }
            
            System.out.println("");
            finalMenu();
            break;
        case 5:
            System.out.println("**********************");
            System.out.println("");
            System.out.println("List of students per course");
            for (Course course : courses) {
                System.out.println(course.getTitle()+ ": ");
                System.out.println("--------------------");
                int counter = 1;
                for (Student student : course.getCourseStudents()) {
                    System.out.println(counter+ ". " +student.getFname()+ " " +student.getLname());
                    counter++;
                }
                System.out.println("");
            }
            
            System.out.println("");
            finalMenu();
            break;
        case 6:
            System.out.println("**********************");
            System.out.println("");
            System.out.println("List of trainers per course");
                for (Course course : courses) {
                System.out.println(course.getTitle()+ ": ");
                System.out.println("--------------------");
                int counter = 1;
                for (Trainer trainer : course.getCourseTrainers()) {
                    System.out.println(counter+ ". " +trainer.getfName()+ " " +trainer.getlName());
                    counter++;
                }
                System.out.println("");
            }
                
            System.out.println("");
            finalMenu();
            break;
        case 7:
            System.out.println("**********************");
            System.out.println("");
            System.out.println("List of assignments per course");
            for (Course course : courses) {
                System.out.println(course.getTitle()+": ");
                System.out.println("--------------------");
                int counter =1;
                for (Assignment assignment : course.getCourseAssignments()) {
                    System.out.println(counter+ ". " +assignment.getTitle());
                    counter++;
                }
                System.out.println("");
            }
            
            System.out.println("");
            finalMenu();
            break;
        case 8:
            System.out.println("**********************");
            System.out.println("");
            System.out.println("List of assignments per student");
            for (Student student : students) {
                System.out.println(student.getFname()+" " +student.getLname()+ ": ");
                System.out.println("--------------------");
                int counter=1;
                for (Course course : student.getCourses()) {
                    for (Assignment assignment: course.getCourseAssignments()){
                        System.out.println(counter+ ". " +assignment.getTitle());
                        counter++;
                    }
                        
                }
                System.out.println("");
            }
            
            System.out.println("");
            finalMenu();
            break;
        case 9:
            System.out.println("**********************");
            System.out.println("");
            System.out.println("List of students registered to multiple courses");
            int multiCounter = 1;
            for (Student student : students) {
                if (student.getCourses().size()>1){
                    System.out.println(multiCounter+ ". " +student.getFname()+ " " +student.getLname());
                    multiCounter++;
                }
            } 
            
            System.out.println("");
            finalMenu();
            break;
        case 10:
            Assignment.calculateAssignmentWeek();
            finalMenu();
            break;
        case 11:
            System.exit(0);
        default:
            System.out.println("Wrond input, please try again!");
            System.out.println("");
            finalMenu();
        break;
        
    
        }

    }catch(InputMismatchException e){
        System.out.println("Incorrect input, please try again!");
        sc.next();
        finalMenu();
        }
    }

}


