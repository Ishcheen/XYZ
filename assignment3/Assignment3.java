/*
 * Classname: Assigment3.java
 */
package assignment3;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Assignment3{
    
    public static void main(String[] args){
        ArrayList<Employee> list=new ArrayList<Employee>();
        Employee temp=new Employee();
        temp.createList(list);
        System.out.println("Enter index of the operation to be performed:"
                            +"\n"+"1. Add"+"\n"+"2. Delete"+"\n"+"3. Search");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==1){
            temp.addEmployee(list);
        }
        else if(n==2){
            temp.delete(list);
        }
        else
        {
            temp.search(list);
        }
    }
}

class Employee{
    private String name;
    private String emailId;
    private int age;
    private Date dateOfBirth;
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
        try{
            this.dateOfBirth=new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirth);
        }
        catch(ParseException ex){
            System.out.println("Parse Exception arised");
        }
    }
    public Date getDOB(){
        return this.dateOfBirth;
    } 
     public void compare(int x, int y,ArrayList<Employee> list){
        if(x==1){
            if(y==1){
                Collections.sort(list, new SortByName());
            }
            else
            {
                Comparator c = Collections.reverseOrder(new SortByName());
                Collections.sort(list,c);
            }
        }
        else if(x==2){
            if(y==1){
                Collections.sort(list, new SortByEmailId());
            }
            else
            {
                Comparator c = Collections.reverseOrder(new SortByEmailId());
                Collections.sort(list,c);
            }
        }
        else if(x==3){
            if(y==1){
                Collections.sort(list, new SortByAge());
            }
            else
            {
                Comparator c = Collections.reverseOrder(new SortByAge());
                Collections.sort(list,c);
            }
        }
        else if(x==4){
            if(y==1){
                Collections.sort(list, new SortByDOB());
            }
            else
            {
                Comparator c = Collections.reverseOrder(new SortByDOB());
                Collections.sort(list,c);
            }
        }
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
    public void search(ArrayList<Employee> list){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the index of the query to be displayed from the following options: "
                            +"\n"+"1. Name"+"\n"+"2. Email Id"+"\n"+"3. Age"+"\n"+"4. Date of Birth");
        int x=Integer.parseInt(sc.nextLine());
        System.out.println("Property to sort by: "+"\n"+"1. Name"+"\n"+"2. Email Id"+"\n"
                            +"3. Age"+"\n"+"4. Date of Birth");
        int y=Integer.parseInt(sc.nextLine());
        System.out.println("Direction: Enter 1 for ascending and 2 for descending:");
        int z=Integer.parseInt(sc.nextLine());
        this.compare(y,z,list);
        createFile(list);
        switch(x){
            case 1:
                for(Employee i:list){
                    System.out.println(i.getName());
                }
                break;
            case 2:
                for(Employee i:list){
                    System.out.println(i.getEmailId());
                }
                break;
            case 3:
                for(Employee i:list){
                    System.out.println(i.getAge());
                }
                break;
            case 4:
                for(Employee i:list){
                    System.out.println(i.getDOB());
                }
                break;
        }
    }
}

class SortByName implements Comparator<Employee> {
    public int compare(Employee a, Employee b)
    {
        return a.getName().compareTo(b.getName());
    }
}
class SortByEmailId implements Comparator<Employee> {
    public int compare(Employee a, Employee b)
    {
        return a.getEmailId().compareTo(b.getEmailId());
    }
}
class SortByAge implements Comparator<Employee> {
    public int compare(Employee a, Employee b)
    {
        return a.getAge() - b.getAge();
    }
}
class SortByDOB implements Comparator<Employee> {
    public int compare(Employee a, Employee b)
    {
        return a.getDOB().compareTo(b.getDOB());
    }
}
