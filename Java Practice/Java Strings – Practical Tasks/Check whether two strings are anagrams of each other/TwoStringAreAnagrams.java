import java.util.Scanner;
public class TwoStringAreAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }

    public static boolean areAnagrams(String str1, String str2) {
        String cleanedStr1 = str1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String cleanedStr2 = str2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (cleanedStr1.length() != cleanedStr2.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for (char c : cleanedStr1.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : cleanedStr2.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}