// package string.java;

import java.util.Scanner;

/**
 * Program: Count the frequency of each character in a string.
 * Description: Uses pure nested loops and a tracking array to find character occurrences without HashMap.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and resource safety.
 */
public class CharacterFrequencyCounter {

    public static void main(String[] args) {
        // பயனரிடமிருந்து டைனமிக்காக இன்புட் வாங்க ஸ்கேனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string or sentence: ");
        String sourceText = scanner.nextLine();
        
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
        System.out.println("        CHARACTER FREQUENCY REPORT       ");
        System.out.println("=========================================");
        System.out.println("Input Text : \"" + sourceText + "\"");
        System.out.println("-----------------------------------------");
        System.out.println(" Character  |  Frequency ");
        System.out.println("-----------------------------------------");
        
        for (int i = 0; i < textLength; i++) {
            // விசிட்டட் மார்க்கர் இல்லாத எண்களை மட்டும் அச்சிடுகிறோம்
            if (frequency[i] != visitedMarker) {
                // ஸ்பேஸ் (Space) வந்தால் அதைத் தனியாகக் காட்ட ஒரு சின்ன கண்டிஷன்
                if (characters[i] == ' ') {
                    System.out.println("  [Space]   |      " + frequency[i]);
                } else {
                    System.out.println("     " + characters[i] + "      |      " + frequency[i]);
                }
            }
        }
        System.out.println("=========================================");
        
        // 3. ஸ்கேனரைப் பத்திரமாக மூடுகிறோம் (Resource Safety)
        scanner.close();
    }
}