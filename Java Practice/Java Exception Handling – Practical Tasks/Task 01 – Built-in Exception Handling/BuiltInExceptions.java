package assignment.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Task 01: Handle ArithmeticException and InputMismatchException.
 * Standard: Clean try-catch blocks with descriptive error handling messages.
 */
public class BuiltInExceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 🌟 'try' பிளாக்கிற்குள் பிழை வர வாய்ப்புள்ள கோடுகளை வைக்கிறோம்
        try {
            System.out.print("Enter the numerator (Number 1): ");
            int numerator = scanner.nextInt();
            
            System.out.print("Enter the denominator (Number 2): ");
            int denominator = scanner.nextInt();
            
            // கோர் லாஜிக்: வகுத்தல் செயல்பாடு
            int result = numerator / denominator;
            System.out.println("\nSUCCESS: The result of division is: " + result);
            
        } catch (ArithmeticException e) {
            // பூஜ்ஜியத்தால் வகுக்க முயலும் போது இந்த பிளாக் வேலை செய்யும்
            System.out.println("\n[ERROR]: Division by zero is mathematically undefined!");
            
        } catch (InputMismatchException e) {
            // எண்களுக்குப் பதிலாக எழுத்துக்களைக் கொடுத்தால் இந்த பிளாக் வேலை செய்யும்
            System.out.println("\n[ERROR]: Invalid Input! Please enter integers (numbers) only.");
        }
        
        // ஸ்கேனரைப் பத்திரமாக மூடுகிறோம்
        scanner.close();
        System.out.println("\n[INFO]: Program continued gracefully after try-catch.");
    }
}