
package edu.neu.csye6200.model;

import java.util.Vector;


public class GroupFactory {
    public static final GroupFactory instance = new GroupFactory();
    
    public static GroupFactory getInstance(){
        return instance;
    }
    
    public static Group getObject(String groupName, Teacher teacher, Vector<Student> studentList,
                 int groupSize){
        return new Group(groupName, teacher, studentList, groupSize);
    }
}
