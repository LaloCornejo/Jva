// public class GradeBoookTest{

//     public static void main(String[] args){

//         GradeBoook myGradeBook = new GradeBoook();
//         myGradeBook.displayMessage();
//     }
// }
import java.util.Scanner;

public class GradeBoookTest{

    public static void main(String[] args){

        Scanner input = new Scanner( System.in );

        GradeBoook myGradeBook = new GradeBoook();

        System.out.println("Please enter the course name: ");
        String nameOfCourse = input.nextLine();
        system.out.println();

        myGradeBook.displayMessage(nameOfCourse);
    }
}