
package edu.neu.csye6200.model;

public class ClassRoomFactory {
    public static Classroom getObject(int ageLower, int ageHigher, int maxGroup, String name) {
        return new Classroom(ageLower, ageHigher, maxGroup, name);
    }
}
