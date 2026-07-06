package SearchForSpecificElement.java;

import java.util.Scanner;

public class SearchForSpecificElement {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter the number of elements in the array: ");
        int arraySize = scanner.nextInt();
        
        
        int[] numbers = new int[arraySize];
        
        
        System.out.println("Enter the " + arraySize + " elements of the array:");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Element at index [" + i + "]: ");
            numbers[i] = scanner.nextInt();
        }
        
        
        System.out.print("\nEnter the specific element to search for: ");
        int targetElement = scanner.nextInt();
        
        boolean isElementFound = false;
        int targetIndexPosition = -1; 
        
        
        for (int i = 0; i < arraySize; i++) {
            if (numbers[i] == targetElement) {
                isElementFound = true;
                targetIndexPosition = i; 
                break; 
            }
        }
        
       
        System.out.println("\n=========================================");
        System.out.println("            SEARCH RESULT                ");
        System.out.println("=========================================");
        
        if (isElementFound) {
            System.out.println("SUCCESS: Element " + targetElement + " found in the array!");
            System.out.println("Located at Index Position: " + targetIndexPosition);
        } else {
            System.out.println("FAILED: Element " + targetElement + " not found in the array.");
        }
        System.out.println("=========================================");
        
       
        scanner.close();
    }
}
// package SearchForSpecificElement.java;

// import java.util.Scanner;
// public class SearchForSpecificElement {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter the number of elements in the array: ");
//         int n = scanner.nextInt();
//         int[] arr = new int[n];
//         System.out.println("Enter the elements of the array:");
//         for (int i = 0; i < n; i++) {
//             arr[i] = scanner.nextInt();
//         }
//         System.out.print("Enter the element to search for: ");
//         int target = scanner.nextInt();
//         boolean found = false;
//         for (int i = 0; i < n; i++) {
//             if (arr[i] == target) {
//                 found = true;
//                 break;
//             }
//         }
//         if (found) {
//             System.out.println("Element found in the array.");
//         } else {
//             System.out.println("Element not found in the array.");
//         }
//         scanner.close();
//     }
// }

