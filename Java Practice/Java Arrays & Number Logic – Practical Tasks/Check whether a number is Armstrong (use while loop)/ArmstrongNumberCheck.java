package array.logic;

import java.util.Scanner;

/**
 * Program: Check whether a given number is an Armstrong Number.
 * Description: Dynamically counts digits and calculates the power sum using while loops.
 * Standards followed: Proper indentation, descriptive variable names, and core logic.
 */
public class ArmstrongNumberCheck {

    public static void main(String[] args) {
        // பயனரிடமிருந்து இன்புட் வாங்க ஸ்கேனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer to check: ");
        int inputNumber = scanner.nextInt();
        
        // அசல் எண் மாறாமல் இருக்க தற்காலிக வேரியபிள்களில் நகலெடுக்கிறோம்
        int tempForDigits = inputNumber;
        int tempForSum = inputNumber;
        
        int numberOfDigits = 0;
        int totalSum = 0;
        
        // 1. 🌟 முதல் while லூப்: எண்ணின் மொத்த இலக்கங்களின் எண்ணிக்கையைக் கணக்கிடுதல்
        while (tempForDigits != 0) {
            numberOfDigits++;
            tempForDigits = tempForDigits / 10; // கடைசி இலக்கத்தை நீக்குகிறது
        }
        
        // 2. 🌟 இரண்டாவது while லூப்: ஒவ்வொரு இலக்கத்தின் அடுக்கைக் கணக்கிட்டுக் கூட்டுதல்
        while (tempForSum != 0) {
            int lastDigit = tempForSum % 10; // கடைசி இலக்கத்தைப் பிரித்தெடுக்கிறது
            
            // எந்த பில்ட்-இன் ஷார்ட்கட்டும் (Math.pow) இல்லாமல் நாமாகவே பவர் கணக்கிடுகிறோம்
            int digitPower = 1;
            for (int i = 1; i <= numberOfDigits; i++) {
                digitPower *= lastDigit;
            }
            
            totalSum += digitPower; // கூட்டுத்தொகையுடன் சேர்க்கிறோம்
            tempForSum = tempForSum / 10; // அடுத்த இலக்கத்திற்கு நகர்கிறோம்
        }
        
        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான அவுட்புட் ஃபார்மேட்டிங் (User-friendly Output)
        // -----------------------------------------------------------------
        System.out.println("\n=========================================");
        System.out.println("        ARMSTRONG NUMBER REPORT          ");
        System.out.println("=========================================");
        System.out.println("Input Number      : " + inputNumber);
        System.out.println("Total Digits Found: " + numberOfDigits);
        System.out.println("Calculated Sum    : " + totalSum);
        System.out.println("-----------------------------------------");
        
        // அசல் எண்ணும் கூட்டுத்தொகையும் சமமா என்று ஒப்பிடுகிறோம்
        if (totalSum == inputNumber) {
            System.out.println("RESULT: " + inputNumber + " is an ARMSTRONG number.");
        } else {
            System.out.println("RESULT: " + inputNumber + " is NOT an Armstrong number.");
        }
        System.out.println("=========================================");
        
        // ஸ்கேனரைப் பத்திரமாக மூடுகிறோம்
        scanner.close();
    }
}