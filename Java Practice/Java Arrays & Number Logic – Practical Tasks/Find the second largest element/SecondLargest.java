import java.util.Scanner;
public class SecondLargest{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arraysize = scan.nextInt();
        int array[] = new int[arraysize];
        
        for(int i=0;i<arraysize;i++){
             System.out.print("Enter the array size : ");
             array[i] = scan.nextInt();
             
        }
        if (arraysize <= 1) {
            System.out.println("Array must have at least two elements to find the second largest. Program terminated.");
            scan.close();
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0;i<arraysize;i++){
            if(array[i] > largest){
                secondLargest = largest;
                largest = array[i];
            } else if(array[i] > secondLargest && array[i] != largest){
                secondLargest = array[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element in the array.");
        } else {
            System.out.println("\n=========================================");
            System.out.println("         SECOND LARGEST VALUE REPORT     ");
            System.out.println("=========================================");
            
            System.out.print("Input Array    : [ ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("]");
            
            System.out.println("-----------------------------------------");
            System.out.println("The Second Largest Element in the Array is: " + secondLargest);
            System.out.println("=========================================");
        }
    }
}