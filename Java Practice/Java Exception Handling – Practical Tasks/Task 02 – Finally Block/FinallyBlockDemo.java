package assignment.exceptions;

import java.util.Scanner;

/**
 * Task 02: Demonstrate the mandatory execution of the 'finally' block.
 */
public class FinallyBlockDemo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter number 1: ");
            int number1 = scanner.nextInt();
            
            System.out.print("Enter number 2: ");
            int number2 = scanner.nextInt();
            
            int quotient = number1 / number2;
            System.out.println("Result: " + quotient);
            
        } catch (ArithmeticException e) {
            System.out.println("[ERROR Handled]: Cannot divide by zero.");
        } catch (Exception e) {
            System.out.println("[ERROR Handled]: Something went wrong.");
        } finally {
            // 🌟 விதி: எரர் வந்தாலும் வராவிட்டாலும் இந்த 'finally' கண்டிப்பாக ரன் ஆகும்!
            System.out.println("\n=========================================");
            System.out.println("      Program execution completed        ");
            System.out.println("=========================================");
            
            // ரிசோர்ஸ் லீக் ஆகாமல் தடுக்க ஸ்கேனரை மூடுகிறோம்
            scanner.close();
        }
    }
}