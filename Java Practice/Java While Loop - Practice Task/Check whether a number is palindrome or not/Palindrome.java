import java.util.Scanner;
public class Palindrome{
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print(" Enter the number : ");
    int n = scan.nextInt();
    int org = n;
    int h = 0;
    int remaider;
    while(n!=0){
        remaider = n%10;
        h = (h*10) + remaider;
        n = n/10;
       
    }
     if(h==org){
            System.out.println("It is Palindrom");
        }
        else{
            System.out.println("It is not Palindrom");
        }
   System.out.println("Revase Number : " + h);
    
}}