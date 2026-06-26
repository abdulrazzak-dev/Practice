import java.util.Scanner;
public class Even_odd{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int a = scan.nextInt();
        if(a%2==0){
            System.out.println("it is even number");
        
        }
        else{
            System.out.println("it is oddnumber");
        }
}