
package edu.neu.csye6200.model;

import java.util.Date;

public class TeacherFactory {
    public static Teacher getObject(String data) {
        return new Teacher(data);
    }
    public static Teacher getObject(String firstName, String lastName, int age,
                         int credits, Date reviewDate, String review) {
        return new Teacher(firstName, lastName, age, credits, reviewDate, review);
    }
}
