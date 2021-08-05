/*
 * Classname: Assigment5.java
 */
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Assignment5{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to Seriale operation and 2 to deserialize");
        int n=sc.nextInt();
        if(n==1){
            SerializationTest.main(args[0]);
        }
        else
        {
            DeserializationTest.main(args[0]);
        }
    }
}
class Student implements Serializable{
    private String firstName;
    private String dateOfBirth;
    private Date dOB;
    private static final long serialVersionUID=-189671429866048052L;
    Address address;
    Student(String firstName, String dateOfBirth){
        this.firstName=firstName;
        try{
            this.dOB=new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirth);
        }
        catch(ParseException ex){
            System.out.println("Parse Exception arised");
        }
        this.dateOfBirth=dateOfBirth;
    }
    public String getName(){
        return this.firstName;
    }
    public Date getDate(){
        return this.dOB;
    }
    public String getStringDate(){
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

class DeserializationTest{
    public static void main(String args){
        try{
            ObjectInputStream is=new ObjectInputStream(new FileInputStream(args));
            Student s1Restore=(Student) is.readObject();
            Student s2Restore=(Student) is.readObject();
            Student s3Restore=(Student) is.readObject();
            Student s4Restore=(Student) is.readObject();
            is.close();
            System.out.println(s1Restore.getName());
            System.out.println(s2Restore.getName());
            System.out.println(s3Restore.getName());
            System.out.println(s4Restore.getName());
        }
        catch (IOException ex){
            ex.printStackTrace();
            // System.out.println("IO Exception raised");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}