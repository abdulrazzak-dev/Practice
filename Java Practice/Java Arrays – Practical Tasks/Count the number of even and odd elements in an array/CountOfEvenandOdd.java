package CountOfEvenandOdd.java;

import java.util.Scanner;
public class CountOfEvenandOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int EvenNum = 0;
        int OddNum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                EvenNum++;
            } else {
                OddNum++;
            }
        }
        System.out.println("The number of even elements in the array is: " + EvenNum);
        System.out.println("The number of odd elements in the array is: " + OddNum);
        scanner.close();
    }
}