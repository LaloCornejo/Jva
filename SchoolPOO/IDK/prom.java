package SchoolPOO.IDK;

import java.util.Scanner;

public class prom {
  public static void main(String args[]) {
    int calif = 0, tam = 0;
    float prom = 0;

    try (Scanner input = new Scanner(System.in)) {

      while (calif != 99) {
        calif = input.nextInt();
        if (calif >= 0 && calif <= 10) {
          prom += calif;
          tam++;
        } else {
          if( calif != 99 ){
            System.out.println("Calificaion no valida");
          }
        }
      }
      if (prom > 0) {
        System.out.println(prom / tam);
      }else { 
        System.out.println("No hay calificaciones");
      }
    }
  }
}