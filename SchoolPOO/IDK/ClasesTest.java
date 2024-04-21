package SchoolPOO.IDK;

import java.util.Scanner;

public class ClasesTest {
  public static void main( String args[] ){
    Clases A = new Clases();
    Clases B = new Clases();

    try ( Scanner input = new Scanner(System.in )){
      System.out.print("Ax: ");
      A.setX(input.nextInt());
      System.out.print("Ay: ");
      A.setY(input.nextInt());
      System.out.print("Bx: ");
      B.setX(input.nextInt());
      System.out.print("By: ");
      B.setY(input.nextInt());
    }

    System.out.printf("Holiwis Ax: " + A.getX() + " Ay: " + A.getY() + " Bx: " + B.getX() + " By: " + B.getY());
  }
}
