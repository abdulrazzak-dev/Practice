package string.java;

import java.util.Scanner;

/**
 * Program: Find the first non-repeated character in a string.
 * Description: Scans the string using nested loops to isolate the first unique character without using LinkedHashMap.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and resource safety.
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) { 
        // பயனரிடமிருந்து டைனமிக்காக இன்புட் வாங்க ஸ்கேனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string or word: ");
        String sourceText = scanner.next(); // ஒரே ஒரு வார்த்தையை வாங்க next()
        
        // 1. சப்மிஷன் நெறிமுறைகளின்படி இன்புட் வேலிடேஷன் செக்
        if (sourceText == null || sourceText.trim().isEmpty()) {
            System.out.println("Invalid input! Text cannot be empty. Program terminated.");
            scanner.close();
            return;
        }
        
        int textLength = sourceText.length();
        boolean uniqueFound = false;
        char uniqueCharacter = ' ';
        
        // 2. 🌟 கோர் லாஜிக்: வெளிப்புற லூப் ஒவ்வொரு எழுத்தாகத் தேர்ந்தெடுக்கும்
        for (int i = 0; i < textLength; i++) {
            char currentCharacter = sourceText.charAt(i);
            boolean isRepeated = false;
            
            // உள் லூப் தற்போதைய எழுத்தை முழு வார்த்தையுடன் ஒப்பிட்டுப் பார்க்கும்
            for (int j = 0; j < textLength; j++) {
                // தன் இன்டெக்ஸைத் தவிர (i != j) வேறு எங்கும் அதே எழுத்து இருக்கிறதா என்று பார்க்கிறோம்
                if (i != j && currentCharacter == sourceText.charAt(j)) {
                    isRepeated = true; // மீண்டும் வந்துவிட்டது!
                   break; // டூப்ளிகேட் உறுதியாகிவிட்டதால் உள் லூப்பை நிறுத்துகிறோம்
                }
            }
            
            // ஒருவேளை முழு லூப் ஓடியும் இந்த எழுத்து மீண்டும் வரவில்லை என்றால்
            if (!isRepeated) {
                uniqueCharacter = currentCharacter;
                uniqueFound = true;
                break; // முதன்முதலில் வந்த தனித்துவமான எழுத்து கிடைத்துவிட்டதால் மெயின் லூப்பை நிறுத்துகிறோம்
            }
        }
        
        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான நேர்த்தியான அவுட்புட் ஃபார்மேட்டிங்
        // -----------------------------------------------------------------
        System.out.println("\n=========================================");
        System.out.println("      FIRST UNIQUE CHARACTER REPORT      ");
        System.out.println("=========================================");
        System.out.println("Input Text : \"" + sourceText + "\"");
        System.out.println("-----------------------------------------");
        
        if (uniqueFound) {
            System.out.println("RESULT: The first non-repeated character is: '" + uniqueCharacter + "'");
        } else {
            System.out.println("RESULT: All characters are repeated or no unique character found.");
        }
        System.out.println("=========================================");
        
        // 3. ஸ்கேனரைப் பத்திரமாக மூடுகிறோம் (Resource Safety)
        scanner.close();
    }
}