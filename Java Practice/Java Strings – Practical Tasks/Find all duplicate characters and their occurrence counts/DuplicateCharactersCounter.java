package string.java;

import java.util.Scanner;

/**
 * Program: Find all duplicate characters and their occurrence counts in a string.
 * Description: Uses pure nested loops and a tracking array to isolate duplicate characters without using HashMap.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and resource safety.
 */
public class DuplicateCharactersCounter {

    public static void main(String[] args) {
        // பயனரிடமிருந்து டைனமிக்காக இன்புட் வாங்க ஸ்கேனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string or sentence: ");
        String sourceText = scanner.nextLine(); // ஸ்பேஸ் உள்ள வாக்கியங்களையும் வாங்க nextLine()
        
        // 1. சப்மிஷன் நெறிமுறைகளின்படி இன்புட் வேலிடேஷன் செக்
        if (sourceText == null || sourceText.trim().isEmpty()) {
            System.out.println("Invalid input! Text cannot be empty. Program terminated.");
            scanner.close();
            return;
        }
        
        int textLength = sourceText.length();
        
        // ஸ்ட்ரிங்கை கேரக்டர் அரேவாக மாற்றுகிறோம்
        char[] characters = sourceText.toCharArray();
        
        // ஒவ்வொரு எழுத்தின் எண்ணிக்கையைச் சேமிக்க ஒரு அரே
        int[] frequency = new int[textLength];
        
        // ஏற்கனவே எண்ணப்பட்ட எழுத்துக்களைக் குறிக்க ஒரு விசிட்டட் (Visited) மார்க்கர்
        int visitedMarker = -1;
        
        // 2. 🌟 கோர் லாஜிக்: நெஸ்டட் லூப் மூலம் ஒவ்வொரு எழுத்தையும் ஒப்பிடுதல்
        for (int i = 0; i < textLength; i++) {
            int currentCount = 1; // ஒவ்வொரு எழுத்தும் குறைந்தபட்சம் 1 முறை இருக்கும்
            
            // இந்த எழுத்தை ஏற்கனவே நாம் எண்ணியிருந்தால், இதைத் தவிர்த்துவிட்டு அடுத்த எழுத்திற்குச் செல்வோம்
            if (frequency[i] == visitedMarker) {
                continue;
            }
            
            // தற்போதைய எழுத்திற்கு அடுத்து வரும் பெட்டிகளில் அதே எழுத்து இருக்கிறதா என்று தேடுகிறோம்
            for (int j = i + 1; j < textLength; j++) {
                if (characters[i] == characters[j]) {
                    currentCount++;
                    // மீண்டும் இந்த எழுத்தை எண்ணக் கூடாது என்பதால் 'visited' என மார்க் செய்கிறோம்
                    frequency[j] = visitedMarker;
                }
            }
            
            // தற்போதைய எழுத்தின் இறுதி எண்ணிக்கையை அதன் இன்டெக்ஸில் சேமிக்கிறோம்
            frequency[i] = currentCount;
        }
        
        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான நேர்த்தியான அவுட்புட் ஃபார்மேட்டிங்
        // -----------------------------------------------------------------
        System.out.println("\n=========================================");
        System.out.println("        DUPLICATE CHARACTERS REPORT      ");
        System.out.println("=========================================");
        System.out.println("Input Text : \"" + sourceText + "\"");
        System.out.println("-----------------------------------------");
        System.out.println(" Character  |  Occurrence Count ");
        System.out.println("-----------------------------------------");
        
        boolean hasDuplicates = false;
        
        for (int i = 0; i < textLength; i++) {
            // 🌟 விசிட்டட் மார்க்கர் இல்லாத மற்றும் எண்ணிக்கை 1 ஐ விட அதிகமாக (> 1) உள்ளவற்றை மட்டும் அச்சிடுகிறோம்
            if (frequency[i] != visitedMarker && frequency[i] > 1) {
                hasDuplicates = true;
                
                // ஸ்பேஸ் (Space) டூப்ளிகேட்டாக வந்தால் அதைத் தெளிவாகக் காட்ட ஒரு சின்ன கண்டிஷன்
                if (characters[i] == ' ') {
                    System.out.println("  [Space]   |          " + frequency[i]);
                } else {
                    System.out.println("     " + characters[i] + "      |          " + frequency[i]);
                }
            }
        }
        
        // ஒருவேளை வார்த்தையில் டூப்ளிகேட் எழுத்துக்களே இல்லை என்றால்
        if (!hasDuplicates) {
            System.out.println("     None   |   All characters are unique.");
        }
        
        System.out.println("=========================================");
        
        // 3. ஸ்கேனரைப் பத்திரமாக மூடுகிறோம் (Resource Safety)
        scanner.close();
    }
}