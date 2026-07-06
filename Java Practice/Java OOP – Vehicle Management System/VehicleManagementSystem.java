// package VehicleManagementSystem;

  abstract class Vehicle{
	 abstract void start();
	 abstract void stop();
     }
  interface FuelEfficiency{
	  void mailage(); 

  }
  class car extends Vehicle implements FuelEfficiency{
	  public car(double a, double b) {
		  deistence = a;
		  fule = b;
	  }
	   void start() {
		   System.out.println("Start the car");
	   }
	   void stop() { 
		   System.out.println("Stop the car");
	   }
	  private double deistence;
	  private double fule;
	  
	public  void mailage(){
	  
	  double mailege = deistence/ fule;
	  System.out.println(mailege);
	}
  } 
  class baike extends Vehicle implements FuelEfficiency{
	  public baike(double a, double b) {
		  deistence = a;
		  fule = b;
	  }
	   void start() {
		   System.out.println("Start the baike");
	   }
	   void stop() { 
		   System.out.println("Stop the baike");
	   }
	  private double deistence;
	  private double fule;
	  
	public  void mailage(){
	  
	  double mailege = deistence/ fule;
	  System.out.println("Vhical mailage : " +mailege);
	}
  } 
public class VehicleManagementSystem{

	public static void main(String[] args) { 
		System.out.println("=========================================");
        System.out.println("        VEHICLE MANAGEMENT SYSTEM        ");
        System.out.println("=========================================\n");
		// TODO Auto-generated method stub
		System.out.println("Car detailes ");
		car t1 = new car(30,30);
		t1.start();
		t1.mailage();
		t1.stop();
		 System.out.println("=========================================\n");
		System.out.println("Baike detailes ");
		baike t2 = new baike(30,30);
		t2.start();
		t2.mailage();
		t2.stop();
		 System.out.println("=========================================\n");
	}

}
