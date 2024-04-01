package SchoolPOO.IDK;
// public class GradeBoookTest{

//     public static void main(String[] args){

//         GradeBoook myGradeBook = new GradeBoook();
//         myGradeBook.displayMessage();
//     }
// }
// import java.util.Scanner;

// public class GradeBoookTest{

//     public static void main(String[] args){

//         Scanner input = new Scanner( System.in );

//         GradeBoook myGradeBook = new GradeBoook();

//         System.out.println("Please enter the course name: ");
//         String nameOfCourse = input.nextLine();
//         system.out.println();

//         myGradeBook.displayMessage(nameOfCourse);
//     }
// }

// import java.util.Scanner;

// public class GradeBoookTest{

//     public static void main(String[] args){

//         Scanner input = new Scanner( System.in );

//         GradeBoook myGradeBook = new GradeBoook();

//         System.out,printf("Initial course name is: %s\n\n", myGradeBook.getCourseName() );

//         System.out.println("Please enter the course name: ");
//         String theName = input.nextLine();
//         myGradeBook.setCourseName(theName);
//         system.out.println();

//         myGradeBook.displayMessage();
//     }
// }

public class GradeBoookTest{

    public static void main( String[] args){

        GradeBoook gradeBook1 = new GradeBoook("CS101 Introduction to Java Programming");

        GradeBoook gradeBook2 = new GradeBoook("CS102 Data Structures in Java");

        System.out.printf( "gradeBook1 course name %s\n", gradeBook1.getCourseName() );
        System.out.printf( "gradeBook2 course name %s\n", gradeBook2.getCourseName() );
    }
}