
package edu.neu.csye6200.model;

import java.util.Vector;


public class AlertRecords {
    private Vector<Alert> alerts = new Vector<>();
    
    public AlertRecords(){
        
    }
    
    public Vector<Alert> getAlerts(){
        return alerts;
    }
    
    public void clearRecords()
    {
         alerts = new Vector<>();
    }
    
}
