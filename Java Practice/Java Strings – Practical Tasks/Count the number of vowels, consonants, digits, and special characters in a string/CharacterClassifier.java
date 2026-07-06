package string.java;

import java.util.Scanner;

/**
 * Program: Count vowels, consonants, digits, and special characters in a string.
 * Description: Iterates through the string and uses core character range validation without shortcut methods.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and resource safety.
 */
public class CharacterClassifier{

    public static void main(String[] args) { 
        // பயனரிடமிருந்து டைனமிக்காக இன்புட் வாங்க ஸக்கீனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string or sentence: ");
        String sourceText = scanner.nextLine(); // ஸ்பேஸ் உள்ள வாக்கியங்களையும் வாங்க nextLine()
        
        // 1. சப்மிஷன் நெறிமுறைகளின்படி இன்புட் வேலிடேஷன் செக்
        if (sourceText == null || sourceText.isEmpty()) {
            System.out.println("Invalid input! Text cannot be empty. Program terminated.");
            scanner.close();
            return;
        }
        
        // 2. கேஸ்-சென்சிடிவ் சிக்கலைத் தவிர்க்க முழுமையாக சிறிய எழுத்துகளாக மாற்றுகிறோம்
        String processedText = sourceText.toLowerCase();
        
        // தனித்தனி கூடைகளுக்கான கவுண்ட்டர் வேரியபிள்கள்
        int vowelCount = 0;
        int consonantCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        
        int textLength = processedText.length();
        
        // 3. 🌟 கோர் லாஜிக்: லூப் மூலம் ஒவ்வொரு எழுத்தையும் வகைப்படுத்துதல்
        for (int i = 0; i < textLength; i++) {
            char currentCharacter = processedText.charAt(i);
            
            // கேஸ் ஏ: அது ஒரு ஆங்கில எழுத்தாக (Alphabet) இருந்தால்
            if (currentCharacter >= 'a' && currentCharacter <= 'z') {
                
                // அது உயிரெழுத்தா (Vowel) என்று பார்க்கிறோம்
                if (currentCharacter == 'a' || currentCharacter == 'e' || currentCharacter == 'i' 
                    || currentCharacter == 'o' || currentCharacter == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++; // உயிரெழுத்து இல்லை எனில் அது மெய்யெழுத்து (Consonant)
                }
            } 
            // கேஸ் பி: அது ஒரு எண்ணாக (Digit) இருந்தால்
            else if (currentCharacter >= '0' && currentCharacter <= '9') {
                digitCount++;
            } 
            // கேஸ் சி: ஸ்பேஸ் மற்றும் குறியீடுகள் அத்தனையையும் ஸ்பெஷல் கேரக்டராகக் கருதுகிறோம்
            else {
                specialCharCount++;
            }
        }
        
        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான நேர்த்தியான அவுட்புட் ஃபார்மேட்டிங்
        // -----------------------------------------------------------------
        System.out.println("\n=========================================");
        System.out.println("          CHARACTER ANALYSIS REPORT      ");
        System.out.println("=========================================");
        System.out.println("Input Text : \"" + sourceText + "\"");
        System.out.println("-----------------------------------------");
        System.out.println(" Vowels Total             : " + vowelCount);
        System.out.println(" Consonants Total         : " + consonantCount);
        System.out.println(" Digits Total             : " + digitCount);
        System.out.println(" Special Characters Total : " + specialCharCount);
        System.out.println("=========================================");
        
        // 4. ஸ்கேனரைப் பத்திரமாக மூடுகிறோம் (Resource Safety)
        scanner.close();
    }
}