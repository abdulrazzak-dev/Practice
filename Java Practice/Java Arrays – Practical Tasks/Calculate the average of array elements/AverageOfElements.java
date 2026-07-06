package AverageOfElements.java;

import java.util.Scanner;
public class AverageOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        long[] arr = new long[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double average = sum / n;
        System.out.println("The average of all elements in the array is: " + average);
        scanner.close();
    }
}

       
