package SchoolPOO.pck_Gato;

import javax.swing.JOptionPane;

public class GatoTest {
  public static void main(String[] args) {
    Gato gato1 = new Gato(1, "Michi", "Fea", 2.5f, "Blanco", "1");

    Gato gato2 = new Gato(2, "Mich", "Tonto", 3.5f, "Naranja", "0");

    Gato gato3 = new Gato();

    JOptionPane.showMessageDialog(null, "<html><p>Llena los datos que se piden del <b>GATO 3</b> >=<</p></html>");
    gato3.setIdGato(Integer.parseInt(JOptionPane.showInputDialog("ID: ", "∞")));
    gato3.setNombre(JOptionPane.showInputDialog("Nombre: ", "Michi"));
    gato3.setRaza(JOptionPane.showInputDialog("Raza: ", "Naranja"));
    gato3.setEdad(Float.parseFloat(JOptionPane.showInputDialog("Edad: ", "∞")));
    gato3.setColor(JOptionPane.showInputDialog("Color: ", "Pelon"));
    gato3.setSexo(
      String.valueOf(JOptionPane.showOptionDialog(null, "Sexo: ", "Seleccione el sexo", JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Hembra", "Macho" }, "Hembra")));

    String info = String.format("ID: %d \nNombre: %s\nRaza: %s\nEdad: %f\nColor: %s\nSexo: %s", gato3.getIdGato(), gato3.getNombre(), gato3.getRaza(), gato3.getEdad(), gato3.getColor(), gato3.getSexo());

    JOptionPane.showMessageDialog(null, gato1.getDatos());
    JOptionPane.showMessageDialog(null, gato2.getDatos());
    JOptionPane.showMessageDialog(null, gato3.getDatos());
    JOptionPane.showMessageDialog(null, info, "Gato 3", JOptionPane.PLAIN_MESSAGE);
    JOptionPane.showMessageDialog(null, "** GATO 3 **\n" + "\nID: " + gato3.getIdGato() + "\nNombre: " + gato3.getNombre() + "\nRaza: " + gato3.getRaza() + "\nEdad: " + gato3.getEdad() + "\nColor: " + gato3.getColor() + "\nSexo: " + gato3.getSexo());
  }
}
