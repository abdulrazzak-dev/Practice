// package oop.library;

// =================================================================
// 5. இடைமுகம் (INTERFACE CONCEPT)
// =================================================================
/**
 * Interface acting as a contract for components that can borrow items.
 */
interface Borrowable {
    void borrowItem();
    void returnItem();
}

// =================================================================
// 3. அப்ஸ்ட்ராக்ட் கிளாஸ் (ABSTRACTION CONCEPT)
// =================================================================
/**
 * Abstract Class: LibraryItem
 * It defines the baseline template for any item stored in the library.
 */
abstract class LibraryItem {
    // 🌟 1. ENCAPSULATION: private data members inside abstract class
    private int bookId;
    private String title;

    // பெற்றோர் அப்ஸ்ட்ராக்ட் கன்ஸ்ட்ரக்டர்
    public LibraryItem(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    // Encapsulation Getters and Setters for Parent Attributes
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    // அப்ஸ்ட்ராக்ட் மெத்தட்: இதற்குக் கோடு இருக்காது, சைல்டு கிளாஸ் தான் எழுத வேண்டும்
    public abstract void displayInfo();
}

// =================================================================
// 1 & 3. புக் கிளாஸ் (ENCAPSULATION, ABSTRACTION & INTERFACE COMBINED)
// =================================================================
/**
 * Book Class: Extends LibraryItem (Abstraction) and Implements Borrowable (Interface).
 * Demonstrates strict Encapsulation with private variables and getters/setters.
 */
class Book extends LibraryItem implements Borrowable {
    // 🌟 1. ENCAPSULATION: private data members
    private String author;
    private int price;
    private boolean isBorrowed;

    // புக் கன்ஸ்ட்ரக்டர்: பெற்றோரின் விபரங்களையும் சேர்த்து வாங்குகிறது
    public Book(int bookId, String title, String author, int price) {
        super(bookId, title); // Abstraction பெற்றோர் கன்ஸ்ட்ரக்டரை அழைக்கிறோம்
        this.author = author;
        this.price = price;
        this.isBorrowed = false; // ஆரம்பத்தில் புத்தகம் நூலகத்தில் இருக்கும்
    }

    // 🌟 1. ENCAPSULATION: Getter and Setter Methods
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    
    public boolean getIsBorrowed() { return isBorrowed; }

    // 🌟 3. ABSTRACTION & 4. POLYMORPHISM: displayInfo() மெத்தடை ஓவர்ரைடு செய்கிறோம்
    @Override
    public void displayInfo() {
        System.out.println("  [BOOK DETAILS] -> ID: " + getBookId() + " | Title: \"" + getTitle() + 
                           "\" | Author: " + author + " | Price: Rs." + price);
    }

    // 🌟 5. INTERFACE IMPLEMENTATION: borrowItem() லாஜிக்
    @Override
    public void borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("  [LIBRARY LOG]: \"" + getTitle() + "\" has been successfully BORROWED.");
        } else {
            System.out.println("  [LIBRARY ERROR]: Sorry, \"" + getTitle() + "\" is ALREADY BORROWED by someone else.");
        }
    }

    // 🌟 5. INTERFACE IMPLEMENTATION: returnItem() லாஜிக்
    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("  [LIBRARY LOG]: \"" + getTitle() + "\" has been successfully RETURNED.");
        } else {
            System.out.println("  [LIBRARY ERROR]: This book was not borrowed from this library.");
        }
    }
}

// =================================================================
// 2. பெற்றோர் கிளாஸ் (INHERITANCE CONCEPT)
// =================================================================
/**
 * Base Class: Person representing general humans in the system.
 */
class Person {
    protected String name; // சைல்டு கிளாஸ்கள் நேரடியாகப் பயன்படுத்த protected

    public Person(String name) {
        this.name = name;
    }
}

// =================================================================
// 2 & 5. மாணவர் கிளாஸ் (INHERITANCE & INTERFACE COMBINED)
// =================================================================
/**
 * Student Class: Inherits from Person (Inheritance) and implements Borrowable (Interface).
 */
class Student extends Person implements Borrowable {
    private int studentId;
    private int borrowedBooksCount;

    public Student(String name, int studentId) {
        super(name); // பெற்றோரான Person கன்ஸ்ட்ரக்டரை அழைக்கிறோம்
        this.studentId = studentId;
        this.borrowedBooksCount = 0;
    }

    // 🌟 5. INTERFACE IMPLEMENTATION: மாணவர் புத்தகம் வாங்கும் லாஜிக்
    @Override
    public void borrowItem() {
        borrowedBooksCount++;
        System.out.println("  [STUDENT ACTIVITY]: Student \"" + name + "\" (ID: " + studentId + 
                           ") borrowed an item. Active Borrows: " + borrowedBooksCount);
    }

    // 🌟 5. INTERFACE IMPLEMENTATION: மாணவர் புத்தகத்தை ஒப்படைக்கும் லாஜிக்
    @Override
    public void returnItem() {
        if (borrowedBooksCount > 0) {
            borrowedBooksCount--;
            System.out.println("  [STUDENT ACTIVITY]: Student \"" + name + "\" (ID: " + studentId + 
                               ") returned an item. Active Borrows: " + borrowedBooksCount);
        } else {
            System.out.println("  [STUDENT ERROR]: Student \"" + name + "\" has no active books to return.");
        }
    }
}

// =================================================================
// 2. நூலகர் கிளாஸ் (INHERITANCE CONCEPT)
// =================================================================
/**
 * Librarian Class: Inherits from Person.
 */
class Librarian extends Person {
    private int employeeId;

    public Librarian(String name, int employeeId) {
        super(name); // பெற்றோர் கன்ஸ்ட்ரக்டரை அழைக்கிறோம்
        this.employeeId = employeeId;
    }

    public void manageLibrary() {
        System.out.println("  [LIBRARIAN ACTIVITY]: Librarian \"" + name + "\" (Emp ID: " + employeeId + 
                           ") is currently organizing the library shelves.");
    }
}

// =================================================================
// முதன்மை கிளாஸ் மற்றும் மெயின் மெத்தட் (MAIN EXECUTION CLASS)
// =================================================================
public class LibraryManagementSystem{

    public static void main(String[] args) {
        System.out.println("=================================================================");
        System.out.println("            WELCOME TO THE OOP LIBRARY MANAGEMENT SYSTEM         ");
        System.out.println("=================================================================\n");

        // -----------------------------------------------------------------
        // 🌟 DEMONSTRATING CONCEPT 1: ENCAPSULATION (Getters / Setters)
        // -----------------------------------------------------------------
        System.out.println("----- [CONCEPT 1: ENCAPSULATION DEMO] -----");
        Book myBook = new Book(101, "Java Fundamentals", "James Gosling", 750);
        
        // பிரைவேட் தரவுகளை செட்டர்கள் மூலம் மாற்றியமைக்கிறோம்
        myBook.setPrice(890); // விலையை உயர்த்துகிறோம்
        System.out.println("  Successfully accessed private variables via Getters/Setters:");
        System.out.println("  Book Title: " + myBook.getTitle() + " | Updated Price: Rs." + myBook.getPrice());
        System.out.println("-----------------------------------------------------------------\n");

        // -----------------------------------------------------------------
        // 🌟 DEMONSTRATING CONCEPT 2: INHERITANCE (Person -> Student, Librarian)
        // -----------------------------------------------------------------
        System.out.println("----- [CONCEPT 2: INHERITANCE DEMO] -----");
        System.out.println("  Creating Student and Librarian objects inheriting from Person:");
        Student student = new Student("Suresh Kumar", 5001);
        Librarian librarian = new Librarian("Anjali Devi", 9002);
        
        // ஊழியர் தன் பிரத்யேக வேலையைச் செய்கிறார்
        librarian.manageLibrary();
        System.out.println("-----------------------------------------------------------------\n");

        // -----------------------------------------------------------------
        // 🌟 DEMONSTRATING CONCEPT 3 & 4: ABSTRACTION & RUNTIME POLYMORPHISM
        // -----------------------------------------------------------------
        System.out.println("----- [CONCEPT 3 & 4: ABSTRACTION & POLYMORPHISM DEMO] -----");
        
        // 🌟 பக்கா ரன்-டைம் பாலிமார்பிசம்: பெற்றோர் ரெஃபரன்ஸ் -> சைல்டு ஆப்ஜெக்ட்
        LibraryItem item = new Book(102, "Effective OOP Design", "Joshua Bloch", 1200);
        
        // கம்பைலருக்கு இது LibraryItem ஆகத் தெரிந்தாலும், ரன் ஆகும்போது Book இன் மெத்தடை இயக்கும்!
        item.displayInfo();
        System.out.println("-----------------------------------------------------------------\n");

        // -----------------------------------------------------------------
        // 🌟 DEMONSTRATING CONCEPT 5: INTERFACE IMPLEMENTATION (Borrowable)
        // -----------------------------------------------------------------
        System.out.println("----- [CONCEPT 5: INTERFACE (BORROWABLE) DEMO] -----");
        
        System.out.println("[Step A - Testing Book Borrowing Logic]:");
        myBook.borrowItem();
        myBook.borrowItem(); // செக்கிங் லாஜிக்: ஏற்கனவே வாங்கிய புத்தகம்
        myBook.returnItem(); // திருப்பிக் கொடுத்தல்
        
        System.out.println("\n[Step B - Testing Student Borrowing Logic]:");
        student.borrowItem();
        student.returnItem();
        
        System.out.println("=================================================================");
        System.out.println("            LIBRARY SYSTEM EXECUTION SUCCESSFUL                  ");
        System.out.println("=================================================================");
    }
}