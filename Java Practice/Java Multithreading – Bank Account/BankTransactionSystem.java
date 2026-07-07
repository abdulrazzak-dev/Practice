// அசைன்மென்ட் நெறிமுறைப்படி எந்தவொரு பேக்கேஜ் எரரும் இன்றி நேரடியாக ரன் ஆக பேக்கேஜ் வரி நீக்கப்பட்டுள்ளது.

// =================================================================
// 1. வங்கி கணக்கு கிளாஸ் (Shared Resource Class)
// =================================================================
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // கெட்டர் மெத்தட் - தற்போதைய பேலன்ஸை மட்டும் பார்க்க
    public synchronized double getBalance() {
        return this.balance;
    }

    // 🌟 சின்க்ரோனைசேஷன் டெபாசிட் மெத்தட்
    /**
     * Deposits an amount into the account. Synchronized to prevent race conditions.
     * @param amount - Cash to add
     * @param threadName - Name of the person/thread doing the transaction
     */
    public synchronized void deposit(double amount, String threadName) {
        System.out.println("🏪 " + threadName + " is attempting to deposit: Rs." + amount);
        
        if (amount > 0) {
            this.balance += amount; // balance = balance + amount;
            System.out.println("  ✔️ SUCCESS: Rs." + amount + " deposited by " + threadName);
            System.out.println("  👉 CURRENT BALANCE: Rs." + this.balance + "\n");
        } else {
            System.out.println("  ❌ FAILED: Invalid deposit amount by " + threadName + "\n");
        }
    }

    // 🌟 சின்க்ரோனைசேஷன் வித்ரா மெத்தட்
    /**
     * Withdraws an amount from the account if sufficient funds exist.
     * Synchronized to ensure the balance never becomes negative due to concurrent access.
     * @param amount - Cash to subtract
     * @param threadName - Name of the person/thread doing the transaction
     */
    public synchronized void withdraw(double amount, String threadName) {
        System.out.println("🏧 " + threadName + " is attempting to withdraw: Rs." + amount);
        
        // த்ரெட் பாதுகாப்பு சோதனை: கேட்கும் தொகை இருப்பை விட குறைவாக உள்ளதா?
        if (amount <= this.balance) {
            this.balance -= amount; // balance = balance - amount;
            System.out.println("  ✔️ SUCCESS: Rs." + amount + " withdrawn by " + threadName);
            System.out.println("  👉 CURRENT BALANCE: Rs." + this.balance + "\n");
        } else {
            // இருப்புத் தொகை மைனஸ் ஆவது இங்கே கச்சிதமாகத் தடுக்கப்படுகிறது
            System.out.println("  ❌ TRANSACTION DENIED: Insufficient funds for " + threadName);
            System.out.println("  👉 AVAILABLE BALANCE: Rs." + this.balance + "\n");
        }
    }
}

// =================================================================
// 2. பணப் பரிவர்த்தனை த்ரெட் கிளாஸ் (Transaction Thread Class)
// =================================================================
class TransactionTask extends Thread {
    private BankAccount account;
    private String customerName;
    private String transactionType;
    private double amount;

    public TransactionTask(BankAccount account, String customerName, String transactionType, double amount) {
        this.account = account;
        this.customerName = customerName;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        // த்ரெட் ரன் ஆகும்போது டெபாசிட் அல்லது வித்ரா செய்ய வேண்டுமா என்று பார்க்கிறது
        if (transactionType.equalsIgnoreCase("DEPOSIT")) {
            account.deposit(amount, customerName);
        } else if (transactionType.equalsIgnoreCase("WITHDRAW")) {
            account.withdraw(amount, customerName);
        }
    }
}

// =================================================================
// முதன்மை கிளாஸ் மற்றும் மெயின் மெத்தட் (Main Execution Class)
// =================================================================
public class BankTransactionSystem {
    public static void main(String[] args) {
        
        System.out.println("=========================================");
        System.out.println("       SECURE MULTITHREADED BANKING       ");
        System.out.println("=========================================\n");

        // 1. ஆரம்ப இருப்பாக ரூ. 5000 உடன் ஒரே ஒரு கூட்டு வங்கிக் கணக்கை உருவாக்குகிறோம்
        BankAccount sharedAccount = new BankAccount("SUB-900811", 5000.00);
        
        System.out.println("Initial Account Balance: Rs." + sharedAccount.getBalance());
        System.out.println("[SYSTEM]: Activating multiple transaction threads concurrently...\n");
        System.out.println("-----------------------------------------");

        // 2. 🌟 ஒரே கணக்கை இயக்க 4 வெவ்வேறு த்ரெட்டுகளை உருவாக்குகிறோம்
        TransactionTask t1 = new TransactionTask(sharedAccount, "Ramesh (ATM)", "WITHDRAW", 4000.00);
        TransactionTask t2 = new TransactionTask(sharedAccount, "Suresh (Online)", "WITHDRAW", 3000.00);
        TransactionTask t3 = new TransactionTask(sharedAccount, "Priya (Branch)", "DEPOSIT", 2000.00);
        TransactionTask t4 = new TransactionTask(sharedAccount, "Anand (GPay)", "WITHDRAW", 1500.00);

        // 3. அனைத்து த்ரெட்டுகளையும் ஒரே நேரத்தில் ஓட விடுகிறோம்
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // மெயின் த்ரெட் மற்ற அனைத்து த்ரெட்டுகளும் முடியும் வரை காத்திருக்க join செய்கிறோம்
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // 4. இறுதி நிலவர அறிக்கை
        System.out.println("-----------------------------------------");
        System.out.println("=========================================");
        System.out.println("          FINAL BANKING REPORT           ");
        System.out.println("=========================================");
        System.out.println("  Final Secure Account Balance: Rs." + sharedAccount.getBalance());
        System.out.println("=========================================");
    }
}