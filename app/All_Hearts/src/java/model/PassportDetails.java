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
public class PassportDetails {
    private final Employee employee;
    private final String passportNumber;
    private final DateTime expiryDate;
    
    public PassportDetails(Employee employee, String passportNumber, DateTime expiryDate){
        this.employee = employee;
        this.passportNumber = passportNumber;
        this.expiryDate = expiryDate;
    }
    
    public String getPassportNumber(){
        return passportNumber;
    }
    
    public DateTime getExpiryDate(){
        return expiryDate;
    }
    
    @Override
    public String toString(){
        String result = "";
        result += ("\nEmployee Name: " + employee.getName());
        result += ("\nEmployee NRIC: " + employee.getNric());
        return result;
    }
}
