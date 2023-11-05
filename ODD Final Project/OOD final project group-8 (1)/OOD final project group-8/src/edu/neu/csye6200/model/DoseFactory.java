
package edu.neu.csye6200.model;

import java.util.Date;

public class DoseFactory {
    public static Dose getObject(int doseNumber, Date date) {
        return new Dose(doseNumber, date);
    }
}
