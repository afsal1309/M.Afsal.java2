package TNS002;

public class Person {
    public String name;       // Public: accessible from anywhere
    protected int age;        // Protected: same package & subclasses
    String city;              // Default (package-private): same package only
    private double salary;    // Private: only in this class


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


 