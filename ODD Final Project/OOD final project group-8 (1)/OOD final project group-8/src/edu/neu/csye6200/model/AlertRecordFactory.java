
package edu.neu.csye6200.model;

public class AlertRecordFactory {
    
    public static final AlertRecords alertRecords = new AlertRecords();
    
    public static AlertRecords getInstance(){
        return alertRecords;
    }
}
