import java.util.Scanner;

public class WhileCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Press the number 1 is Addition");
        System.out.println("Press the number 2 is Subtraction");
        System.out.println("Press the number 3 is Multiplication");
        System.out.println("Press the number 4 is Division");
        System.out.println("Press the number 5 is Exit");
    
    double result;
       
        boolean runing = true;
    while(runing){
        System.out.print("Enter the number for 1 to 4 : ");
    int n = scan.nextInt();
         
        if(n==5 || n<1 || n>5){
            runing = false;
            System.out.println("Calculator is exit");
        }
        else if(n>=1 || n<5){
        System.out.print("Enter the number1 : ");
        double num1 = scan.nextDouble();
        System.out.print("Enter the number2 : ");
        double num2 = scan.nextDouble();
        
        
         if(n==1){
           result = num1 + num2;
           System.out.println( num1 + " + " + num2 + " = " + result );
        }
        else if(n==2){
           result = num1 - num2;
           System.out.println( num1 + " - " + num2 + " = " + result );
        }
        else if(n==3){
           result = num1 * num2;
           System.out.println( num1 + "*" + num2 + "=" + result );
        }
        else if(n==4){
           
           if(num2 != 0){
            System.out.print(" 0 is can't to use  ");
           }
           result = num1 / num2;
           System.out.println( num1 + " / " + num2 +  " = " + result );
           
           }
         else {
            System.out.println("Invalid Number");
        }}
        else{
            System.out.println("Invalied Number and Calculator Exit");
        }
        
    }
       
    }
}

//  // லூப்பைத் தொடர்ந்து இயக்க ஒரு வேரியபிள்
//         boolean running = true; 

//         // running = true ஆக இருக்கும் வரை லூப் ஓடிக்கொண்டே இருக்கும்
//         while (running) {
            
//             // 1. மெனுவை திரையில் காட்டுதல்
//             System.out.println("\n--- CALCULATOR MENU (While Loop Only) ---");
//             System.out.println("1. Addition (+)");
//             System.out.println("2. Subtraction (-)");
//             System.out.println("3. Multiplication (*)");
//             System.out.println("4. Division (/)");
//             System.out.println("5. Exit");
//             System.out.print("Choose an option (1-5): ");
            
//             int choice = scan.nextInt();

//             // ஆப்ஷன் 5: பயனர் வெளியேற விரும்பினால்
//             if (choice == 5) {
//                 running = false;
//                 System.out.println("Exiting Calculator. Thank you!");
//                 break; // லூப்பை விட்டு உடனடியாக வெளியேறுகிறது
//             }

//             // தவறான ஆப்ஷனைத் தேர்ந்தெடுத்தால்
//             if (choice < 1 || choice > 5) {
//                 System.out.println("Invalid choice! Please choose a number between 1 and 5.");
//                 continue; // கீழே இருக்கும் கோடுகளுக்குச் செல்லாமல் மீண்டும் லூப்பின் ஆரம்பத்திற்குச் செல்லும்
//             }

//             // எண்களை இன்புட்டாக வாங்குதல்
//             System.out.print("Enter first number: ");
//             double num1 = scan.nextDouble();
//             System.out.print("Enter second number: ");
//             double num2 = scan.nextDouble();
            
//             double result;

//             // switch-case-க்கு பதிலாக தூய if-else வடிவம்
//             if (choice == 1) {
//                 result = num1 + num2;
//                 System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
//             } 
//             else if (choice == 2) {
//                 result = num1 - num2;
//                 System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
//             } Create a menu-driven calculator using a while loop that continues until the user chooses to exit
//             else if (choice == 3) {
//                 result = num1 * num2;
//                 System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
//             } 
//             else if (choice == 4) {
//                 // வகுத்தலில் 0 பாதுகாப்பு செக்
//                 if (num2 != 0) {
//                     result = num1 / num2;
//                     System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
//                 } else {
//                     System.out.println("Error! Division by zero is not allowed.");
//                 }
//             }
//         }

//         scan.close();