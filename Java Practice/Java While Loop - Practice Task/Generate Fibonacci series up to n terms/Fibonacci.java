import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       System.out.print("Enter the number : ");
       int n = scan.nextInt();
       int first = 0;
       int secand = 1;
       int tired;
       int i = 1;
       System.out.print(n + "th Fibonacci Numbers : ");
       while(i<=n){
        System.out.print( first + ",");
        tired = first + secand;
        //
        first = secand;
        secand = tired;
        i++;
       }

    }
}