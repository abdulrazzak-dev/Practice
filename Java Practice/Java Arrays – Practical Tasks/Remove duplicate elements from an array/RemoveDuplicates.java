package array.java;

import java.util.Scanner;

/**
 * Program: Remove duplicate elements from a user-input array.
 * Description: Eliminates repetitive elements using pure array and nested loop logic without shortcut collections.
 * Standards followed: Proper indentation, descriptive variable names, clear comments, and resource safety.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        // இன்புட் வாங்க ஸ்கேனரைத் திறக்கிறோம்
        Scanner scanner = new Scanner(System.in);
        
        // 1. அரேயின் அளவை பயனரிடமிருந்து வாங்குகிறோம்
        System.out.print("Enter the number of elements in the array: ");
        int arraySize = scanner.nextInt();
        
        int[] numbers = new int[arraySize];
        
        // 2. அரேவிற்கான எண்களைப் பயனரிடமிருந்து வாங்குகிறோம்
        System.out.println("Enter the " + arraySize + " elements of the array (can include duplicates):");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Element at index [" + i + "]: ");
            numbers[i] = scanner.nextInt();
        }
        
        
       
        int unique = 0; 
        
        // 4. 🌟 கோர் லாஜிக்: டூப்ளிகேட்களைக் கண்டறிந்து நீக்குதல்
        for (int i = 0; i < arraySize; i++) {
            if (i != 0){
                  for (int j = 0; j < uniqueCount; j++)
                  numbers[i] == numbers[j];
                  numbers[j] = unique;
            }
            System.out.print("Cleaned Array  : [ ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(uniqueNumbers[i] + " ");         }
        System.out.println("]");
            
            // தற்போதைய எண் ஏற்கனவே uniqueNumbers அரேவில் இருக்கிறதா என்று தேடுகிறோம்
           
            
            // புதிய எண்ணாக இருந்தால் மட்டுமே uniqueNumbers அரேவிற்குள் சேர்க்கிறோம்
           
        
        // -----------------------------------------------------------------
        // பயனருக்குத் தெளிவாகப் புரியும் வகையிலான அவுட்புட் ஃபார்மேட்டிங் (User-friendly Output)
//         // -----------------------------------------------------------------
//         System.out.println("\n=========================================");
//         System.out.println("        DUPLICATE REMOVAL REPORT         ");
//         System.out.println("=========================================");
        
//         // அசல் அரேவை அச்சிடுதல்
//         System.out.print("Original Array : [ ");
//         for (int num : numbers) {
//             System.out.print(num + " ");
//         }
//         System.out.println("]");
        
//         System.out.println("-----------------------------------------");
        
//         // டூப்ளிகேட் நீக்கப்பட்ட புதிய அரேவை அச்சிடுதல்
//         System.out.print("Cleaned Array  : [ ");
//         for (int i = 0; i < uniqueCount; i++) {
//             System.out.print(uniqueNumbers[i] + " ");
//         }
//         System.out.println("]");
        
//         System.out.println("Total Unique Elements Found: " + uniqueCount);
//         System.out.println("=========================================");
        
//         // ஸ்கேனரைப் பத்திரமாக மூடுகிறோம்
//         scanner.close();
//     }
// }}}