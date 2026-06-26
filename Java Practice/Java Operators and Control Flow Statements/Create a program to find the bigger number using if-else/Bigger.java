import java.util.Scanner;
public class Bigger{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int a = scan.nextInt();
        System.out.print("Enter a value: ");
        int b = scan.nextInt();
        if(a>b){
            System.out.println("Largest Number : " + a);
        }
        else if (b>a){
            System.out.println("Largest Number : " + b);
        }
        else{
            System.out.println("Both numbers are Equal");
        }
    }
}