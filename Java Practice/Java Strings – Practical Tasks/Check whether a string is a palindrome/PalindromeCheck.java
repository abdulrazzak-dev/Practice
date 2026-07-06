package assignment.strings;

import java.util.Scanner;

/**
 * Check whether a string is a palindrome using two-pointer approach.
 */
public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word to check for Palindrome: ");
        String inputWord = scanner.next();
        
        // கேஸ்-சென்சிடிவ் சிக்கலைத் தவிர்க்க லோயர்கேஸாக மாற்றுகிறோம்
        String processedWord = inputWord.toLowerCase();
        
        int start = 0;
        int end = processedWord.length() - 1;
        boolean isPalindrome = true;
        
        // கோர் லாஜிக்: இரு முனைகளில் இருந்தும் கேரக்டர்களை ஒப்பிடுதல்
        while (start < end) {
            if (processedWord.charAt(start) != processedWord.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        
        System.out.println("\n=========================================");
        System.out.println("            PALINDROME REPORT            ");
        System.out.println("=========================================");
        if (isPalindrome) {
            System.out.println("RESULT: \"" + inputWord + "\" is a PALINDROME!");
        } else {
            System.out.println("RESULT: \"" + inputWord + "\" is NOT a palindrome.");
        }
        System.out.println("=========================================");
        
        scanner.close();
    }
}