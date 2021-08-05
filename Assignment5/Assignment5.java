/*
 * Classname: Assigment5.java
 */
import java.util.*;
import java.io.*;

public class Assignment5{
    public static void main(String[] args){
        Student s1=new Student("Ishita", "31-10-1999");
        s1.address=new Address("Indore", "MP", 452030, "India");
    }
}
class Student{
    private String firstName;
    private String dateOfBirth;
    Address address;
    Student(String firstName, String dateOfBirth){
        this.firstName=firstName;
        this.dateOfBirth=dateOfBirth;
    }
    public String getName(){
        return this.firstName;
    }
    public String getDOB(){
        return this.dateOfBirth;
    }
}

class Address{
    private String city;
    private String state;
    private int pinCode;
    private String country;
    Address(String city, String state, int pinCode, String country){
        this.city=city;
        this.state=state;
        this.pinCode=pinCode;
        this.country=country;
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public int getPinCode(){
        return this.pinCode;
    }
    public String getCountry(){
        return this.country;
    }
}