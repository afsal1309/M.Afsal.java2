package employees;

public class Employee {


public String Afsal;
public String empName =Afsal ;
public int empID= 002;
public int Salary=25000;

public String Shiva;
public String empName1 =Shiva ;
public int empID1= 003;
public int Salary1=20000;





    public static void printEmployeeDetails(Employee emp) {
        System.out.println("---- Employee Details ----");
        System.out.println("Name: " + emp.getempName());

        System.out.println("ID: " + emp.getempID());
        System.out.println("Salary: " + emp.getSalary());
        System.out.println("--------------------------");
    }

 public class Manager extends Employee {
 public int MG=005;
	 public void Manage() {
	 System.out.println("Able to Manage"); 
 }
	 
	  public class Developer extends Employee {
		 public int DP=007;
			 public void Develop() {
			 System.out.println("Able to Develop"); 
		 }public int getMG() {
				return MG;
			}

			public void setMG(int mg) {
				MG = mg;}
	 
public int getDP() {
				return DP;
			}

			public void setDP(int dP) {
				DP = dP;
			}

public String getAfsal() {
	return Afsal;
}
public void setAfsal(String afsal) {
	Afsal = afsal;
}
public String getEmpName() {
	return setEmpName("Afsal");
}
public String setEmpName(String empName) {
	return this.Afsal = empName;
}
public int getEmpID() {
	return empID;
}


public int getSalary() {
	return Salary;
}
public void setSalary(int salary) {
	Salary = salary;
}
public String getShiva() {
	return Shiva;
}
public void setShiva(String shiva) {
	Shiva = shiva;
}
public String getEmpName1() {
	return empName1=Shiva;
}
public void setEmpName1(String empName1) {
	this.empName1 = Shiva;
}
public int getEmpID1() {
	return empID1;
}
public void setEmpID1(int empID1) {
	this.empID1 = 0056;
}
public int getSalary1() {
	return Salary1;
}
public void setSalary1(int salary1) {
	Salary1 = salary1;
}}

	public int getMG() {
		// TODO Auto-generated method stub
		return (055);
	}

	public void setMG(int i) {
		// TODO Auto-generated method stub
		
	}}

public int getempID() {
	// TODO Auto-generated method stub
	return (002);
}

public String getempName() {
	// TODO Auto-generated method stub
	return (Afsal);
}

public int getSalary() {
	// TODO Auto-generated method stub
	return (25000);
}

public String setEmpName(String string) {
	return Shiva;
	// TODO Auto-generated method stub
	
}

public String setEmpName(int i) {
	return (Afsal);
	// TODO Auto-generated method stub
	
}

public void setSalary(int i) {
	// TODO Auto-generated method stub
	
}

public static void print(String afsal2) {
	// TODO Auto-generated method stub
	
}

public void setEmpID1(int i) {
	
}


}













	
