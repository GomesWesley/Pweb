/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

public class Form {
    public String receiver;
    public String telephoneReceiver;
    public String emailReceiver;
    public String sender;
    public String telephoneSender;
    public String emailSender;
    public Date date;

    public Form() {
    }

    public String getReceiver() {
        return receiver;
    }

    public String getTelephoneReceiver() {
        return telephoneReceiver;
    }

    public String getEmailReceiver() {
        return emailReceiver;
    }

    public String getSender() {
        return sender;
    }

    public String getTelephoneSender() {
        return telephoneSender;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public Date getDate() {
        return date;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setTelephoneReceiver(String telephoneReceiver) {
        this.telephoneReceiver = telephoneReceiver;
    }

    public void setEmailReceiver(String emailReceiver) {
        this.emailReceiver = emailReceiver;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setTelephoneSender(String telephoneSender) {
        this.telephoneSender = telephoneSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
