package com.Afsal.assignment01;
import employees.Employee;
import employees.Employee.Manager;
import employees.Employee.Manager.Developer;
import utilities.EmployeeUtilities;


public class Assignment {

	public static void main(String[] args) {
		 Employee emp = new Employee();
	        emp.setEmpName("Afsal");
	       
	        emp.setSalary(25000);

	        Manager mgr = emp.new Manager();
	        mgr.setMG(201);

	        Developer dev = mgr.new Developer();
	        dev.setDP(301);
	        EmployeeUtilities.printEmployeeDetails(emp);
	        EmployeeUtilities.checkManager(mgr);
	        EmployeeUtilities.checkDeveloper(dev);
Employee.print(emp.Afsal);

	}

}
