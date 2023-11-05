
package edu.neu.csye6200.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DayCareModel implements DayCareModelInterface{
    
    @Override
    public Person createPersonViaCsv(String csvData) {
        String [] temp = csvData.split(",");
        int tempAge = Integer.parseInt(temp[2]);
        if (tempAge >360) {
            return TeacherFactory.getObject(csvData);
        }
            return StudentFactory.getObject(csvData);  
    }

    @Override
    public Person createStudentViaForm(String firstName, String lastName, 
                                     int age, double gpa, String fatherName, 
                                     String motherName, String address, 
                                     String phoneNumber, Date walkInDate, Date renewalDate) {
        return StudentFactory.getObject(firstName,lastName, age, gpa,
                        fatherName,motherName, address, phoneNumber,walkInDate,renewalDate);
    }

    public Person createTeacherViaForm(String firstName, String lastName, 
                                     int age, int credits, 
                                     Date reviewDate, String review) {
        return TeacherFactory.getObject(firstName,lastName, age, credits, reviewDate, review);
    }

    @Override
    public Vaccine addImmunizationRecordViaForm(String vaccineName,
                                             String vaccineDescription, 
                                             int maxDoses) {
        return VaccineFactory.getInstance().getObject( vaccineName, vaccineDescription, 
                                 maxDoses);    
    }

    @Override
    public Vaccine addImmunizationRecordViaCsv(String csvData) {
        return VaccineFactory.getInstance().getObject(csvData);
    }   

    @Override
    public Person createTeacherViaForm(String firstName, String lastName, int age, int credits, Date reviewDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
