import java.util.Scanner;
public class DigitsInNum{
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter Number : ");
    int n = scan.nextInt();
    int count = 0;
    // if(n==0){
    //     count = 1;
    //}
   // else{
    while(n!=0){
      n = n/10;
      count = count + 1;
      
    } 
    System.out.print("Numbers Digits : " + count);
    
}}