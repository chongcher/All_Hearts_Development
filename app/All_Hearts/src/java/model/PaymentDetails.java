/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ccchia.2014
 */
class PaymentDetails {
    private String accountType;
    private String accountNumber;
    private PaymentDetails updatedAccount;
    
    public PaymentDetails(String accountType, String accountNumber){
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.updatedAccount = null;
    }
    
    public PaymentDetails(String accountType, String accountNumber,PaymentDetails updatedAccount){
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.updatedAccount = updatedAccount;
    }
}
