package SmallestElement.java;

import java.util.Scanner;
public class SmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        long[] arr = new long[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        long smallest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println("The smallest element in the array is: " + smallest);
        scanner.close();
    }
}