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
public class Payment {
    private PaymentDetails toAccount;
    private PaymentDetails fromAccount;
    private double paymentAmount;
    private DateTime paymentDate;
}
