
package edu.neu.csye6200.model;

import java.util.Date;

public class Dose {
    private int doseNumber;
    private  Date date;
    
      
    public Dose(int doseNumber, Date date) {
        this.doseNumber = doseNumber;
        this.date = date;
    }

    public int getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(int doseNumber) {
        this.doseNumber = doseNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
  
    
    
    
}
