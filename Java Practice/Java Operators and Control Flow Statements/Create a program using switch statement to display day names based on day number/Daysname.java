import java.util.Scanner;
public class Daysname{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Day no : ");
        int Day = scan.nextInt();
        switch(Day){
            case(1):
            System.out.println("Monday");
            break;
            case(2):
            System.out.println("Thusday");
            break;
            case(3):
            System.out.println("Wensday");
            break;
            case(4):
            System.out.print("Thersday");
            break;
            case(5):
            System.out.print("Friday");
            break;
            case(6):
            System.out.print("Sturday");
            break;
            case(7):
            System.out.print("Sunday");
            break;
            default:
                System.out.println("invalid");
        }

    }
}