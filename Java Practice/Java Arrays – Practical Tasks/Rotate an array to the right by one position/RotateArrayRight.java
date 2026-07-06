package array.java;

import java.util.Scanner;


public class RotateArrayRight {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter the number of elements in the array: ");
        int arraySize = scanner.nextInt();
        
        
        if (arraySize <= 1) {
            System.out.println("Array size must be greater than 1 to perform rotation.");
            scanner.close();
            return;
        }
        
        int[] numbers = new int[arraySize];
        
        
        System.out.println("Enter the " + arraySize + " elements of the array:");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Element at index [" + i + "]: ");
            numbers[i] = scanner.nextInt();
        }
        
        
        System.out.println("\n=========================================");
        System.out.println("            ARRAY ROTATION REPORT        ");
        System.out.println("=========================================");
        
        System.out.print("Before Rotation : [ ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("]");
        
       
        int lastElement = numbers[arraySize - 1];
        
        
        for (int i = arraySize - 1; i > 0; i--) {
            
            numbers[i] = numbers[i - 1];
        }
        
       
        numbers[0] = lastElement;
        
       
        System.out.println("-----------------------------------------");
        System.out.print("After Rotation  : [ ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("]");
        System.out.println("=========================================");
        
        
        scanner.close();
    }
}