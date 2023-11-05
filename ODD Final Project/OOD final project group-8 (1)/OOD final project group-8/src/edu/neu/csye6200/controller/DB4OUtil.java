/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controller;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import edu.neu.csye6200.model.DayCare;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.User;
import java.nio.file.Paths;
import java.util.Vector;



public class DB4OUtil {

    private static final String FILENAME = Paths.get("Databank.db4o").toAbsolutePath().toString();// path to the data store
    private static  DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);
            config.common().objectClass(DayCare.class).cascadeOnUpdate(true); // Change to the object you want to save
            ObjectSet<User> userList = db.query(User.class);
            if(null == userList || userList.isEmpty()){
                db.store(new User("admin" , "admin"));
                db.store(new User("admin1" , "admin1"));
                db.store(new User("admin2" , "admin2"));
            }else {
               
            }
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(DayCare dayCare) {
        ObjectContainer conn = createConnection();
        conn.store(dayCare);
        conn.commit();
        conn.close();
    }
    
    public synchronized void updateStudentList(Vector<Student> studentList){
        ObjectContainer conn = createConnection();
        ObjectSet<DayCare> dayCareObjects = conn.query(DayCare.class); // Change to the object you want to save
        DayCare dayCare;
        if (!dayCareObjects.isEmpty()) {            
            dayCare = dayCareObjects.get(dayCareObjects.size() - 1);
            dayCare.setStudentsList(studentList);
            conn.store(dayCare);
            conn.commit();
        }
        conn.close();
    }
    
    public DayCare retrieveSystem(){
        ObjectContainer conn = createConnection();
        ObjectSet<DayCare> dayCareObjects = conn.query(DayCare.class); // Change to the object you want to save
        DayCare dayCare;
        if (dayCareObjects.isEmpty()) {
            
            dayCare = ConfigureDayCare.configure();  // If there's no System in the record, create a new one
        } else {
            
            dayCare = dayCareObjects.get(dayCareObjects.size() - 1);
        }
        conn.close();
        return dayCare;
    }
    
    public DayCare retrieveSystemByAdmin(String userName){
        ObjectContainer conn = createConnection();
        ObjectSet<DayCare> dayCareObjects = conn.query(DayCare.class); // Change to the object you want to save
        DayCare dayCare = null;
        if (dayCareObjects.isEmpty()) {
            
        } else {
            for (DayCare dayCareObject : dayCareObjects) {
                if(null !=  dayCareObject.getCreatedBy() && dayCareObject.getCreatedBy().equals(userName)){
                    dayCare = dayCareObject;
                }
            }
        }
        conn.close();
        return dayCare;
    }
    
    public User retrieveUserByUsername(String userName){
        ObjectContainer conn = createConnection();
        ObjectSet<User> userObjects = conn.query(User.class); // Change to the object you want to save
        User user = null;
        if (userObjects.isEmpty()) {
            
        } else {
            for (User user1 : userObjects) {
                if(null !=  user1.getUserName()&& user1.getUserName().equals(userName)){
                    user = user1;
                }
            }
        }
        conn.close();
        return user;
    }
    
    public synchronized void updateTeacherList(Vector<Teacher> teacherList){
        ObjectContainer conn = createConnection();
        ObjectSet<DayCare> dayCareObjects = conn.query(DayCare.class); // Change to the object you want to save
        DayCare dayCare;
        if (!dayCareObjects.isEmpty()) {            
            dayCare = dayCareObjects.get(dayCareObjects.size() - 1);
            dayCare.setTeachersList(teacherList);
            conn.store(dayCare);
            conn.commit();
        }
        conn.close();
    }
}
