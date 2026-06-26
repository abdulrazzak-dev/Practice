import java.util.Scanner;
public class Gradecalculator{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter you marks : ");
        int a = scan.nextInt();
        if(a<35){
            System.out.println("You are result is : F");
        }
        else if(a>=35 && a<55){
            System.out.println("You are result is : C ");
        }
        else if(a>=55 && a<75){
            System.out.println("You are result is : B ");
        }
        else{
            System.out.println("You are result is : A");
        }


    }
}
