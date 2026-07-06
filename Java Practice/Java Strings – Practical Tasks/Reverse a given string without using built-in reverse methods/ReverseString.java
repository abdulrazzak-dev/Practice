package string.java;

import java.util.Scanner;

/**
 * Program: Reverse a given string without using any built-in reverse shortcut methods.
 * Description: Uses a backward for-loop and charAt() to reverse the string dynamically.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and resource safety.
 */
public class ReverseString {

    public static void main(String[] args) {
        // பயனரிடமிருந்து டைனமிக்காக இன்புட் வாங்க ஸ்கேனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string to reverse: ");
        String originalText = scanner.nextLine(); // வாக்கியங்களையும் வாங்க nextLine() பயன்படுத்துகிறோம்
        
        // 1. சப்மிஷன் நெறிமுறைகளின்படி இன்புட் வேலிடேஷன் செக்
        if (originalText == null || originalText.trim().isEmpty()) {
            System.out.println("Invalid input! Text cannot be empty. Program terminated.");
            scanner.close();
            return;
        }
        
        // 2. தலைகீழாக மாற்றிய வார்த்தையைச் சேமிக்க ஒரு காலி பெட்டி
        String reversedText = "";
        int textLength = originalText.length();
        
        // 3. 🌟 கோர் லாஜிக்: கடைசி எழுத்தில் இருந்து தொடங்கி பின்னோக்கி லூப் ஓட்டுகிறோம்
        for (int i = textLength - 1; i >= 0; i--) {
            // charAt(i) மூலம் கடைசி எழுத்துக்களை ஒவ்வொன்றாக எடுத்து இணைக்கிறோம்
            reversedText += originalText.charAt(i);
        }
        
        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான நேர்த்தியான அவுட்புட் ஃபார்மேட்டிங்
        // -----------------------------------------------------------------
        System.out.println("\n=========================================");
        System.out.println("            STRING REVERSE REPORT        ");
        System.out.println("=========================================");
        System.out.println("Original Text : " + originalText);
        System.out.println("Reversed Text : " + reversedText);
        System.out.println("=========================================");
        
        // 4. ஸ்கேனரைப் பத்திரமாக மூடுகிறோம் (Resource Safety)
        scanner.close();
    }
}