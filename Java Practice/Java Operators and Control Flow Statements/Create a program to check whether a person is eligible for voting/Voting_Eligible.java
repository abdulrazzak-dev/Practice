import java.util.Scanner;
public class Voting_Eligible{
    public static void main(String[] args){

     Scanner scan = new Scanner(System.in);
     System.out.println("Enter you age : ");
     int age = scan.nextInt();
     if(age>=18){
        System.out.print("Your Eligable for voting");
     }
     else{
        System.out.print("You not Eligabel for voting");
     }

     }
}