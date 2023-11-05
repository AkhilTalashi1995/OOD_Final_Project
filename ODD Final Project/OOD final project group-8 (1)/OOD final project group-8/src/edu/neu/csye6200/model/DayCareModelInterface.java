
package edu.neu.csye6200.model;


import java.util.Date;

public interface DayCareModelInterface {
    Person createPersonViaCsv(String csvData);
    Person createStudentViaForm(String firstName, String lastName,int age, 
                              double gpa,String fatherName, String motherName,
                              String address,String phoneNumber, Date walkInDate, Date renewalDate);
    Person createTeacherViaForm(String firstName, String lastName, int age, 
                              int credits, Date reviewDate);
    Vaccine addImmunizationRecordViaForm( String vaccineName, 
                               String vaccineDescription,int maxDoses);
    
    Vaccine addImmunizationRecordViaCsv(String csvData);
    
    
    
    
    
    
    
}
