package SchoolPOO.pck_Felino;

public class FelinoTest {
  public static void main( String args[] ){
    Domesticos[] cats = new Domesticos[10];
    for( int i = 0; i < 10; i ++ ){
      cats[i] = new Domesticos();
    }

    cats[0].setIdFelino(123);
    cats[0].setColor("Amarillo");
    cats[0].setTamanio("Grande/Gordo");
    cats[0].setNombre("Megatron");
    cats[0].setDueno("Yo");
    cats[0].setNoVacunas(10);

    cats[1] = (124, "Negro", "Powerfull", "Kevin the chesse magical wizard", "Tiktok", 5);
  }
}

//Sobrecarga de coinstructores