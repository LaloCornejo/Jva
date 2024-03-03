package SchoolPOO.pck_Empleado;

import javax.swing.JOptionPane;

public class EmpleadoMenu {

  public static void main(String args[]) {

    Empleado emp = new Empleado();
    int op, id;
    String nombre, depto;
    int anio;

    String despedida = "Adios\nCreado por: L Æ L Ö\nEn la clase de POO\n\t>w<";

    String menu = "1. Ingresar datos generales\n2. Ingresar una venta mensual\n3. Consultar venta mensual\n4. Consultar datos y ventas\n5. Salir";

    do {
      do {
        try {
          op = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          op = 0;
        }
      } while (op == 0);
      switch (op) {
        case 1:
          do {
            try {
              id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado"));
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              id = 0;
            }
          } while (op == 0);
          do {
            try {
              nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              nombre = null;
            }
          } while (nombre == null);
          do {
            try {
              depto = JOptionPane.showInputDialog("Ingrese el departamento del empleado");
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              depto = null;
            }
          } while (depto == null);
          do {
            try {
              anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de ventas"));
              if (anio < 2010 || anio > 2024 ) {
                JOptionPane.showMessageDialog(null, "Error: Anio no valido", "Error", JOptionPane.ERROR_MESSAGE);
                anio = 0;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              anio = 0;
            }
          } while (anio == 0);
          emp.setIdEmpleado(id);
          emp.setNombre(nombre);
          emp.setDepartamento(depto);
          emp.setAnioVentas(anio);
          break;

        case 2:
          int mes;
          double venta;
          do {
            try {
              mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de la venta"));
              if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(null, "Error: Mes no valido", "Error", JOptionPane.ERROR_MESSAGE);
                mes = 0;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error:  el formato del mes no es valido, debe ser un numero",
                  "Error", JOptionPane.ERROR_MESSAGE);
              mes = 0;
            }
          } while (mes == 0);
          do {
            try {
              venta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la venta del mes " + mes));
              if ( venta < 0) {
                JOptionPane.showMessageDialog(null, "Error: Valor de venta esta en negativo", "Error", JOptionPane.ERROR_MESSAGE);
                venta = 0;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: el formato de la venta es incorrecto, debe ser numero",
                  "Error", JOptionPane.ERROR_MESSAGE);
              venta = 0;
            }
          } while (venta == 0);
          emp.setVentas(venta, mes);
          break;

        case 3:
          do {
            try {
              mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de la venta"));
              if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(null, "Error: Mes no valido", "Error", JOptionPane.ERROR_MESSAGE);
                mes = 0;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: el valor de mes no es un numero", "Error", JOptionPane.ERROR_MESSAGE);
              mes = 0;
            }
          } while (mes == 0);
          if ( emp.getVentas(mes-1) != -1){
            JOptionPane.showMessageDialog(null, "La venta del mes " + mes + " es: " + emp.getVentas(mes - 1), "Venta mensual", JOptionPane.PLAIN_MESSAGE);
          }else {
            JOptionPane.showMessageDialog(null, "No hubo ventas el mes" + mes, "Venta mensual", JOptionPane.PLAIN_MESSAGE);
          }
          break;
        case 4:
          JOptionPane.showMessageDialog(null, emp.getDatos(), "Datos del empleado", JOptionPane.PLAIN_MESSAGE);
          break;

        case 5:
          JOptionPane.showMessageDialog(null, despedida, "Fin", JOptionPane.INFORMATION_MESSAGE);
          break;

        default:
          JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.ERROR_MESSAGE);
      }
    } while (op != 5 );
  }
}