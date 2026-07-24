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

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
}

public class SafeBankTransfer01 {

    public static void transferMoney(BankAccount fromAcc, BankAccount toAcc, int amount) {
        // Determine lock order based on Account ID
        BankAccount firstLock = fromAcc.getId() < toAcc.getId() ? fromAcc : toAcc;
        BankAccount secondLock = fromAcc.getId() < toAcc.getId() ? toAcc : fromAcc;

        // Acquire locks in a globally consistent order
        synchronized (firstLock) {
            System.out.println(Thread.currentThread().getName() + ": Acquired first lock on Account " + firstLock.getId());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (secondLock) {
                System.out.println(Thread.currentThread().getName() + ": Acquired second lock on Account " + secondLock.getId());

                if (fromAcc.getBalance() >= amount) {
                    fromAcc.withdraw(amount);
                    toAcc.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + ": Successfully transferred Rs." + amount + 
                                       " from Account " + fromAcc.getId() + " to Account " + toAcc.getId());
                } else {
                    System.out.println(Thread.currentThread().getName() + ": Transfer failed due to insufficient funds.");
                }
            }
        }
    }

    public static void main(String[] args) {
        BankAccount accA = new BankAccount(1, 1000);
        BankAccount accB = new BankAccount(2, 2000);

        // Thread 1: Account A -> Account B
        Thread t1 = new Thread(() -> transferMoney(accA, accB, 200), "Transfer-Thread-1");

        // Thread 2: Account B -> Account A
        Thread t2 = new Thread(() -> transferMoney(accB, accA, 300), "Transfer-Thread-2");

        t1.start();
        t2.start();
    }
}