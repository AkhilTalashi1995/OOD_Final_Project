/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.DayCare;
import edu.neu.csye6200.model.DayCareFactory;


public class ConfigureDayCare 
{
    
    public static DayCare configure()
    {
        DayCare dayCare = DayCareFactory.getInstance();
        return dayCare;
    }
    
    public static DayCare configure(String name)
    {
        DayCare dayCare = DayCareFactory.getInstance(name);
        return dayCare;
    }
    
}
