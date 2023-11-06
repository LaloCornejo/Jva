package fifth;

import java.util.Scanner;

public class GradeBook {
    private String courseNames;

    private int total;
    private int gradeCounter;
    private int aCount;
    private int bCount;
    private int cCount;
    private int dCount;
    private int fCount;
    public GradeBook( String name){
        courseNames = name;
    }
    
    public void setCourseName( String name){
        courseNames = name;
    }
    
    public String getCourseName(){
        return courseNames;
    }
    
    public void displayMessage(){
        System.out.printf("Welcome to the grade book for\n%s!\n\n", getCourseName());
    }
    
    public void inputGrades(){
        try (Scanner input = new Scanner(System.in)) {
            int grade;
   
            System.out.printf("%s\n%s\n %s\n %s\n",
                    "Enter the integer grades in the range 0-100.",
                    "Type the end-of-file indicator to terminate input:",
                    "On UNIX/Linux/Mac OS X type <Ctrl> d then press Enter",
                    "On Windows type <Ctrl> z then press Enter");
   
            while (input.hasNext()){
                grade = input.nextInt();
                total += grade;
                ++gradeCounter;
   
                incrementLetterGradeCounter(grade); 
            }
        }
    }
    
    private void incrementLetterGradeCounter(int grade){
        switch( grade / 10 ){
            case 9:
            case 10:
                ++aCount;
                break;
    
            case 8:
                ++bCount;
                break;
    
            case 7:
                ++cCount;
                break;
            case 6:
                ++dCount;
                break;
    
            default:
                ++fCount;
                break;
        }
    }
    
    public void displayGradeReport(){
        System.out.println("\nGrade Report:");
    
        if(gradeCounter != 0){
            double average = (double)total / gradeCounter;
    
            System.out.printf("Total of the %d grades entered is %d\n", gradeCounter, total);
            System.out.printf("Class average is %.2f\n", average);
            System.out.printf("%s\n%s%d\n%s%d\n%s%d\n%s%d\n%s%d\n",
                    "Number of students who received each grade:",
                    "A: ", aCount,
                    "B: ", bCount,
                    "C: ", cCount,
                    "D: ", dCount,
                    "F: ", fCount);
        } else{
            System.out.println("No grades were entered");
        }
    }
}

