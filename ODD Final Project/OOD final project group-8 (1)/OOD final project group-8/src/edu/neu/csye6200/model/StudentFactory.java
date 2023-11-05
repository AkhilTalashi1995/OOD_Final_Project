
package edu.neu.csye6200.model;

import java.util.Date;


public class StudentFactory {
    public static Student getObject(String data) {
        return new Student(data);
    }
    
    public static Student getObject(String firstName, String lastName, int age,
                         double gpa, String fatherName, String motherName,
                         String address, String phoneNumber, Date walkInDate, Date renewalDate) {
        return new Student(firstName, lastName, age, gpa, fatherName,
                            motherName, address, phoneNumber, walkInDate,renewalDate);
    }

}
