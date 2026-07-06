// package FactryMangement.java;
class Employee{
	String name;
	int id;
	public Employee(String name,int id) {
		this.name = name;
		this.id = id;
	}
	public void displayinfo() {
		System.out.println("Employee name : " + name);
		System.out.println("Employee ID : "+id);
	}
}
class FullTimeEmployee extends Employee{
	private int monthlySalary;
	public FullTimeEmployee(String name,int id,int montlySalary) {
		super ( name, id);
		this.monthlySalary = montlySalary ;
	}
	void calculateSalary() {
		
		System.out.println("Full Time Employee salery : "+ monthlySalary);
		
	}
}
class PartTimeEmployee extends Employee{
	int hoursWorked;
	double hourlyRate;
	public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate) {
		super(name,id);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}
	
	
	void calculatSalary(){
		double totalmontlySalary = this.hoursWorked*this.hourlyRate;
		
		System.out.println("Part Time Employee Salery : " + totalmontlySalary );
	}
}
public class FactryMangement{
	public static void main(String[] args){
		System.out.println("=========================================");
        System.out.println("       FACTORY MANAGEMENT REPORT         ");
        System.out.println("=========================================");
		Employee obj = new Employee("jak",123);
		obj.displayinfo();
        System.out.println("=========================================");
		System.out.println("Full time employee worked ");
		System.out.println();
		PartTimeEmployee Obj1 = new PartTimeEmployee("kum",134,3,150);
		Obj1.displayinfo();
		Obj1.calculatSalary();	 
		System.out.println("-----------------------------------------");
		System.out.println("part time employee worked ");
		System.out.println();
		FullTimeEmployee Obj2 = new FullTimeEmployee("ku",134,11);
		Obj2.displayinfo();
		Obj2.calculateSalary();
	 	System.out.println("=========================================");
		
		
	}

}
