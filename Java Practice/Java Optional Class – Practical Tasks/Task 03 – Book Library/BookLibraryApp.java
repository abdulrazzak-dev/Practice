import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Book Entity Class
class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("Book [ID=%d, Title='%s', Author='%s']", id, title, author);
    }
}

// Book Library / Repository Class
class BookLibrary {
    private List<Book> books = new ArrayList<>();

    public BookLibrary() {
        // Pre-populating sample book collection
        books.add(new Book(1, "Effective Java", "Joshua Bloch"));
        books.add(new Book(2, "Clean Code", "Robert C. Martin"));
        books.add(new Book(3, "Java: The Complete Reference", "Herbert Schildt"));
    }

    // Method to search a book by title, returning an Optional<Book>
    public Optional<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title.trim()))
                .findFirst(); // Returns Optional containing the book or Optional.empty()
    }
}

public class BookLibraryApp {

    public static void main(String[] args) {
        BookLibrary library = new BookLibrary();

        System.out.println("=========================================");
        System.out.println("          BOOK LIBRARY SYSTEM            ");
        System.out.println("=========================================\n");

        // Case 1: Searching for an existing book ("Clean Code")
        String searchTitle1 = "Clean Code";
        System.out.println("Searching for Title: \"" + searchTitle1 + "\"");
        Optional<Book> foundBook1 = library.findBookByTitle(searchTitle1);

        // Task 03 Requirement: Use ifPresent() to print book details when found
        foundBook1.ifPresent(book -> System.out.println("Book Found: " + book));

        System.out.println();

        // Case 2: Searching for a non-existing book ("Design Patterns")
        String searchTitle2 = "Design Patterns";
        System.out.println("Searching for Title: \"" + searchTitle2 + "\"");
        Optional<Book> foundBook2 = library.findBookByTitle(searchTitle2);

        // ifPresent() executes only if the value exists (nothing prints here)
        foundBook2.ifPresent(book -> System.out.println("Book Found: " + book));
        if (foundBook2.isEmpty()) {
            System.out.println("Book not found in library.");
        }

        System.out.println("\n-----------------------------------------");
        System.out.println("  DEMONSTRATING ALL OPTIONAL METHODS     ");
        System.out.println("-----------------------------------------");

        // Demonstration of isPresent()
        System.out.print("1. using isPresent(): ");
        if (foundBook1.isPresent()) {
            System.out.println("Value exists! -> " + foundBook1.get().getTitle());
        }

        // Demonstration of orElse()
        Book defaultBook = new Book(0, "Default Book", "Unknown Author");
        System.out.print("2. using orElse(): ");
        Book resultBook = foundBook2.orElse(defaultBook);
        System.out.println("Result -> " + resultBook.getTitle());

        // Demonstration of ifPresent()
        System.out.print("3. using ifPresent(): ");
        foundBook1.ifPresent(b -> System.out.println("Action performed for -> " + b.getAuthor()));
    }
}