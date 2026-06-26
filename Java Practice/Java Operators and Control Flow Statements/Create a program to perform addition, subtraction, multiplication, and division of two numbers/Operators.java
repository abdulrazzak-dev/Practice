import java.util.Scanner;
public class Operators{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int a = scan.nextInt();
        System.out.print("Enter a value: ");
        int b = scan.nextInt();
        int c = a + b;
        int d = a*b;
        int e = a - b;
        int f = a/b;

          System.out.println("Two numbers addition :" + c);
          System.out.println("Two numbers multpiction :" + d);
          System.out.println("Two numbers subtractoin :" + e);
          System.out.println("Two numbers division :" + f); 
        
    }
}