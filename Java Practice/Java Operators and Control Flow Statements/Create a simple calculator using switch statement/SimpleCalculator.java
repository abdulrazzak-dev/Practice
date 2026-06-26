import java.util.Scanner;
public class SimpleCalculator{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number1");
        double Num1 = scan.nextDouble();
        System.out.println("Enter an operator (+, -, *, /) : ");
        char ch = scan.next().charAt(0);
        System.out.println("Enter the number2");
        double Num2 = scan.nextDouble();
       
       double result;
       switch(ch){
            case '+':
            result = Num1 + Num2;
            System.out.println(Num1 + "+" + Num2 + "=" + result);
            break;
            case '-':
            result = Num1 - Num2;
            System.out.println("Result: " + Num1 + "-" + Num2 + "=" + result);
            break;
            case '*':
            result = Num1 * Num2;
            System.out.println("Result: " + Num1 + "*" + Num2 + "=" + result);
            break;
           
            case '/':
           if (Num2 != 0) {
                    result = Num1 / Num2;
                    System.out.println("Result: " + Num1 + " / " + Num2 + " = " + result);
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                }
            break;

            default:
                System.out.println("invaild");

       }
    }
}