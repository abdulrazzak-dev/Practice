import java.util.Scanner;
public class MultiplicationTable{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int a = scan.nextInt();
        int i = 1;
        int b = 0;
        while(i<=10){
              b = i*a;
              
            System.out.println(i + "*" + a + "=" + b);
           
            i++;
        } 
    }   
   
}