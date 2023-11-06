import java.util.Scanner;

public class Analysis {
    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in)) {
            int passes = 0;
            int failures = 0;
            int studentCount = 1;
            int result;

            while(studentCount <= 10){
                System.out.print("Enter result (1 = pass, 2 = fail): ");
                result = input.nextInt();

                if(result == 1)
                    passes = passes + 1;
                else
                    failures = failures + 1;

                studentCount = studentCount + 1;
            }

            System.out.printf("Passed: %d\nFailed: %d\n", passes, failures);

            if(passes > 8)
                System.out.println("Bonus to instructor!");
        }
    }
}
