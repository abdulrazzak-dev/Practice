import java.util.Scanner;
public class CountEvenAndOdd{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("\n=========================================");
        System.out.println("        EVEN AND ODD COUNT REPORT        ");
        System.out.println("=========================================");
        
        System.out.print("Input Array    : [ ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("]");
        
        System.out.println("-----------------------------------------");
        System.out.println("Total Even Numbers Found: " + evenCount);
        System.out.println("Total Odd Numbers Found : " + oddCount);
        System.out.println("=========================================");
    }
} 