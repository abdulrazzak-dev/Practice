class SharedReport {
    // சின்க்ரோனைஸ் செய்யப்பட்ட மெத்தட் பல த்ரெட்டுகள் ஒரே நேரத்தில் அறிக்கையை மாற்றுவதைத் தடுக்கும்
    public synchronized void writeResult(String studentName, int marks) {
        System.out.println("📝 Writing to central database...");
        System.out.println("  [REPORT]: Student: " + studentName + " | Scored: " + marks + "/100");
        System.out.println("-----------------------------------------");
    }
}

class StudentEvaluator extends Thread {
    private SharedReport report;
    private String studentName;
    private int mark1, mark2;

    public StudentEvaluator(SharedReport report, String studentName, int mark1, int mark2) {
        this.report = report;
        this.studentName = studentName;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    @Override
    public void run() {
        // சிமுலேஷன்: த்ரெட் மதிப்பெண்களைக் கூட்டி கணக்கிடுகிறது
        int finalScore = (mark1 + mark2) / 2;
        report.writeResult(studentName, finalScore);
    }
}

public class ResultGenerator {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("        STUDENT RESULT GENERATOR         ");
        System.out.println("=========================================\n");

        SharedReport centralReport = new SharedReport();

        // 3 மாணவர்கள் த்ரெட்டுகளை உருவாக்குகிறோம்
        StudentEvaluator s1 = new StudentEvaluator(centralReport, "Ramesh", 85, 95);
        StudentEvaluator s2 = new StudentEvaluator(centralReport, "Priya", 90, 92);
        StudentEvaluator s3 = new StudentEvaluator(centralReport, "Suresh", 70, 80);

        s1.start();
        s2.start();
        s3.start();

        // 🌟 'isAlive()' மூலம் த்ரெட்டுகள் வேலை செய்து கொண்டிருக்கிறதா என்று கண்காணிக்கும் லூப்
        while (s1.isAlive() || s2.isAlive() || s3.isAlive()) {
            try {
                Thread.sleep(100); // த்ரெட்டுகள் முடியும் வரை மெயின் த்ரெட்டை ஒரு குட்டி தூக்கம் போட வைக்கிறோம்
            } catch (InterruptedException e) {
                System.out.println("Monitoring interrupted.");
            }
        }

        System.out.println("\n🎉 SUCCESS: All student results processed and logged successfully!");
        System.out.println("=========================================");
    }
}