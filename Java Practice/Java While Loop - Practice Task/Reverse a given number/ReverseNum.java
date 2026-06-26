import java.util.Scanner;
public class ReverseNum{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number : ");
        int Num = scan.nextInt();
        int remainde;
        int revased = 0;
        
        while(Num!=0){
            remainde = Num%10;
            revased = (revased * 10) + remainde;
            Num = Num/10;
            
        }System.out.println("Reverse number : " + revased );
    } 
}
