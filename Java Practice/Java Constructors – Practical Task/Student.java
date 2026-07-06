package oop.constructors;

/**
 * Program: Student Class demonstrating Default, Parameterized, and Copy Constructors.
 * Description: Adheres to OOP principles, initializes attributes via constructors, and displays details.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and clean formatting.
 */
public class Student{

    // 🌟 OOP தத்துவப்படி அட்ரிபியூட்களை பிரைவேட்டாக (Encapsulation) வைக்கிறோம்
    private int studentId;
    private String studentName;
    private String course;

    // =================================================================
    // 1. டீஃபால்ட் கன்ஸ்ட்ரக்டர் (Default Constructor)
    // =================================================================
    /**
     * No-argument constructor to initialize attributes with baseline default values.
     */
    public Student() {
        // ஆரம்பக்கட்ட மதிப்புகளை உள்ளீடு செய்கிறோம்
        this.studentId = 0;
        this.studentName = "Unknown";
        this.course = "Not Assigned";
        System.out.println("[SYSTEM INFO]: Default Constructor Called. Blank Student Object Created.");
    }

    // =================================================================
    // 2. பாராமீட்டரைஸ்டு கன்ஸ்ட்ரக்டர் (Parameterized Constructor)
    // =================================================================
    /**
     * Initializes all attributes with the user-provided values.
     * @param studentId   - Unique ID of the student
     * @param studentName - Name of the student
     * @param course      - Enrolled course
     */
    public Student(int studentId, String studentName, String course) {
        // 'this' கீவேர்ட் லோக்கல் வேரியபிளையும் இன்ஸ்டன்ஸ் வேரியபிளையும் பிரிக்கப் பயன்படுகிறது
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        System.out.println("[SYSTEM INFO]: Parameterized Constructor Called. Custom Student Object Created.");
    }

    // =================================================================
    // 3. காப்பி கன்ஸ்ட்ரக்டர் (Copy Constructor)
    // =================================================================
    /**
     * Creates a brand new object by copying the exact state from an existing Student object.
     * @param anotherStudent - The source Student object to copy from
     */
    public Student(Student anotherStudent) {
        // முந்தைய ஆப்ஜெக்ட்டின் மதிப்புகளை புதிய ஆப்ஜெக்ட்டிற்குள் நகலெடுக்கிறோம்
        this.studentId = anotherStudent.studentId;
        this.studentName = anotherStudent.studentName;
        this.course = anotherStudent.course;
        System.out.println("[SYSTEM INFO]: Copy Constructor Called. Existing Student Object Cloned.");
    }

    // =================================================================
    // விபரங்களை அச்சிடும் மெத்தட் (Display Method)
    // =================================================================
    /**
     * Prints all the information related to the student in a formatted way.
     */
    public void displayDetails() {
        System.out.println("  Student ID   : " + this.studentId);
        System.out.println("  Student Name : " + this.studentName);
        System.out.println("  Course       : " + this.course);
        System.out.println("-----------------------------------------");
    }

    // =================================================================
    // மெயின் மெத்தட் (Main Method Execution)
    // =================================================================
    public static void main(String[] args) {
        
        System.out.println("=========================================");
        System.out.println("       OBJECT CREATION LIVE LOGS         ");
        System.out.println("=========================================\n");

        // ஆப்ஜெக்ட் 1: டீஃபால்ட் கன்ஸ்ட்ரக்டர் மூலம் உருவாக்குதல்
        Student defaultStudent = new Student();
        
        System.out.println(); // ஒரு வெற்று வரி 

        // ஆப்ஜெக்ட் 2: பாராமீட்டரைஸ்டு கன்ஸ்ட்ரக்டர் மூலம் உருவாக்குதல்
        Student parameterizedStudent = new Student(101, "Suresh Kumar", "Java Full Stack Development");
        
        System.out.println(); // ஒரு வெற்று வரி

        // ஆப்ஜெக்ட் 3: காப்பி கன்ஸ்ட்ரக்டர் மூலம் ஆப்ஜெக்ட் 2 ஐ நகலெடுத்து உருவாக்குதல்
        Student copyStudent = new Student(parameterizedStudent);

        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான நேர்த்தியான அவுட்புட் அறிக்கை
        // -----------------------------------------------------------------
        System.out.println("\n=========================================");
        System.out.println("            STUDENT DETAILS REPORT        ");
        System.out.println("=========================================");
        
        System.out.println("[OBJECT 1] - Created via Default Constructor:");
        defaultStudent.displayDetails();
        
        System.out.println("[OBJECT 2] - Created via Parameterized Constructor:");
        parameterizedStudent.displayDetails();
        
        System.out.println("[OBJECT 3] - Created via Copy Constructor (Clone of Object 2):");
        copyStudent.displayDetails();
        
        System.out.println("=========================================");
    }
}