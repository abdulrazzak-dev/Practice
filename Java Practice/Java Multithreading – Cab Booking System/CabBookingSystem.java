// அசைன்மென்ட் நெறிமுறைப்படி எந்தவொரு பேக்கேஜ் எரரும் இன்றி நேரடியாக ரன் ஆக பேக்கேஜ் வரி நீக்கப்பட்டுள்ளது.

// =================================================================
// 1. கேப் கிளாஸ் (Shared Resource Class)
// =================================================================
class Cab {
    // வண்டியின் புக்கிங் நிலவரத்தைக் குறிக்கும் அட்ரிபியூட் (true = புக் ஆகிவிட்டது, false = காலியாக உள்ளது)
    private boolean isBooked = false;

    // 🌟 சின்க்ரோனைசேஷன்: 'synchronized' கீவேர்ட் ரேஸ் கண்டிஷனைத் தடுத்து த்ரெட் பாதுகாப்பை உறுதி செய்கிறது.
    /**
     * Attempts to book the cab. Only one thread can execute this method at a time.
     * @param customerName - Name of the customer thread attempting the booking.
     */
    public synchronized void bookCab(String customerName) {
        System.out.println("  [PING]: " + customerName + " is checking cab availability...");
        
        // சிமுலேஷனுக்காக ஒரு குட்டி டைம் கேப் (த்ரெட்டுகள் ஒரே நேரத்தில் போட்டி போடுவதைக் காட்ட)
        try {
            Thread.sleep(500); // 0.5 வினாடி த்ரெட்டை தூங்க வைக்கிறோம்
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        // 🌟 4. புக்கிங் கோர் லாஜிக்
        if (!isBooked) {
            // வண்டி காலியாக இருந்தால் புக்கிங் செய்ய அனுமதிக்கப்படுகிறது
            isBooked = true; 
            System.out.println("  🎉 SUCCESS: " + customerName + " successfully booked the cab!\n");
        } else {
            // வண்டி ஏற்கனவே புக் செய்யப்பட்டிருந்தால் கோரிக்கை நிராகரிக்கப்படும்
            System.out.println("  ❌ FAILED: " + customerName + " failed to book. Cab is already booked.\n");
        }
    }
}

// =================================================================
// 2. கஸ்டமர் த்ரெட் கிளாஸ் (Customer Thread Class - Runnable Implementation)
// =================================================================
/**
 * Represents a customer trying to book the shared Cab resource concurrently.
 */
class CustomerRequest implements Runnable {
    private Cab sharedCab;
    private String customerName;

    public CustomerRequest(Cab sharedCab, String customerName) {
        this.sharedCab = sharedCab;
        this.customerName = customerName;
    }

    // த்ret ரன் ஆகும்போது இயங்கும் முதன்மை மெத்தட்
    @Override
    public void run() {
        // பகிரப்பட்ட வண்டியை புக் செய்ய த்ரெட் முயலுகிறது
        sharedCab.bookCab(customerName);
    }
}

// =================================================================
// முதன்மை கிளாஸ் மற்றும் மெயின் மெத்தட் (Main Execution Class)
// =================================================================
public class CabBookingSystem {
    public static void main(String[] args) {
        
        System.out.println("=========================================");
        System.out.println("          CAB BOOKING SYSTEM     ");
        System.out.println("=========================================\n");

        // 1. ஒரே ஒரு பொதுவான வண்டி ஆப்ஜெக்ட்டை உருவாக்குகிறோம் (Shared Resource)
        Cab aCab = new Cab();

        // 2. 🌟 5. த்ரெட் பாதுகாப்பு நிரூபணம்: ஒரே வண்டிக்கு 3 வாடிக்கையாளர்கள் போட்டி போடுகிறார்கள்
        // Runnable இன்ஸ்டன்ஸ்களை உருவாக்குகிறோம்
        CustomerRequest task1 = new CustomerRequest(aCab, "Customer 1 (Ramesh)");
        CustomerRequest task2 = new CustomerRequest(aCab, "Customer 2 (Suresh)");
        CustomerRequest task3 = new CustomerRequest(aCab, "Customer 3 (Priya)");

        // அசல் த்ரெட் ஆப்ஜெக்ட்டுகளைக் கட்டமைக்கிறோம்
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        // 3. ஒரே நொடில மூணு த்ரெட்டுகளையும் ஸ்டார்ட் பண்ணி ஓட விடுறோம் (Concurrent Activation)
        System.out.println("[SYSTEM INFO]: Launching concurrent booking requests...\n");
        thread1.start();
        thread2.start();
        thread3.start();

        // மெயின் மெத்தட் மற்ற த்ரெட்டுகள் முடியும் வரை காத்திருக்க join செய்கிறோம்
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("=========================================");
        System.out.println("         BOOKING PROCESS COMPLETED       ");
        System.out.println("=========================================");
    }
}