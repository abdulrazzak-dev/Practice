package string.java;

import java.util.Scanner;

/**
 * Program: Find the longest word in a given sentence.
 * Description: Splits a sentence into words and finds the maximum length word using a loop without Stream shortcuts.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and resource safety.
 */
public class FindLongestWord {

    public static void main(String[] args) {
        // பயனரிடமிருந்து டைனமிக்காக இன்புட் வாங்க ஸ்கேனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String inputSentence = scanner.nextLine(); // வாக்கியங்களை வாங்க nextLine()
        
        // 1. சப்மிஷன் நெறிமுறைகளின்படி இன்புட் வேலிடேஷன் செக்
        if (inputSentence == null || inputSentence.trim().isEmpty()) {
            System.out.println("Invalid input! Sentence cannot be empty. Program terminated.");
            scanner.close();
            return;
        }
        
        // 2. வாக்கியத்தை ஸ்பேஸ் (Space) கொண்டு தனித்தனி வார்த்தைகளாகப் பிரிக்கிறோம்
        String[] words = inputSentence.split(" ");
        
        // மிக நீளமான வார்த்தையைச் சேமிக்க ஒரு தற்காலிக பெட்டி
        String longestWord = "";
        
        // 3. 🌟 கோர் லாஜிக்: லூப் மூலம் ஒவ்வொரு வார்த்தையின் நீளத்தையும் ஒப்பிடுதல்
        for (String currentWord : words) {
            
            // ஒருவேளை வாக்கியத்தில் தொடர்ச்சியாக இரண்டு ஸ்பேஸ் இருந்தால் காலி ஸ்ட்ரிங் வரும், அதைத் தவிர்க்கிறோம்
            if (!currentWord.isEmpty()) {
                
                // தற்போதைய வார்த்தையின் நீளம், நாம் ஏற்கனவே வைத்துள்ள வார்த்தையின் நீளத்தை விடப் பெரியதா எனப் பார்க்கிறோம்
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord; // புதிய பெரிய வார்த்தையை பெட்டிக்குள் மாற்றுகிறோம்
                }
            }
        }
        
        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான நேர்த்தியான அவுட்புட் ஃபார்மேட்டிங்
        // -----------------------------------------------------------------
        System.out.println("\n=========================================");
        System.out.println("            LONGEST WORD REPORT          ");
        System.out.println("=========================================");
        System.out.println("Input Sentence : \"" + inputSentence + "\"");
        System.out.println("-----------------------------------------");
        
        if (!longestWord.isEmpty()) {
            System.out.println("The Longest Word is      : \"" + longestWord + "\"");
            System.out.println("Length of the Word is    : " + longestWord.length() + " characters.");
        } else {
            System.out.println("RESULT: No valid words found.");
        }
        System.out.println("=========================================");
        
        // 4. ஸ்கேனரைப் பத்திரமாக மூடுகிறோம் (Resource Safety)
        scanner.close();
    }
}