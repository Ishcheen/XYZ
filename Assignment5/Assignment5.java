/*
 * Classname: Assigment5.java
 */
import java.util.*;
import java.io.*;

public class Assignment5{
    public static void main(String[] args){
        SerializationTest st=new SerializationTest();
        st.main(args[0]);
    }
}
class Student implements Serializable{
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

class Address implements Serializable{
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

class SerializationTest{
    public static void main(String arg1){
        Student s1=new Student("Ishita", "31-10-1999");
        s1.address=new Address("Indore", "MP", 452030, "India");
        Student s2=new Student("Jack", "31-07-2000");
        s2.address=new Address("Bhopal", "MP", 472030, "India");
        Student s3=new Student("Oliver", "20-01-1990");
        s3.address=new Address("Jaipur", "Rajasthan", 422030, "India");
        Student s4=new Student("Shinchan", "05-03-2010");
        s4.address=new Address("Mumbai", "Maharastra", 462001, "India");
        try{
            FileOutputStream fs=new FileOutputStream(arg1);
            ObjectOutputStream os= new ObjectOutputStream(fs);
            os.writeObject(s1);
            os.writeObject(s2);
            os.writeObject(s3);
            os.writeObject(s4);
            os.close();
        }catch (IOException ex){
            System.out.println("IO Exception raised");
        }
        s1=null;
        s2=null;
        s3=null;
        s4=null;
    }
}