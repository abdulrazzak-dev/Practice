import java.util.Scanner;
public class Negativ{
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the number : ");
    int a = scan.nextInt();

    if(a<0){
        System.out.println(a + " is Negative number");

    }
    else{
        System.out.println(a + " is Postive Number");
    }}
}