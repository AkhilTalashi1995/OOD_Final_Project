package edu.neu.csye6200.model;

public class DayCareFactory {

    private static DayCare dayCare;
    
    public static DayCare getInstance() {
        if(dayCare==null) {
            dayCare=new DayCare();
        }
        return dayCare;
    }
    
    public static DayCare getInstance(String name)
     {
        if(dayCare==null)
        {
            dayCare=new DayCare(name);
        }
        return dayCare;
    }
}
