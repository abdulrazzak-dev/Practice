class BankAccount {
    private final int id;
    private int balance;

    public BankAccount(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public synchronized int getBalance() {
        return balance;
    }

    // Deposit money into the account
    public synchronized void deposit(int amount) {
        this.balance += amount;
        System.out.println(Thread.currentThread().getName() + ": Deposited Rs." + amount + " into Account " + id + ". New Balance: " + this.balance);
        
        // Notify waiting threads that new funds are available
        notifyAll(); 
    }

    // Withdraw money from the account with a wait/notify mechanism
    public synchronized void withdraw(int amount) throws InterruptedException {
        // Wait as long as the account balance is less than requested amount
        while (this.balance < amount) {
            System.out.println(Thread.currentThread().getName() + ": Insufficient balance in Account " + id + " (Current Balance: " + this.balance + "). Waiting for funds...");
            
            // wait() releases ONLY this account's lock so other threads can proceed
            wait(); 
        }
        this.balance -= amount;
        System.out.println(Thread.currentThread().getName() + ": Withdrew Rs." + amount + " from Account " + id + ". Remaining Balance: " + this.balance);
    }
}

public class SafeBankTransfer {

    // Transfer money safely without holding nested locks during wait()
    public static void transfer(BankAccount fromAcc, BankAccount toAcc, int amount) {
        try {
            System.out.println("\n" + Thread.currentThread().getName() + ": Attempting to transfer Rs." + amount + " from Account " + fromAcc.getId() + " to Account " + toAcc.getId() + "...");
            
            // Step 1: Withdraw from source account (will wait and release lock if funds are low)
            fromAcc.withdraw(amount);
            
            // Step 2: Deposit to target account (and notify waiting threads)
            toAcc.deposit(amount);
            
            System.out.println(Thread.currentThread().getName() + ": Transfer Successful!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Account 1 initialized with Rs. 100
        BankAccount acc1 = new BankAccount(1, 100);
        BankAccount acc2 = new BankAccount(2, 2000);

        // Thread 1: Wants to transfer Rs. 500 from Acc 1 -> Acc 2 (will wait due to low balance)
        Thread t1 = new Thread(() -> transfer(acc1, acc2, 500), "Transfer-Thread-1");

        // Thread 2: Transfers Rs. 1000 from Acc 2 -> Acc 1 (adds funds to Acc 1 and wakes up Thread 1)
        Thread t2 = new Thread(() -> transfer(acc2, acc1, 1000), "Transfer-Thread-2");

        t1.start();
        t2.start();
    }
}