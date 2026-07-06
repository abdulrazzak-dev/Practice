package string.java;

import java.util.Scanner;

/**
 * Program: Remove duplicate characters from a string while preserving the original order.
 * Description: Scans the string and builds a unique result string using indexOf validation without LinkedHashSet.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and resource safety.
 */
public class RemoveDuplicatesPreserveOrder {

    public static void main(String[] args) {
        // பயனரிடமிருந்து டைனமிக்காக இன்புட் வாங்க ஸ்கேனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string or sentence: ");
        String sourceText = scanner.nextLine(); // ஸ்பேஸ் உள்ள வாக்கியங்களையும் வாங்க nextLine()
        
        // 1. சப்மிஷன் நெறிமுறைகளின்படி இன்புட் வேலிடேஷன் செக்
        if (sourceText == null || sourceText.isEmpty()) {
            System.out.println("Invalid input! Text cannot be empty. Program terminated.");
            scanner.close();
            return;
        }
        
        // டூப்ளிகேட் இல்லாத இறுதி வார்த்தையைச் சேமிக்க ஒரு காலி பெட்டி
        String resultText = "";
        int textLength = sourceText.length();
        
        // 2. 🌟 கோர் லாஜிக்: லூப் மூலம் ஒவ்வொரு எழுத்தாக எடுத்து தனித்துவத்தை சோதிக்கிறோம்
        for (int i = 0; i < textLength; i++) {
            char currentCharacter = sourceText.charAt(i);
            
            // தற்போதைய எழுத்து நமது 'resultText' பெட்டிக்குள் இருக்கிறதா என்று பார்க்கிறோம்
            // -1 வந்தால் அந்த எழுத்து இன்னும் சேர்க்கப்படவில்லை (தனித்துவமானது) என்று அர்த்தம்
            if (resultText.indexOf(currentCharacter) == -1) {
                resultText += currentCharacter; // தனித்துவமான எழுத்தை மட்டும் வரிசைப்படி இணைக்கிறோம்
            }
        }
        
        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான நேர்த்தியான அவுட்புட் ஃபார்மேட்டிங்
        // -----------------------------------------------------------------
        System.out.println("\n=========================================");
        System.out.println("        REMOVE DUPLICATES REPORT         ");
        System.out.println("=========================================");
        System.out.println("Original Text : \"" + sourceText + "\"");
        System.out.println("-----------------------------------------");
        System.out.println("Cleaned Text  : \"" + resultText + "\"");
        System.out.println("=========================================");
        
        // 3. ஸ்கேனரைப் பத்திரமாக மூடுகிறோம் (Resource Safety)
        scanner.close();
    }
}
// ஒரு எளிய உதாரணம் (Dry Run - "apple")
// ஆரம்பத்தில் resultText = "" (காலியாக உள்ளது).

// சுழற்சி 1 ('a'): resultText.indexOf('a') என்று தேடும். அது காலியாக இருப்பதால் -1 என்று வரும். நிபந்தனை உண்மை (True)! எனவே 'a' உள்ளே சேர்க்கப்படும்.
// 👉 resultText இப்போது = "a"

// சுழற்சி 2 ('p'): resultText.indexOf('p') என்று தேடும். "a"-க்குள் 'p' இல்லை, எனவே -1 வரும்.
// 👉 resultText இப்போது = "ap"

// சுழற்சி 3 (இரண்டாவது 'p'): resultText.indexOf('p') என்று தேடும். இப்போது "ap" என்ற வார்த்தையில் 'p' ஏற்கனவே 1-வது இடத்தில் இருக்கிறது! அதனால் விடை 1 என்று வரும், -1 வராது. நிபந்தனை பொய் (False) ஆகிறது. எனவே இந்த 'p' தவிர்க்கப்படும் (Skip செய்யப்படும்).
// 👉 resultText மாறாமல் அப்படியே இருக்கும் = "ap"

// சுழற்சி 4 ('l'): "ap"-க்குள் 'l' இல்லை (-1 வரும்). உள்ளே சேரும்.
// 👉 resultText இப்போது = "apl"

// சுழற்சி 5 ('e'): "apl"-க்குள் 'e' இல்லை (-1 வரும்). உள்ளே சேரும்.
// 👉 resultText இறுதி விடை = "aple"