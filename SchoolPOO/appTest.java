package SchoolPOO;

import java.util.Scanner;

public class appTest {

  static int posicion(int array[], int ser) {
    for (int i = 0; i < array.length ; i++) {
      if (array[i] == ser) {
        System.out.println("\n\n*** Existe ***");
        return i + 1;
      } else {
        if (i == 4)
          System.out.println("No existe");
      }
    }
    return -1;
  }

  public static void main(String[] args) {

    int array[] = new int[5];
    try (Scanner input = new Scanner(System.in)) {
      for (int i = 0; i < array.length; i++) {
        int num = input.nextInt();
        if (num > 0 && num <= 20) {
          array[i] = num;
        } else {
          System.out.println("El numero no es valido");
          i--;
        }
      }

      System.out.print("\nSearch: ");

      int ser = input.nextInt();
      System.out.println("Posicion: " + posicion(array, ser));

    }
  }
}