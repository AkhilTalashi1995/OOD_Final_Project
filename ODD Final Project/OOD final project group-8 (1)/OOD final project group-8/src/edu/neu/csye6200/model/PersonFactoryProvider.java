
package edu.neu.csye6200.model;


public class PersonFactoryProvider {
    public static PersonFactory getFactory(String choice) {
        if ("Person".equalsIgnoreCase(choice)) {
            return new PersonFactory();
        }
        else {
            return null;
        }
    }
    
}
