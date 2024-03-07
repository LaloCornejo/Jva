package SchoolPOO.pck_Felino;

import javax.swing.JOptionPane;

public class FelinoTest{
  public static void main( String args[]){
    Domestico[] cats = new Domestico[10];
    for( int i = 0; i < 10; i ++ ){
      cats[i] = new Domestico();
    }

    cats[0].setIdFelino(123);
    cats[0].setColor("Amarillo");
    cats[0].setTamano("Grande/Gordo");
    cats[0].setNombre("Megatron");
    cats[0].setDueno("Yo");
    cats[0].setNoVacunas(10);

    cats[1] = new Domestico(1234, "Negro", "Grande/Gordo", "KEvin the magical chesse wizard", "World", 10);
    
    
    JOptionPane.showMessageDialog(null, cats[0].getDatos(), "Data", JOptionPane.PLAIN_MESSAGE);
    JOptionPane.showMessageDialog(null, cats[1].getDatos(), "Data", JOptionPane.PLAIN_MESSAGE);
  }

}

// Sobrecarga de constructores