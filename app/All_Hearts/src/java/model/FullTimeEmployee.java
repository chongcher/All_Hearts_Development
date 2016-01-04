/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.joda.time.DateTime;

/**
 *
 * @author ccchia.2014
 */
public class FullTimeEmployee extends Employee{
    private DateTime startDate;
    private DateTime endDate;
    private double currentPay;
    
    public FullTimeEmployee(String nric, String name, DateTime birthday){
        super(nric, name, birthday);
    }
}
