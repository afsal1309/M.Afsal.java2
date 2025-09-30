package utilities;


import employees.Employee;
import employees.Employee.Manager.Developer;


public class EmployeeUtilities {

    public static void printEmployeeDetails(Employee emp) {
        System.out.println("---- Employee Details ----");
        System.out.println("Name: " + emp.getempName());

        System.out.println("ID: " + emp.getempID());
        System.out.println("Salary: " + emp.getSalary());
        System.out.println("--------------------------");
    }

  
    public static void checkManager(Employee.Manager manager) {
        System.out.println("Manager ID: " + manager.getMG());
        manager.Manage();
    }

    /**
     * Check developer functionality.
     */
    public static void checkDeveloper(Developer developer) {
        System.out.println("Developer ID: " + developer.getDP());
        developer.Develop();
    }


	public static void checkDeveloper1(Developer dev) {
		// TODO Auto-generated method stub
		
	}
}
