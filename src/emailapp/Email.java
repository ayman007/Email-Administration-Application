/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;

import java.util.Scanner;

/**
 *
 * @author AYMAN
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity=500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix="ammcompany.com";
    
    //Constructor to receive the first name and last name
    public Email(String firstName , String lastName){
    this.firstName=firstName;
    this.lastName=lastName;
    
    //Call a method asking for the department - return the department
    this.department=setDepartment();
    
    
    //Call a method that returns a random password
    this.password=randomPassword(defaultPasswordLength);
    System.out.println("Your Password : "+this.password);
    
    //Combine elements to generate Email
    email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
       
        
    }
   //Asking for department
    private String setDepartment(){
        System.out.println("Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the Department: ");
        Scanner in = new Scanner(System.in);
        int depChoice= in.nextInt();
        switch (depChoice) {
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    
    }
    //Generate a random password
    private String randomPassword(int length){
    String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
    char[] password=new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int)(Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
    return new String(password);
    }
    
    //Set mailbox Capacity
    public void setMailboxCapacity(int capacity){
    this.mailboxCapacity=capacity;
    
    }
    //Set the alternate Email
    public void setAlternateEmail(String altEmail){
    this.alternateEmail=altEmail;
    
    }
    //Change the Password
    public void changePassword(String password){
    this.password=password;
    
    }
    //Get mailbox Capacity
    public int getMailboxCapacity(){return mailboxCapacity;}
    //Get the alternate Email
    public String getAlternateEmail(){return alternateEmail;}
    //Get the password
    public String getPassword(){return password;}
    //Show information
    public String showInfo(){
    return "Display Name : "+firstName+" "+lastName+
            "\nCompany Email : "+email+
            "\nMailBox Capacity : "+mailboxCapacity+"mb";
    
    }
}
