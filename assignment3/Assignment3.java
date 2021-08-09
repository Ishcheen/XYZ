/*
 * Classname: Assigment3.java
 */
package assignment3;

import java.util.*;
import java.io.*;

class Employee{
    private String name;
    private String emailId;
    private int age;
    private String dateOfBirth;
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmailId(String EmailId){
        this.emailId=EmailId;
    }
    public String getEmailId(){
        return this.emailId;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return this.age;
    }
    public void setDOB(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }
    public String getDOB(){
        return this.dateOfBirth;
    } 
}