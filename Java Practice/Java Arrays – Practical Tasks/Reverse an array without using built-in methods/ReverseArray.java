package array.java;

import java.util.Scanner;


public class ReverseArray {

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
        
       
        System.out.println("\n=========================================");
        System.out.println("            ARRAY REVERSE REPORT         ");
        System.out.println("=========================================");
        
        System.out.print("Original Array : [ ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("]");
        
       
        int start = 0;
        int end = arraySize - 1;
        
       
        while (start < end) {
           
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            
           
            start++;
            end--;
        }
        
        
        System.out.println("-----------------------------------------");
        System.out.print("Reversed Array : [ ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("]");
        System.out.println("=========================================");
        
        
        scanner.close();
    }
}