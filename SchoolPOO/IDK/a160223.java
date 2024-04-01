// Jesus Eduardo Cornejo Clavel 3ro 1
package SchoolPOO.IDK;
import java.util.ArrayList;
import java.util.Scanner;

public class a160223 {

  public static float promedio(ArrayList<Integer> numsArrayList, int tam ){
    float prom = 0;
    for( int i = 0; i < numsArrayList.size(); i++ ){
      prom += numsArrayList.get(i);
    }
    return prom / (float)tam;
  }

  public static void print( ArrayList<Integer> numsArrayList ){
    System.out.println("**************************");
    for( int i = 0; i < numsArrayList.size(); i++ ){
      System.out.println( numsArrayList.get(i) );
    }
    System.out.println("**************************");
  }

  public static void main(String[] args) {
    int calif = 0;
    ArrayList<Integer> nums = new ArrayList<Integer>();

    try (Scanner input = new Scanner( System.in )) {
      do{
        System.out.print("Calif: ");
        calif = input.nextInt();
        if( calif >= 0 && calif <= 10 ){
          nums.add(calif);
        }else{
          if( calif != 99 ){
            System.out.println("La calif no es valida :(");
          }
        }
      }while( calif != 99 );

      int tam = nums.size();

      if( tam > 0 ){
        print(nums);
        
        System.out.println("Prom: " + promedio(nums, tam) ); 
      }
    }

  }
}

