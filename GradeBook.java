// public class GradeBoook{

//     public void displayMessage(){

//         System.out.println("Welcome to the Grde Book");
//     }
// }


// public class GradeBoook{

//     public void displayMessage( String courseName ){

//         System.out.printf("Welcome to the grade book for %s \n", courseName);
//     }
// }

public class GradeBoook{

    private void setCourseName( String name ){

        courseName = name;
    }

    public String getCourseName(){

        return courseName
    }


    public void displayMessage(){

        System.out.printf("Welcome to the grade book for %s \n", courseName);
        getCourseName();
    }
}