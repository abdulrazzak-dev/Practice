import java.util.Scanner;
public class AddEven{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = scan.nextInt();
        int i = 0;
        int Sum = 0;
        while(i<=n){
        Sum = Sum + i;
        i = i + 2;
        }System.out.println("Totel sum of even number : " + Sum);
    }
}