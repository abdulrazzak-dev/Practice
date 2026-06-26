import java.util.Scanner;
public class Triangle{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Symbale : ");
        String a = scan.nextLine();
        System.out.print("Enter the Number for line : ");
        int n = scan.nextInt();
        
        for(int i = 1;i<=n;i++){
             
            for(int j = 1;j<=(2*i)-1;j++){
              
              System.out.print(a);
             
            }
            System.out.println();
        }
       
    }
}