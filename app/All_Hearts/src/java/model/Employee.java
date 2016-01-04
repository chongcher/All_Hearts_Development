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
    
    private DateTime birthday;
    private String citizenship;
    private String contactNumber;
    private String email;
    private String name;
    private String nickname;
    private String nric;
    private PassportDetails passportDetails;
    private PaymentDetails paymentDetail;
    private boolean registeredWithMOE;
    private LinkedHashMap<String,DateTime> skills;

    Employee(String nric, String name, DateTime birthday){
        this.nric = nric;
        this.name = name;
        this.birthday = birthday;
        citizenship = "";
        nickname = "";
        email = "";
        contactNumber = "";
        passportDetails = null;
        registeredWithMOE = false;
        paymentDetail = null;
        skills = null;
    }
    
    String getName() {
        return name;
    }

    String getNickname() {
        return nickname;
    }

    String getNric() {
        return nric;
    }

    String getCitizenship() {
        return citizenship;
    }

    PassportDetails getPassportDetails() {
        return passportDetails;
    }

    String getContactNumber() {
        return contactNumber;
    }

    DateTime getBirthday() {
        return birthday;
    }

    boolean isRegisteredWithMOE() {
        return registeredWithMOE;
    }

    String getEmail() {
        return email;
    }

    PaymentDetails getPaymentDetail() {
        return paymentDetail;
    }

    LinkedHashMap<String, DateTime> getSkills() {
        return skills;
    }

    void setNickname(String nickname) {
        this.nickname = nickname;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    void setPassportDetails(PassportDetails passportDetails) {
        this.passportDetails = passportDetails;
    }

    void setRegisteredWithMOE(boolean registeredWithMOE) {
        this.registeredWithMOE = registeredWithMOE;
    }

    void setPaymentDetail(PaymentDetails paymentDetail) {
        this.paymentDetail = paymentDetail;
    }
    
}
