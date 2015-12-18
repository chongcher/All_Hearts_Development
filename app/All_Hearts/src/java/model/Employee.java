/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedHashMap;
import org.joda.time.DateTime;

/**
 *
 * @author ccchia.2014
 */
class Employee {
    
    private String nric;
    private String name;
    private String nickname;
    private String citizenship;
    private DateTime birthday;
    private String email;
    private String contactNumber;
    private PassportDetails passportDetails;
    private boolean registeredWithMOE;
    private PaymentDetails paymentDetail;
    private LinkedHashMap<String,DateTime> skills;

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNric() {
        return nric;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public PassportDetails getPassportDetails() {
        return passportDetails;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public boolean isRegisteredWithMOE() {
        return registeredWithMOE;
    }

    public String getEmail() {
        return email;
    }

    public PaymentDetails getPaymentDetail() {
        return paymentDetail;
    }

    public LinkedHashMap<String, DateTime> getSkills() {
        return skills;
    }
    
    
    
}
