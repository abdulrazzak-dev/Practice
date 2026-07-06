package string.java;

import java.util.Scanner;

/**
 * Program: Reverse the order of words in a sentence without reversing the words themselves.
 * Description: Splits a sentence into a word array and iterates backwards to build the reversed sentence.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and resource safety.
 */
public class ReverseWordOrder {

    public static void main(String[] args) {
        // பயனரிடமிருந்து டைனமிக்காக இன்புட் வாங்க ஸ்கேனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String inputSentence = scanner.nextLine(); // வாக்கியங்களை வாங்க nextLine() பயன்படுத்துகிறோம்
        
        // 1. சப்மிஷன் நெறிமுறைகளின்படி இன்புட் வேலிடேஷன் செக்
        if (inputSentence == null || inputSentence.trim().isEmpty()) {
            System.out.println("Invalid input! Sentence cannot be empty. Program terminated.");
            scanner.close();
            return;
        }
        
        // 2. வாக்கியத்தை ஸ்பேஸ் (Space) கொண்டு தனித்தனி வார்த்தைகளாகப் பிரிக்கிறோம்
        String[] words = inputSentence.split(" ");
        
        // தலைகீழாக மாற்றிய வாக்கியத்தைச் சேமிக்க ஒரு காலி பெட்டி
        String reversedSentence = "";
        int totalWords = words.length;
        
        // 3. 🌟 கோர் லாஜிக்: கடைசி வார்த்தையில் இருந்து தொடங்கி பின்னோக்கி லூப் ஓட்டுகிறோம்
        for (int i = totalWords - 1; i >= 0; i--) {
            // ஒருவேளை வாக்கியத்தில் தொடர்ச்சியாக இரண்டு ஸ்பேஸ் இருந்தால் காலி ஸ்ட்ரிங் வரும், அதைத் தவிர்க்கிறோம்
            if (!words[i].isEmpty()) {
                // வார்த்தையையும் கூடவே ஒரு ஸ்பேஸையும் இணைக்கிறோம்
                reversedSentence += words[i] + " ";
            }
        }
        
        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான நேர்த்தியான அவுட்புட் ஃபார்மேட்டிங்
        // -----------------------------------------------------------------
        System.out.println("\n=========================================");
        System.out.println("            REVERSE WORD ORDER REPORT     ");
        System.out.println("=========================================");
        System.out.println("Original Sentence : \"" + inputSentence + "\"");
        System.out.println("-----------------------------------------");
        
        // .trim() மெத்தட் இறுதியில் தேவையில்லாமல் வரும் ஸ்பேஸை நீக்கப் பயன்படுகிறது
        System.out.println("Reversed Sentence : \"" + reversedSentence.trim() + "\"");
        System.out.println("=========================================");
        
        // 4. ஸ்கேனரைப் பத்திரமாக மூடுகிறோம் (Resource Safety)
        scanner.close();
    }
}