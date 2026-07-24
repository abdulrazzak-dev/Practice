class SystemResourceManager {
    private boolean isPrinterBusy = false;
    private boolean isScannerBusy = false;

    // Synchronized method to acquire both resources in a defined order
    public synchronized void acquireResources(String userName) throws InterruptedException {
        // Wait as long as either resource is occupied
        while (isPrinterBusy || isScannerBusy) {
            System.out.println("[" + userName + "] Resources busy. Waiting...");
            wait();
        }

        // Lock both resources
        isPrinterBusy = true;
        isScannerBusy = true;
        System.out.println("[" + userName + "] Successfully acquired PRINTER and SCANNER.");
    }

    // Synchronized method to release resources and notify waiting threads
    public synchronized void releaseResources(String userName) {
        isPrinterBusy = false;
        isScannerBusy = false;
        System.out.println("[" + userName + "] Released PRINTER and SCANNER.");
        
        // Wake up all threads waiting on this manager
        notifyAll();
    }
}

class UserTask implements Runnable {
    private final String userName;
    private final SystemResourceManager resourceManager;

    public UserTask(String userName, SystemResourceManager resourceManager) {
        this.userName = userName;
        this.resourceManager = resourceManager;
    }

    @Override
    public void run() {
        try {
            // Step 1: Attempt to acquire resources
            resourceManager.acquireResources(userName);

            // Step 2: Simulate printing & scanning work
            System.out.println("[" + userName + "] Currently scanning and printing documents...");
            Thread.sleep(1500); // Working

        } catch (InterruptedException e) {
            System.err.println("[" + userName + "] Interrupted while waiting.");
            Thread.currentThread().interrupt();
        } finally {
            // Step 3: Always release resources in a finally block
            resourceManager.releaseResources(userName);
        }
    }
}

public class PrinterScannerSystem {
    public static void main(String[] args) {
        SystemResourceManager manager = new SystemResourceManager();

        // Create user threads sharing the same resource manager
        Thread user1 = new Thread(new UserTask("User1", manager));
        Thread user2 = new Thread(new UserTask("User2", manager));

        System.out.println("--- Starting Printer & Scanner System ---");
        user1.start();
        user2.start();
    }
}