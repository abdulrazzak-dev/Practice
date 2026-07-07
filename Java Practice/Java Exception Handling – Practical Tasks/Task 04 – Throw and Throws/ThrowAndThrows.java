package assignment.exceptions;

import java.util.Scanner;

/**
 * Task 04: Demonstrate Exception propagation using 'throw' and 'throws' keywords.
 */
public class ThrowAndThrows{

    /**
     * 🌟 'throws Exception' என்பது இந்த மெத்தடை அழைப்பவர்களுக்குச் சொல்லும் எச்சரிக்கை பத்திரம்!
     * "என்னுள் எரர் வர வாய்ப்புள்ளது, என்னை அழைக்கும் இடத்தில் try-catch போடுங்கள்."
     */
    public static void checkPositiveNumber(int number) throws Exception {
        if (number < 0) {
            // மைனஸ் எண் வந்தால் Checked Exception-ஐ தூக்கி எறிகிறோம்
            throw new Exception("Negative numbers are strict restrictions in this operation!");
        }
        System.out.println("SUCCESS: " + number + " is a valid positive number.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter any number to validate: ");
        int userInput = scanner.nextInt();
        
        // 🌟 Calling Method-ஆன மெயின் மெத்தடிற்குள் எரரைத் துல்லியமாகக் கையாளுகிறோம்
        try {
            checkPositiveNumber(userInput);
        } catch (Exception e) {
            // மெத்தடில் இருந்து தப்பித்து வந்த எரர் இங்கே பிடிபடுகிறது
            System.out.println("\n[CAUGHT EXCEPTION]: " + e.getMessage());
        }
        
        scanner.close();
        System.out.println("[INFO]: Validation process ended successfully.");
    }
}