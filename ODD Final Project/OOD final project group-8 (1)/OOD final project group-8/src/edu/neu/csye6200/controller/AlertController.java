/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Alert;
import edu.neu.csye6200.model.AlertRecordFactory;
import edu.neu.csye6200.model.AlertRecords;
import edu.neu.csye6200.model.DayCare;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.Vaccine;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;


public class AlertController implements Predicate<Date>{
    public static long dateOffset = (365 * 24 * 60 * 60 * 1000);
    static AlertController alertPredicate = new AlertController();
    public static void generateTeacherAlerts(Vector<Teacher> teachers){
        AlertRecords a = AlertRecordFactory.getInstance();
        teachers.forEach((t) -> { 
            if(alertPredicate.test(t.getReviewDate())){
                String des = "Teacher: "+t.getFirstName()+" "+t.getLastName()+"'s review is pending." + " Last Review date was on "+t.getReviewDate();
                Alert alert = new Alert(des);
                a.getAlerts().add(alert);
            }
        });
    }
    
    
    public static void generateStudentAlerts(Vector<Student> studentsList){
        AlertRecords a = AlertRecordFactory.getInstance();
        studentsList.forEach((student) -> { 

            if(alertPredicate.test(student.getWalkInDate())){
                String des = "Student: "+student.getFirstName()+" "+student.getLastName()+"'s review is pending." + " Last walk in date was on "+student.getWalkInDate();
                Alert alert = new Alert(des);
                a.getAlerts().add(alert);
            }
            for (Vaccine vaccine :student.getVaccineList())
            {
                if(vaccine.getDoseDetails().size() < vaccine.getMaxDoses())
                {
                    Date date = vaccine.getLatestImmunizationDate();
                    if(isTwoMonthsAgo(date))
                    {
                        String des = "Student: "+student.getFirstName()+" "+student.getLastName()+" is due for "+ vaccine.getVaccineName() +" vaccine.";
                        Alert alert = new Alert(des);
                        a.getAlerts().add(alert);
                    }    
                }    
            }
         });
    }
    
    @Override
    public boolean test(Date inputDate) 
    {
         Date d = new Date();// Get "now".
        long dLong = d.getTime();
        long diffInMillies = Math.abs(d.getTime() - inputDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff>365;
    }
    
    public static boolean isTwoMonthsAgo(Date inputDate){
        Date d = new Date();// Get "now".
        long dLong = d.getTime();
        long diffInMillies = 0;
        if(null != inputDate)
            diffInMillies = Math.abs(d.getTime() - inputDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diff>60;
    }
    
    public static void generateAllALerts(DayCare dayCare)
    {
        AlertRecords a = AlertRecordFactory.getInstance();
        a.clearRecords();
        generateTeacherAlerts(dayCare.getTeachersList());
        generateStudentAlerts(dayCare.getStudentsList());
    }
}
