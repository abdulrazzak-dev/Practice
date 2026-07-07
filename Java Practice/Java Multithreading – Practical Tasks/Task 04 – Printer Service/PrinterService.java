class OfficePrinter {
    // சின்க்ரோனைஸ் செய்யப்பட்ட மெத்தட் பேப்பர் ஜாம் அல்லது கோடுகள் கலந்துவிடாமல் தடுக்கும்
    public synchronized void printDocument(String employeeName) {
        System.out.println("🖨️ [PRINT START]: Processing job for " + employeeName);
        try {
            Thread.sleep(500); // பிரிண்ட் ஆக அரை வினாடி ஆகிறது
        } catch (InterruptedException e) {
            System.out.println("Printing job failed.");
        }
        System.out.println("✅ [PRINT END]: Document successfully printed for " + employeeName + "\n");
    }
}

class EmployeeJob extends Thread {
    private OfficePrinter printer;
    private String employeeName;

    public EmployeeJob(OfficePrinter printer, String employeeName) {
        this.printer = printer;
        this.employeeName = employeeName;
    }

    @Override
    public void run() {
        printer.printDocument(employeeName);
    }
}

public class PrinterService {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("         OFFICE PRINTER SERVICE          ");
        System.out.println("=========================================\n");

        OfficePrinter sharedPrinter = new OfficePrinter();

        EmployeeJob emp1 = new EmployeeJob(sharedPrinter, "Employee-A (Intern)");
        EmployeeJob emp2 = new EmployeeJob(sharedPrinter, "Employee-B (Manager)"); // 🌟 இவருக்குத் தான் ஹை ப்ரியாரிட்டி
        EmployeeJob emp3 = new EmployeeJob(sharedPrinter, "Employee-C (Clerk)");

        // 🌟 setPriority(): மேனேஜருக்கு ஆக அதிகபட்ச முன்னுரிமையை (10) வழங்குகிறோம்
        emp1.setPriority(Thread.MIN_PRIORITY);  // முன்னுரிமை = 1
        emp2.setPriority(Thread.MAX_PRIORITY);  // முன்னுரிமை = 10
        emp3.setPriority(Thread.NORM_PRIORITY); // முன்னுரிமை = 5

        // வேலைகளைத் தொடங்குகிறோம்
        emp1.start();
        emp2.start();
        emp3.start();

        // 🌟 join() மூலம் அத்தனை பிரிண்ட் வேலைகளும் முடியும் வரை மெயின் மெத்தடை வெயிட் பண்ண வைக்கிறோம்
        try {
            emp1.join();
            emp2.join();
            emp3.join();
        } catch (InterruptedException e) {
            System.out.println("Main printer thread interrupted.");
        }

        System.out.println("=========================================");
        System.out.println("        ALL PRINT JOBS ARE COMPLETED     ");
        System.out.println("=========================================");
    }
}