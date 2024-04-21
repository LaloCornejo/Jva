//Cornejo Clavel Jesus Eduardo
package SchoolPOO.pck_Estacionamiento;

import javax.swing.JOptionPane;

public class EstacionamientoTest {
  public static void main(String[] args) {
    Estacionamiento estacionamiento = new Estacionamiento();
    int[] montoSemana = new int[52];

    for (int i = 0; i < montoSemana.length; i++) {
      montoSemana[i] = 0;
    }

    String nombreEncargado = null, direccion = null;
    int anio = 0;

    do {
      try {
        nombreEncargado = JOptionPane.showInputDialog(null, "Ingrese el nombre del encargado");
        estacionamiento.setNombreEncargado(nombreEncargado);
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Nombre del encargado no válido");
        nombreEncargado = null;
      }
    } while (nombreEncargado == null);

    do {
      try {
        anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año"));
        estacionamiento.setAnio(anio);
        if (anio < 2010 || anio > 2024) {
          JOptionPane.showMessageDialog(null, "Error: Año no válido");
          anio = 0;
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Año no válido");
      }
    } while (anio == 0);

    do {
      try {
        direccion = JOptionPane.showInputDialog(null, "Ingrese la dirección");
        estacionamiento.setDireccion(direccion);
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Dirección no válida");
        direccion = null;
      }
    } while (direccion == null);

    for (int i = 0; i < montoSemana.length; i++) {
      boolean isValidInput = false;
      while (!isValidInput) {
        try {
          int monto = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el monto de la semana " + (i + 1)));
          if (monto < 0) {
            JOptionPane.showMessageDialog(null, "Error: Monto de la semana no válido");
          } else {
            montoSemana[i] = monto;
            isValidInput = true;
          }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido");
        }
      }
    }
    estacionamiento.setMontoSemana(montoSemana);

    System.out.println("Nombre del encargado: " + estacionamiento.getNombreEncargado());
    System.out.println("Año: " + estacionamiento.getAnio());
    System.out.println("Dirección: " + estacionamiento.getDireccion());
    System.out.println("Monto de la semanas: ");
    for (int i = 0; i < montoSemana.length; i++) {
      System.out.println(montoSemana[i]);
    }

    System.out.println("Monto anual: " + estacionamiento.getMontoAnual());
    System.out.println(estacionamiento.getDatos());
    String meses = "";

    for (int i = 0; i < montoSemana.length; i++) {
      if ( i % 4 == 0 ) {
        meses += "\n";
      }
      meses += "Semana " + (i + 1) + ": " + estacionamiento.getMontoSemana(i) + "\t";
    }

    JOptionPane.showMessageDialog(null,
        "Nombre del encargado: " + estacionamiento.getNombreEncargado() + "\nAño: " + estacionamiento.getAnio()
            + "\nDirección: " + estacionamiento.getDireccion() + "\nMonto total del anio " + estacionamiento.getAnio()
            + ": " + estacionamiento.getMontoAnual(), "gets()", JOptionPane.PLAIN_MESSAGE);

    JOptionPane.showMessageDialog(null, meses, "Monto de las semanas", JOptionPane.PLAIN_MESSAGE);

    JOptionPane.showMessageDialog(null, estacionamiento.getDatos(), "getDatos()",
        JOptionPane.PLAIN_MESSAGE);
  }
}
