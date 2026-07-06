import java.util.Scanner;
public class RemoveDuplicateElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arraysize = scan.nextInt();
        int array[] = new int[arraysize];

        for (int i = 0; i < arraysize; i++) {
            System.out.print("Enter the array element: ");
            array[i] = scan.nextInt();
        }

        if (arraysize <= 0) {
            System.out.println("Invalid array size! Program terminated.");
            scan.close();
            return;
        }

        int[] tempArray = new int[arraysize];
        int uniqueCount = 0;

        for (int i = 0; i < arraysize; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (array[i] == tempArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                tempArray[uniqueCount] = array[i];
                uniqueCount++;
            }
        }

        System.out.println("\n=========================================");
        System.out.println("         REMOVE DUPLICATE REPORT         ");
        System.out.println("=========================================");

        System.out.print("Input Array    : [ ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        System.out.print("Unique Elements: [ ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(tempArray[i] + " ");
        }
        System.out.println("]");

        System.out.println("=========================================");
    }
}