import java.util.Scanner;
public class ReverseAnArray{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int arraysize = scan.nextInt();
        int array[] = new int[arraysize];
        
        for(int i=0;i<arraysize;i++){
             System.out.print("Enter the array size : ");
             array[i] = scan.nextInt();
             
        }
        if (arraysize <= 0) {
            System.out.println("Invalid array size! Program terminated.");
            scan.close();
            return;
        }

        System.out.println("\n=========================================");
        System.out.println("            REVERSE ARRAY REPORT         ");
        System.out.println("=========================================");
        
        System.out.print("Input Array    : [ ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("]");
        
        System.out.print("Reversed Array : [ ");
        for(int i=arraysize-1;i>=0;i--){
            System.out.print(array[i] + " ");
            
        }
        System.out.println("]");
        
        System.out.println("=========================================");
    }
}