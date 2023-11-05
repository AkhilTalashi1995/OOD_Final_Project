package edu.neu.csye6200.model;


import java.util.Vector;


public class DayCare {
    
    
    String dayCareName;
    String createdBy;
    Vector<Student> studentsList;
    Vector<Teacher> teachersList;
    Vector<Classroom> classRoomsList ;
    
    
     
     
    
    public DayCare(String name)
    {
        this.dayCareName = name;
        studentsList = new Vector<>();
        teachersList = new Vector<>();
        classRoomsList = new Vector<>();
      
    }
     
    public DayCare()
    {
        
        studentsList = new Vector<>();
        teachersList = new Vector<>();
        classRoomsList = new Vector<>();
      
    }
    
    public DayCare configure(String name)
    {
        return null;
    }

    public Vector
        <Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(Vector<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public Vector<Teacher> getTeachersList() {
        return teachersList;
    }

    public void setTeachersList(Vector<Teacher> teachersList) {
        this.teachersList = teachersList;
    }

    public Vector<Classroom> getClassRoomsList() {
        return classRoomsList;
    }

    public void setClassRoomsList(Vector<Classroom> classRoomsList) {
        this.classRoomsList = classRoomsList;
    }
    
    public String getDayCareName(){
        return this.dayCareName;
    }
    
    public void setDayCareName(String dayCareName){
        this.dayCareName = dayCareName;
    }
    
    public String getCreatedBy(){
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    
   
}
