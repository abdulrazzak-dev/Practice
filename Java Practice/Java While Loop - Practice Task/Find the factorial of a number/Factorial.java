import java.util.Scanner;
public class Factorial{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = scan.nextInt();
        int i = 1;
        long factoral = 1;
        while(i<=n){
        factoral = factoral * i;
        i = i + 1;
        }System.out.println("Factoral number : " + factoral);
    }
}