import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingDemo {

    public static void main(String[] args) {
        String folderName = "MyProjectFolder";
        String fileName = folderName + File.separator + "student_details.txt";

        // 1. Create a Folder
        File folder = new File(folderName);
        if (folder.mkdir()) {
            System.out.println("1. Folder created successfully: " + folder.getName());
        } else {
            System.out.println("1. Folder already exists or failed to create.");
        }

        // 2. Create a File
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("2. File created successfully: " + file.getName());
            } else {
                System.out.println("2. File already exists.");
            }

            // 3. Write Data into the File
            FileWriter writer = new FileWriter(file);
            writer.write("Welcome to Java File Handling Tutorial!\n");
            writer.write("This is a practical demonstration using FileWriter and Scanner.");
            writer.close(); // Closing resource
            System.out.println("3. Data successfully written to the file.");

            // 4. Read Content from the File
            System.out.println("\n--- 4. Reading File Content ---");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close(); // Closing resource

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        // 5. Delete the File and Folder (Uncomment to enable deletion)
        
        if (file.delete()) {
            System.out.println("\n5. File deleted successfully: " + file.getName());
        }
        if (folder.delete()) {
            System.out.println("5. Folder deleted successfully: " + folder.getName());
        }
        
    }
}