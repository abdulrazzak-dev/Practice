import java.util.Scanner;
public class NumberPattern{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int a = 0;
        System.out.print("Enter the Number for line : ");
        int n = scan.nextInt();
        
        for(int i = 1;i<=n;i++){
             
            for(int j = 1;j<=i;j++){
                //a = a+j;
              System.out.print(j);
            }
            System.out.println();
        }
       
    }
}