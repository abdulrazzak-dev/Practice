import java.util.Scanner;
public class Month{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Month no : ");
        int Day = scan.nextInt();
        switch(Day){
            case 1:
            System.out.println("Januwary");
            break;
            case 2:
            System.out.println("Febrawery");
            break;
            case 3:
            System.out.println("March");
            break;
            case 4:
            System.out.print("April");
            break;
            case 5:
            System.out.print("May");
            break;
            case 6:
            System.out.print("June");
            break;
            case 7:
            System.out.print("Juley");
            break;
            case 8:
            System.out.print("Augest");
            break;
            case 9:
            System.out.print("September");
            break;
            case 10:
            System.out.print("October");
            break;
             case 11:
            System.out.print("Navamber");
            break;
             case 12:
            System.out.print("December");
            break;
            default:
                System.out.println("invalid");
        }

    }
}