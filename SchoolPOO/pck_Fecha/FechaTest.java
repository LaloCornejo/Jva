package SchoolPOO.pck_Fecha;

import javax.swing.JOptionPane;

public class FechaTest {
  public static void main(String args[]){
    Fecha fecha = new Fecha();

    fecha.setFecha( 28, 2, 2023 );

    JOptionPane.showMessageDialog(null, fecha.getFecha(), "Fecha" , JOptionPane.PLAIN_MESSAGE);
  }
}
