// அசைன்மென்ட் நெறிமுறைப்படி எந்தவொரு பேக்கேஜ் எரரும் இன்றி நேரடியாக ரன் ஆக பேக்கேஜ் வரி நீக்கப்பட்டுள்ளது.

class ExecutionPrinter {
    // 🌟 சின்க்ரோனைசேஷன்: த்ரெட்டுகள் தங்களின் விபரங்களை ஒன்றன் பின் ஒன்றாக அச்சிட உதவுகிறது
    public synchronized void printThreadDetails(String threadName) {
        System.out.println("  [LOG]: " + threadName + " is executing its core task.");
        try {
            Thread.sleep(400); // சிமுலேஷனுக்காக ஒரு குட்டி டைம் கேப்
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("  [SUCCESS]: " + threadName + " has finished execution.\n");
    }
}

class WorkerTask extends Thread {
    private ExecutionPrinter printer;
    private String name;

    public WorkerTask(ExecutionPrinter printer, String name) {
        this.printer = printer;
        this.name = name;
    }

    @Override
    public void run() {
        printer.printThreadDetails(name);
    }
}

public class ThreadManager {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("        THREAD EXECUTION MANAGER         ");
        System.out.println("=========================================\n");

        ExecutionPrinter sharedPrinter = new ExecutionPrinter();

        // 3 த்ரெட்டுகளை உருவாக்குகிறோம்
        WorkerTask t1 = new WorkerTask(sharedPrinter, "Thread-A");
        WorkerTask t2 = new WorkerTask(sharedPrinter, "Thread-B");
        WorkerTask t3 = new WorkerTask(sharedPrinter, "Thread-C");

        // த்ரெட்டுகளைத் தொடங்குவதற்கு முன் அவற்றின் நிலையைச் சோதிக்கிறோம்
        System.out.println("Before start() -> Is Thread-A alive? " + t1.isAlive());

        // த்ரெட்டுகளைத் தொடங்குகிறோம்
        t1.start();
        t2.start();
        t3.start();

        System.out.println("After start()  -> Is Thread-A alive? " + t1.isAlive() + "\n");

        // 🌟 'join()' மூலம் மெயின் மெத்தடைக் காத்திருக்க வைக்கிறோம் (வரிசையாக முடிய)
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("After join()   -> Is Thread-A alive? " + t1.isAlive());
        System.out.println("\n=========================================");
        System.out.println("        ALL THREADS WORK COMPLETED       ");
        System.out.println("=========================================");
    }
}