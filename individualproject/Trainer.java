/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualproject;

import static individualproject.IndividualProject.sc;

/**
 *
 * @author ntsia
 */
public class Trainer {
   
    private String fName;
    private String lName;
    private String subject;
   

    public Trainer() {
    }

    public Trainer(String fName, String lName, String subject) {
        this.fName = fName;
        this.lName = lName;
        this.subject = subject;
    }
    
     
     
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Trainer{" + "fName=" + fName + ", lName=" + lName + ", subject=" + subject + '}';
    }
    
    //Create a trainer and add him/her to the trainer list. It checks for each course and adds the trainer to the courseTrainer list if necessary
    public static void createTrainer(){
        System.out.println("Please enter the first name of the trainer: ");
        String fname = sc.nextLine();
        System.out.println("Please enter the last name of the trainer: ");
        String lname = sc.nextLine();
        System.out.println("Please enter the teaching subject of the trainer: ");
        String subject = sc.nextLine();
        Trainer tr = new Trainer(fname, lname, subject);
        for (Course course : IndividualProject.courses) {
            System.out.println("Does " +tr.getfName()+" "+tr.getlName()+ " teach " +course.getTitle()+ "? (y/n): ");
            String checkTrainer = sc.next();
            if (checkTrainer.equals("y")) course.getCourseTrainers().add(tr);
        }
        IndividualProject.trainers.add(tr);
        System.out.println("If you would like to register another trainer, please press 1. Otherwise, press 2 to proceed to student registration: ");
        int trainersCheck = sc.nextInt();
        sc.nextLine();
        if (trainersCheck==1) createTrainer();
        IndividualProject.startCreateStudents();
                
    }
}
