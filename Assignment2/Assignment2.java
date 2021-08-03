/*
 * Classname: Assigment2.java
 */
import java.util.*;

interface ShapeInterface{
    double area(double a);
    double area(double a, double b);
    double perimeter(double a);
    double perimeter(double a, double b);
    double volume(double a);
    double volume(double a, double b,double c);
}

public class Assignment2{
    public static void main(String[] args){
        System.out.println("Select the shape to calculate the area and perimeter for: 
                            \n 1. Circle \n 2. Rectangle \n 3. Triangle \n 4. Square \n 
                            5. Sphere \n 6. Cylinder\n");
        System.out.println("Enter the index number corresponding to your choice:");
        Scanner sc=new Scanner(System.in);
        String i=sc.nextInt(); 
        if(i==1){
            Circle obj=new Circle();
        }
        else if(i==2){
            Rectangle obj=new Rectangle();
        }
        else if(i==3){
            Triangle obj=new Triangle();
        }
        else if(i==4){
            Square obj=new Square();
        }
        else if(i==5){
            Sphere obj=new Sphere();
        }
        else if(i==6){
            Cylinder obj=new Cylinder();
        }
        else
        {
            System.out.println("Enter a valid index");
        }       
    }
}


