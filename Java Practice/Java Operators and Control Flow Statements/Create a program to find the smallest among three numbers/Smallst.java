import java.util.Scanner;
public class Smallst{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int a = scan.nextInt();
        System.out.print("Enter the number : ");
        int b = scan.nextInt();
        System.out.print("Enter the number : ");
        int c = scan.nextInt();
        if(a<b && a<c){
            System.out.print(a + " is the smallest number");
        }
        else if(b<a && b<c){
            System.out.print(b + " is the smallest number");
        }
        else if(c<a && c<b){
            System.out.print(c + " is the smallest number");
        }
        
        else{
            System.out.print( "All are Equal");
        }
    }
}