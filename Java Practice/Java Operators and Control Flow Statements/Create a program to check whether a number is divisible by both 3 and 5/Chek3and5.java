import java.util.Scanner;
public class Chek3and5{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number : ");
        int a = scan.nextInt();
        if(a%3==0 && a%5==0){
              System.out.println(a + " is devided by 3&5");
        }
        else{
            System.out.print(a + " is not devided by 3&5");
        }
            }
    
}