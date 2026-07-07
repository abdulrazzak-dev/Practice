//package assignment.exceptions;

import java.util.Scanner;
 
// =================================================================
// 1. பயனரால் வரையறுக்கப்பட்ட கஸ்டம் எக்ஸெப்ஷன் (Custom Exception Class)
// =================================================================
/**
 * Custom Exception thrown when a user attempts to withdraw more money
 * than what is available in their bank account balance.
 */
class InsufficientBalanceException extends Exception {
    // கன்ஸ்ட்ரக்டர்: இது எரர் மெசேஜை வாங்கி பெற்றோரான Exception கிளாஸிற்கு அனுப்பும்
    public InsufficientBalanceException(String errorMessage) {
        super(errorMessage);
    }
}

// =================================================================
// 2. வங்கி கணக்கு கிளாஸ் (Bank Account Class)
// =================================================================
class BankAccount {
    // OOP தத்துவப்படி அட்ரிபியூட்களை என்காப்சுலேட் செய்கிறோம்
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // கன்ஸ்ட்ரக்டர்: கணக்கு விபரங்களை ஆரம்பிக்க
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // கெட்டர் (Getter) மெத்தட் - தற்போதைய பேலன்ஸை மட்டும் பார்க்க
    public double getBalance() {
        return this.balance;
    }

    // 🌟 3. பணம் எடுக்கும் மெத்தட் (Withdraw Method with 'throws' declaration)
    /**
     * Withdraws money if sufficient funds exist. Otherwise, throws custom exception.
     * @param amount - The cash amount to withdraw
     * @throws InsufficientBalanceException - When amount > balance
     */
    public void withdraw(double amount) throws InsufficientBalanceException {
        System.out.println("\n[PROCESSING]: Attempting to withdraw Rs." + amount + "...");
        
        // கோர் லாஜிக் செக்கிங்: கேட்கும் தொகை இருப்பை விட அதிகமாக உள்ளதா?
        if (amount > this.balance) {
            // நிபந்தனை மீறப்படும் போது நமது கஸ்டம் எரரை 'throw' கீவேர்ட் மூலம் வீசுகிறோம்
            throw new InsufficientBalanceException("Transaction Denied! You are short of Rs." + (amount - this.balance));
        }
        
        // போதுமான பணம் இருந்தால் இருப்பைக் குறைத்து அப்டேட் செய்கிறோம்
        this.balance -= amount; // balance = balance - amount;
        System.out.println("🌟 SUCCESS: Rs." + amount + " has been successfully withdrawn.");
        System.out.println("👉 REMAINING BALANCE: Rs." + this.balance);
    }
    
    // கணக்கு விபரங்களைக் காட்டும் எளிய மெத்தட்
    public void displayAccountSummary() {
        System.out.println("  Account Number : " + this.accountNumber);
        System.out.println("  Account Holder : " + this.accountHolderName);
        System.out.println("  Current Balance: Rs." + this.balance);
    }
}

// =================================================================
// முதன்மை கிளாஸ் மற்றும் மெயின் மெத்தட் (Main Execution Class)
// =================================================================
public class BankSystem{
    public static void main(String[] args) {
        // பயனரிடமிருந்து டைனமிக்காக இன்புட் வாங்க ஸ்கேனர்
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=========================================");
        System.out.println("         WELCOME TO DIGITAL BANK         ");
        System.out.println("=========================================");

        // 1. வங்கியின் ஆப்ஜெக்ட்டை உருவாக்கி ஆரம்ப விபரங்களை வழங்குகிறோம்
        BankAccount account = new BankAccount("IB-400921", "Suresh Kumar", 5000.00);
        
        System.out.println("\n--- [INITIAL ACCOUNT SUMMARY] ---");
        account.displayAccountSummary();
        System.out.println("-----------------------------------------");

        // 2. பயனரிடமிருந்து எவ்வளவு பணம் எடுக்க வேண்டும் என்று கேட்கிறோம்
        System.out.print("\nEnter the amount to withdraw: Rs.");
        double withdrawAmount = scanner.nextDouble();

        // 🌟 4. EXCEPTION HANDLING: try-catch பிளாக் மூலம் கஸ்டம் எரரைப் பிடிக்கிறோம்
        try {
            // பணம் எடுக்கும் மெத்தடை அழைக்கிறோம்
            account.withdraw(withdrawAmount);
            
        } catch (InsufficientBalanceException e) {
            // 5. பணம் போதவில்லை என்றால் இந்த பிளாக் பாய்ந்து பிடிக்கும்
            System.out.println("\n[🚨 BANK ERROR CAUGHT]: " + e.getMessage());
            System.out.println("[STATUS]: Program rescued gracefully. No crash occurred.");
            
        } catch (Exception e) {
            // பொதுவான பிற பிழைகளைக் கையாள
            System.out.println("\n[UNKNOWN ERROR]: Something went wrong: " + e.getMessage());
        } finally {
            // வங்கியின் இறுதி நிலவர அறிக்கையைக் காட்டுகிறோம்
            System.out.println("\n=========================================");
            System.out.println("          FINAL TRANSACTION REPORT       ");
            System.out.println("=========================================");
            System.out.println("  Final Account Balance: Rs." + account.getBalance());
            System.out.println("=========================================");
            
            // ஸ்கேனரைப் பத்திரமாக மூடுகிறோம் (Resource Safety)
            scanner.close();
        }
    }
}