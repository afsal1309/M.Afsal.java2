package TNS002;

public class Person {
    public String name;      
    protected int age;        
    String city;             
    private double salary;    


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        System.out.println("Salary: " + salary);
    }
}


 