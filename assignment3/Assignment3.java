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
    public void createList(ArrayList<Employee> list){
        try{
            File employee=new File("employees.txt");
            FileReader fileReader=new FileReader(employee);
            BufferedReader br=new BufferedReader(fileReader);
            String line;
            while((line=br.readLine())!=null){
                Employee obj=new Employee();
                String[] str=line.split(",");
                obj.setName(str[0]);
                obj.setEmailId(str[1]);
                obj.setAge(Integer.parseInt(str[2]));
                obj.setDOB(str[3]);
                list.add(obj);
            }
        }
        catch ( IOException ex){
            System.out.println("IO Exception raised");
        }
    }
}