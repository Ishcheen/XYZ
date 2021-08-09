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
    public void createFile(ArrayList<Employee> list){
        try{
            BufferedWriter writer= new BufferedWriter(new FileWriter("employees.txt"));
            for(Employee obj:list){
                writer.write(obj.getName()+","+obj.getEmailId()+","+obj.getAge()+","+obj.getDOB()+"\n");
            }
            writer.close();
        }
        catch ( IOException ex){
            System.out.println("IO Exception raised");
        }
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
    public void addEmployee(ArrayList<Employee> list){
        Employee obj =new Employee();
        System.out.println("Please provide the following information for the employee:");
        System.out.println("Name: ");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        obj.setName(name);
        System.out.println("Email Address: ");
        String emailId=sc.nextLine();
        obj.setEmailId(emailId);
        System.out.println("Age: ");
        int age=sc.nextInt();
        obj.setAge(age);
        sc.nextLine();
        System.out.println("Date of Birth: ");
        String dob=sc.nextLine();
        obj.setDOB(dob);
        list.add(obj);
        createFile(list);
    }
    public void delete(ArrayList<Employee> list){
        System.out.println("Enter the employee ID/name to delete: ");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        for(Employee i: list){
            if(i.getName().equals(s)){
                list.remove(i);
                createFile(list);
                break;
            }
        }
    }
}