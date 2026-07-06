// package array.logic;
import java.util.Scanner;
public class CheckANumberPrime{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <=number/2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

      System.out.println("\n=========================================");
        System.out.println("            PRIMALITY REPORT             ");
        System.out.println("=========================================");
        System.out.println("Input Number : " + number);
        System.out.println("-----------------------------------------");
        
        if (isPrime) {
            System.out.println("RESULT: " + number + " is a PRIME number.");
        } else {
            System.out.println("RESULT: " + number + " is NOT a prime number.");
        }
        System.out.println("=========================================");
    }
}