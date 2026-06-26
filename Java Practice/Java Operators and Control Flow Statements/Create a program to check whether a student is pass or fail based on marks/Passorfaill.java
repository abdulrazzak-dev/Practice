import java.util.Scanner;
public class Passorfaill{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter you marks : ");
        int a = scan.nextInt();
        if(a<35){
            System.out.println("Faill");
        }
        else if(a>=35 && a<75){
            System.out.println("Good");
        }
        else{
            System.out.println("Pass");
        }


    }
}