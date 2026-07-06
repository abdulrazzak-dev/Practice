// package BankAccount.java;

public class BankAccount{
	  
	private int accountNumber;
	private String accountHoldername ;
	private double balance;
	
	public int getaccountNumber() {
		return this.accountNumber;
	}
	public void setaccountNumber(int newaccountNumber) {
		this.accountNumber = newaccountNumber;
	}
	public String getaccountHolderName() {
		return this.accountHoldername;
	}
	public void setaccountHolderName(String newaccountHolderName) {
		this.accountHoldername = newaccountHolderName;
	}
	public double getbalance() {
		return this.balance;
	}
	public void setbalance(double newbalance) {
		this.balance = newbalance;
	}
	
	void deposit(double amount) {
		if(amount > 0) {
			this.balance += amount;
			System.out.print("your deposit amount : " + amount);
		}System.out.println();
	} 
	
	void withdraw(double amount) {
		if(amount <= this.balance) {
			this.balance -= amount;
			
		}System.out.print("your Withdraw amount : " + amount);
		 System.out.println();
	}
		
	
	void displayAccountDetails() {
		System.out.print("Account number : " + this.accountNumber);	
		System.out.println();
	    System.out.print("Account Holder Name : " + this.accountHoldername);	
	    System.out.println();
        System.out.print("Account balance : " + this.balance);	
	}
	
	
	
	public static void main(String[] args) {
	BankAccount obj1 = new BankAccount();
	obj1.setaccountNumber(123456);
	obj1.setaccountHolderName("Kumar");
	obj1.deposit(5000);
	obj1.withdraw(2000);
	obj1.displayAccountDetails();
	
	}
}
