package TNS002;

public class Employee extends Person {
    public String department;

    public void displayEmployee() {
        
        System.out.println("Name: " + name);     
        System.out.println("Age: " + age);      
        System.out.println("City: " + city);     
        
   
       

        System.out.println("Department: " + department);
    }


    public static void main(String[] args) {
        Employee emp = new Employee();
        
        
        emp.name = "Afsal";       
        emp.age = 28;              
        emp.city = "Chennai";        
        emp.department = "IT";      
        
        emp.setSalary(75000);       
        emp.displayEmployee();       
    }
}
