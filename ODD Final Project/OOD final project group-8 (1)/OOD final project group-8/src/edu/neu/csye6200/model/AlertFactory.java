
package edu.neu.csye6200.model;


public class AlertFactory {
    public static Alert getObject(String description) {
        return new Alert(description);
    }
}
