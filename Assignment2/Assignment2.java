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
        System.out.println("Select the shape to calculate the area and perimeter for:"+ 
                            "\n 1. Circle \n 2. Rectangle \n 3. Triangle \n 4. Square \n"+ 
                            "5. Sphere \n 6. Cylinder\n");
        System.out.println("Enter the index number corresponding to your choice:");
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt(); 
        if(i==1){
            Circle obj=new Circle();
        }
        // else if(i==2){
        //     Rectangle obj=new Rectangle();
        // }
        // else if(i==3){
        //     Triangle obj=new Triangle();
        // }
        // else if(i==4){
        //     Square obj=new Square();
        // }
        // else if(i==5){
        //     Sphere obj=new Sphere();
        // }
        // else if(i==6){
        //     Cylinder obj=new Cylinder();
        // }
        else
        {
            System.out.println("Enter a valid index");
        }       
    }
}

class Shape implements ShapeInterface{
    static final double PI=3.14;
    public double area(double a){
       return (a*a);
    }
    public double area(double a, double b){
        return (a*b);
    }
    public double perimeter(double a){
        return a;
    }
    public double perimeter(double a,double b){
        return  (2*(a+b));
    } 
    public double perimeter(double a,double b,double c){
        return  (a+b+c);
    } 
    public double volume(double a){
        return (a*a*a);
    }
    public double volume(double a, double b,double c){
        return (a*b*c);
    }
    public double setInput(){
        Scanner sc=new Scanner(System.in);
        boolean isValid=false;
        while(!isValid){
            try{
                while(!sc.hasNextDouble()){
                    String input=sc.next();
                    throw new InputMismatchException();
                }
                double x=sc.nextDouble();
                if(x<0){
                    throw new IllegalArgumentException();
                }
                isValid=true;
                return x;
            }
            catch(InputMismatchException e){
                System.out.println("Please enter a valid number");
            }
            catch(IllegalArgumentException e){
                System.out.println("Please enter a positive number");
            }
        }
        return 0;
    }
}


class Circle extends Shape{
    private double radius;
    public void setRadius(){
        this.radius=this.setInput();
    }
    public double getRadius(){
        return this.radius;
    }
    Circle(){
        System.out.println("Enter the radius of the circle:");
        this.setRadius();
        System.out.println("Area of the circle is "+this.PI*this.area(this.radius));
        System.out.println("Circumference of the circle is "+2*this.PI*this.perimeter(this.radius));
    }
}

class Rectangle extends Shape{
    private double length;
    private double breadth;
    public void setLength(){
        this.length=this.setInput();
    }
    public double getLength(){
        return this.length;
    }
    public void setBreadth(){
        this.breadth=this.setInput();
    }
    public double getBreadth(){
        return this.breadth;
    }
    Rectangle(){
        System.out.println("Enter the length of the rectangle:");
        this.setLength();
        System.out.println("Enter the breadth of the rectangle:");
        this.setBreadth();
        System.out.println("Area of the rectangle is "+this.area(this.length,this.breadth));
        System.out.println("Perimeter of the rectangle is "+this.perimeter(this.length,this.breadth));
    }
}

class Square extends Shape{
    private double length;
    public void setLength(){
        this.length=this.setInput();
    }
    public double getLength(){
        return this.length;
    }
    Square(){
        System.out.println("Enter the length of a side of the square:");
        this.setLength();
        System.out.println("Area of the square is "+this.area(this.length));
        System.out.println("Perimeter of the square is "+4*this.perimeter(this.length));
    }
}

class Sphere extends Shape{
    private double radius;
    public void setRadius(){
        this.radius=this.setInput();
    }
    public double getRadius(){
        return this.radius;
    }
    Sphere(){
        System.out.println("Enter the radius of the sphere:");
        this.setRadius();
        System.out.println("Surface Area of the sphere is "+4*this.PI*this.area(this.radius));
        System.out.println("Volume of the sphere is "+(4*this.PI*this.volume(this.radius))/3);
    }
}