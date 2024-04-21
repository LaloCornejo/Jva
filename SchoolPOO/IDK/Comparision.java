package SchoolPOO.IDK;
import java.util.Scanner;

public class Comparision{

    public static void main (String[] args){
        
        try (Scanner input = new Scanner( System.in )) {
            int num1;
            int num2;

            System.out.print("Enter first integer: ");
            num1 = input.nextInt();

            System.out.print("Enter second integer: ");
            num2 = input.nextInt();
            

            if(num1 == num2)
                System.out.printf("%d == %d", num1, num2);
            
            if(num1 != num2)
                System.out.printf("%d != %d", num1, num2);

            if(num1 > num2)
                System.out.printf("%d > %d", num1, num2);

            if(num1 < num2)
                System.out.printf("%d < %d", num1, num2);
            
            if(num1 >= num2)
                System.out.printf("%d >= %d", num1, num2);

            if(num1 <= num2)
                System.out.printf("%d <= %d", num1, num2);
        }
    }
}