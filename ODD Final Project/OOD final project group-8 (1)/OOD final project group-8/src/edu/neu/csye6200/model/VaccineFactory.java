
package edu.neu.csye6200.model;


public class VaccineFactory {
    
    public static final VaccineFactory instance = new VaccineFactory();
    
    public static VaccineFactory getInstance() {
        return instance;
    }
        

    public static Vaccine getObject(String csvData) {
        return new Vaccine(csvData);
    }
    
   public static Vaccine getObject(String vaccineName, 
                          String vaccineDescription,int maxDoses) {
        return new Vaccine (vaccineName,vaccineDescription,maxDoses);
    }


    
}
