class SmartPrinter {
    // சின்க்ரோனைஸ் செய்யப்பட்ட மெத்தட் எண்களைக் கலந்துவிடாமல் வரிசையாக அச்சிடும்
    public synchronized void printNumbers(String type) {
        System.out.println("--- Starting " + type + " Number Printing ---");
        
        for (int i = 1; i <= 5; i++) {
            if (type.equals("ODD")) {
                System.out.println("  [ODD]: " + (2 * i - 1));
            } else {
                System.out.println("  [EVEN]: " + (2 * i));
            }

            // 🌟 sleep() மூலம் அவுட்புட்டில் ஒரு நொடி தாமதத்தை ஏற்படுத்துகிறோம்
            try {
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                System.out.println("Printing interrupted.");
            }
        }
        System.out.println("--- Finished " + type + " Number Printing ---\n");
    }
}

class NumberTask extends Thread {
    private SmartPrinter printer;
    private String numberType;

    public NumberTask(SmartPrinter printer, String numberType) {
        this.printer = printer;
        this.numberType = numberType;
    }

    @Override
    public void run() {
        printer.printNumbers(numberType);
    }
}

public class NumberPrinter {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("        SYNCHRONIZED NUMBER PRINTER       ");
        System.out.println("=========================================\n");

        SmartPrinter sharedPrinter = new SmartPrinter();

        // இரண்டு தனித்தனி த்ரெட்டுகளை உருவாக்குகிறோம்
        NumberTask oddThread = new NumberTask(sharedPrinter, "ODD");
        NumberTask evenThread = new NumberTask(sharedPrinter, "EVEN");

        oddThread.start();
        evenThread.start();
    }
}