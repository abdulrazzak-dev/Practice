package SecondLargest.java;

import java.util.Scanner;
public class SecondLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        long[] arr = new long[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        long SecondLargest = arr[0];
        long largest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                SecondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > SecondLargest && arr[i] != largest) {
                SecondLargest = arr[i];
            }
        }
        System.out.println("The second largest element in the array is: " + SecondLargest);
        scanner.close();
    }
}