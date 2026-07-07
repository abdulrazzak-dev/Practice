package assignment.exceptions;

import java.util.Scanner;

/**
 * Task 03: Explicitly throw IllegalArgumentException using the 'throw' keyword for custom logic.
 */
public class ThrowKeyword{ 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Student's Age: ");
        int studentAge = scanner.nextInt();
        
        try {
            // 🌟 கோர் லாஜிக்: வயது 18 க்கும் குறைவாக இருந்தால் நாமாகவே எரரை உருவாக்குறோம்
            if (studentAge < 18) {
                // throw கீவேர்ட் புதிய எக்ஸெப்ஷன் ஆப்ஜெக்ட்டை உருவாக்கி வெளியே வீசும்
                throw new IllegalArgumentException("Age restriction: Student must be 18 or older to register.");
            }
            
            // வயது 18 அல்லது அதற்கு மேல் இருந்தால் மட்டுமே இந்த வரி வேலை செய்யும்
            System.out.println("\nSUCCESS: Student registration approved! Welcome aboard.");
            
        } catch (IllegalArgumentException e) {
            // நாம் தூக்கி வீசிய எரரை இங்கே பாய்ந்து பிடிக்கிறோம்
            System.out.println("\n[REGISTRATION FAILED]: " + e.getMessage());
        }
        
        scanner.close();
    }
}