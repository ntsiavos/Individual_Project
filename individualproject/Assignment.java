/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import static individualproject.IndividualProject.sc;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ntsia
 */
public class Assignment {
    
    private String title;
    private String description;
    private LocalDate subDateTIme;
    private int oralMark;
    private int finalMark;
    

    public Assignment() {
    }

    public Assignment(String title, LocalDate subDateTIme) {
        this.title = title;
        this.subDateTIme = subDateTIme;
    }
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTIme() {
        return subDateTIme;
    }

    public void setSubDateTIme(LocalDate subDateTIme) {
        this.subDateTIme = subDateTIme;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }

    @Override
    public String toString() {
        return "Assignment{" + "title=" + title + ", subDateTIme=" + subDateTIme + '}';
    }

   //Create an assignment and add it to the ArrayList. Then we return it to be added to the courseAssignment list.
    public static Assignment createAssignment(){
        System.out.print("Please enter the title of the assignment: ");
        String t = sc.nextLine();
        System.out.print("Please enter the submission date of the assignment (dd/mm/yyyy): ");
        String s = sc.next();
        sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate subDateTime = LocalDate.parse(s, formatter);
        Assignment as = new Assignment(t, subDateTime);
        IndividualProject.assignments.add(as);
        return(as);
        }
    
   
    //checking if a date falls within a week with assignments and then printing the students who have deadlines during that week
    public static void calculateAssignmentWeek(){
        //try-catch for wrong date input, it happened a lot during testing!
        try{
            System.out.print("Please enter a date (dd/mm/yyyy): ");
            String s = sc.next();
            

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dueDate = LocalDate.parse(s, formatter);
            
            //calculating due week, Monday to Friday
            LocalDate dueMonday = Assignment.dueMonday(dueDate);
            LocalDate dueFriday = Assignment.dueFriday(dueDate);
            System.out.println("");
            System.out.println("List of students with deadlines from " +dueMonday+ " to " +dueFriday);
            //Set of students with due assignments, to avoid duplicates
            Set<Student> dueStudents = new HashSet();
            for (Course course : IndividualProject.courses) {
                for (Assignment assignment : course.getCourseAssignments()) {
                    if ((!assignment.getSubDateTIme().isBefore(dueMonday)) && (!assignment.getSubDateTIme().isAfter(dueFriday))){
                        for (Student student : course.getCourseStudents()) {
                            dueStudents.add(student);
                        }
                    }
                }
                
            }
            int dueStuCounter = 1;
            for (Student student : dueStudents) {
                    System.out.println(dueStuCounter+ ". " +student.getFname()+ " " +student.getLname());
                    dueStuCounter++;
                }
    }catch (DateTimeParseException e){
                System.out.println("Incorrect input, please try again!");
                calculateAssignmentWeek();
            }
    }
    //finding the Monday of assignments week    
    public static LocalDate dueMonday(LocalDate l){
        int dueInt = l.getDayOfWeek().getValue();
        
        if (dueInt>1){
           dueInt = (dueInt-1);
           l = l.minusDays(dueInt);
        }
        return(l);
    }
    //finding the Friday of assignments week
    public static LocalDate dueFriday(LocalDate l){
        
        int dueInt = l.getDayOfWeek().getValue();
        int counterFriday=0;
        if (dueInt>5){
            while (dueInt>5){
            counterFriday++;
            dueInt = dueInt-counterFriday;
            }
        l = l.minusDays(counterFriday);
        }
        else if (dueInt<5){
            while (dueInt<5){
            counterFriday++;
            dueInt = dueInt+counterFriday;
            }
         l = l.plusDays(counterFriday);   
        }           
        return(l);
    }
    
}
