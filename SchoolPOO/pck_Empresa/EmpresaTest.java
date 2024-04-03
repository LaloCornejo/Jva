package SchoolPOO.pck_Empresa;

import javax.swing.JOptionPane;

public class EmpresaTest {
  public static void main(String[] args) {
    final int num = 10;

    Empleado[] empleados = new Empleado[num];
    int id, edad, op, contE = 0;
    double salario, bono, prest, commission;
    String nombre, especialidad, depa, buscar;

    String menu = "===- EMPRESA -===\n" +
        "1. Alta Gerente\n" +
        "2. Alta Ingeniero\n" +
        "3. Consulta de Gerente\n" +
        "4. Consulta de Ingeniero\n" +
        "5. Consulta de detalle de un Gerente\n" +
        "6. Consulta de detalle de Ingeniero\n" +
        "7. Salir\n" +
        "Elija una opción:";

    do {
      do {
        try {
          op = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "MENU", JOptionPane.PLAIN_MESSAGE));
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Error: opción no valida");
          op = 0;
        }
      } while (op == 0);
      switch (op) {
        case 1:
          do {
            try {
              id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del Gerente"));
              if (id < 0)
                id = -1;
              for (int i = 0; i < contE; i++) {
                if (empleados[i].getIdEmpleado() == id) {
                  JOptionPane.showMessageDialog(null, "Error: id ya existe");
                  id = -1;
                }
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: id debe se numérico", "Alta de Gerente",
                  JOptionPane.PLAIN_MESSAGE);
              id = -1;
            }
          } while (id == -1);

          do {
            try {
              nombre = JOptionPane.showInputDialog("Ingrese el nombre del Gerente;");
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error", "Alta Gerente", JOptionPane.PLAIN_MESSAGE);
              nombre = null;
            }
          } while (nombre == null);

          do {
            try {
              salario = Double.parseDouble(JOptionPane.showInputDialog("Salario de Gerente: "));
              if (salario <= 0.0) {
                JOptionPane.showMessageDialog(null, "Salario debe ser mayor a 0.0");
                salario = -1;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Salario debe ser un numero");
              salario = -1;
            }
          } while (salario <= 0);

          do {
            try {
              edad = Integer.parseInt(JOptionPane.showInputDialog("Edad Gerente: "));
              if (edad < 30 || edad > 75) {
                JOptionPane.showMessageDialog(null, "Edad no valida", "Alta Gerente", JOptionPane.PLAIN_MESSAGE);
                edad = -1;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Edad debe ser numero");
              edad = -1;
            }
          } while (edad == -1);

          do {
            try {
              depa = JOptionPane.showInputDialog("Departamento del Gerente: ");
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error");
              depa = null;
            }
          } while (depa == null);

          do {
            try {
              bono = Double.parseDouble(JOptionPane.showInputDialog("Bono de Gerente: "));
              if (salario < 0.0) {
                JOptionPane.showMessageDialog(null, "Bono debe ser al menos 0.0");
                salario = -1;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Bonos debe ser un numero");
              bono = -1;
            }
          } while (bono == -1);

          do {
            try {
              prest = Double.parseDouble(JOptionPane.showInputDialog("Prestaciones de Gerente: "));
              if (prest < 0.0) {
                JOptionPane.showMessageDialog(null, "Prestaciones no pueden ser negativas");
                prest = -1;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Prestaciones debe ser un numero");
              prest = -1;
            }
          } while (prest == -1);

          empleados[contE] = new Gerente(id, nombre, salario, edad, depa, bono, prest);

          contE++;

          break;
        case 2:

          do {
            try {
              id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del Ingeniero"));
              if (id < 0)
                id = -1;
              for (int i = 0; i < contE; i++) {
                if (empleados[i].getIdEmpleado() == id) {
                  JOptionPane.showMessageDialog(null, "Error: id ya existe");
                  id = -1;
                }
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: id debe se numérico", "Alta de Ingeniero",
                  JOptionPane.PLAIN_MESSAGE);
              id = -1;
            }
          } while (id == -1);

          do {
            try {
              nombre = JOptionPane.showInputDialog("Ingrese el nombre del Ingeniero;");
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error", "Alta Ingeniero", JOptionPane.PLAIN_MESSAGE);
              nombre = null;
            }
          } while (nombre == null);

          do {
            try {
              salario = Double.parseDouble(JOptionPane.showInputDialog("Salario de Ingeniero: "));
              if (salario <= 0.0) {
                JOptionPane.showMessageDialog(null, "Salario debe ser mayor a 0.0");
                salario = -1;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Salario debe ser un numero");
              salario = -1;
            }
          } while (salario <= 0);

          do {
            try {
              edad = Integer.parseInt(JOptionPane.showInputDialog("Edad Ingeniero: "));
              if (edad < 30 || edad > 75) {
                JOptionPane.showMessageDialog(null, "Edad no valida", "Alta Ingeniero", JOptionPane.PLAIN_MESSAGE);
                edad = -1;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Edad debe ser numero");
              edad = -1;
            }
          } while (edad == -1);

          do {
            try {
              especialidad = JOptionPane.showInputDialog("Especialidad del Ingeniero: ");
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error");
              especialidad = null;
            }
          } while (especialidad == null);

          do {
            try {
              commission = Double.parseDouble(JOptionPane.showInputDialog("Comisión de Ingeniero: "));
              if (commission < 0.0) {
                JOptionPane.showMessageDialog(null, "Comisión no puede ser negativa");
                commission = -1;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Comisión debe ser un numero");
              commission = -1;
            }
          } while (commission == -1);

          empleados[contE] = new Ingeniero(id, nombre, salario, edad, especialidad, commission);

          contE++;

          break;
        case 3:

          String listaGerentes = "idEmpleado \t\t Nombre \t\t Salario \t\t Edad \t\t Departamento \t\t Bono \t\t Prestaciones\n"
              +
              "--------------------------------------------------------------------------------\n";
          do {
            try {
              id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del Gerente"));
              if (id < 0)
                id = -1;
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: id debe se numérico", "Alta de Gerente",
                  JOptionPane.PLAIN_MESSAGE);
              id = -1;
            }
          } while (id == -1);

          boolean encontrado = false;
          for (int i = 0; i < contE; i++) {
            if (empleados[i] instanceof Gerente && empleados[i].getIdEmpleado() == id) {
              Gerente g = (Gerente) empleados[i];
              listaGerentes += "\t" + g.getIdEmpleado() + "\t\t" + g.getNombre() + "\t\t" + g.getSalarioBase() + "\t\t"
                  + g.getEdad()
                  + "\t\t" + g.getDepartamento() + "\t\t" + g.getBono() + "\t\t" + g.getPrestaciones() + "\n";
              JOptionPane.showMessageDialog(null, listaGerentes, "Consulta de Gerente", JOptionPane.PLAIN_MESSAGE);
              encontrado = true;
              break;
            }
          }
          if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró un Gerente con el id proporcionado",
                "Consulta de Gerente", JOptionPane.PLAIN_MESSAGE);
          }

          break;
        case 4:

          String listaIngenieros = "idEmpleado \t\t Nombre \t\t Salario \t\t Edad \t\t Especialidad \t\t Comisión\n" +
              "--------------------------------------------------------------------------------\n";

          do {
            try {
              id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del Ingeniero"));
              if (id < 0)
                id = -1;
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: id debe se numérico", "Alta de Ingeniero",
                  JOptionPane.PLAIN_MESSAGE);
              id = -1;
            }
          } while (id == -1);

          encontrado = false;
          for (int i = 0; i < contE; i++) {
            if (empleados[i] instanceof Ingeniero && empleados[i].getIdEmpleado() == id) {
              Ingeniero in = (Ingeniero) empleados[i];
              listaIngenieros += in.getIdEmpleado() + "\t" + in.getNombre() + "\t" + in.getSalarioBase() + "\t"
                  + in.getEdad() + "\t" + in.getEspecialidad() + "\t" + in.getCommission() + "\n";
              JOptionPane.showMessageDialog(null, listaIngenieros, "Consulta de Ingeniero", JOptionPane.PLAIN_MESSAGE);
              encontrado = true;
              break;
            }
          }
          if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró un Ingeniero con el id proporcionado",
                "Consulta de Ingeniero", JOptionPane.PLAIN_MESSAGE);
          }

          break;
        case 5:
          do {
            try {
              id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del Empleado"));
              if (id < 0) {
                id = -1;
                JOptionPane.showMessageDialog(null, "Id no valido", "Consulta de Empleado", JOptionPane.PLAIN_MESSAGE);
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: id debe ser numérico", "Consulta de Empleado",
                  JOptionPane.PLAIN_MESSAGE);
              id = -1;
            }
          } while (id == -1);

          buscar = BuscarEmpleado(empleados, id, contE);

          if (buscar.equals("-1")) {
            JOptionPane.showMessageDialog(null, "No se encontró un empleado con el id proporcionado",
                "Consulta de Empleado",
                JOptionPane.PLAIN_MESSAGE);
          } else {
            char tipo = buscar.charAt(0);
            int pos = Integer.parseInt(buscar.substring(1));
            if (tipo == "G".charAt(0)) {
              JOptionPane.showMessageDialog(null, "Empleado encontrado: \n" + empleados[pos].getDatos(), "Consulta de Empleado",
                  JOptionPane.PLAIN_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(null, "El id ingresado no corresponde a un Gerente",
                  "Consulta de Empleado",
                  JOptionPane.PLAIN_MESSAGE);
            }
          }

          break;
        case 6:
          do {
            try {
              id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del Empleado"));
              if (id < 0) {
                id = -1;
                JOptionPane.showMessageDialog(null, "Id no valido", "Consulta de Empleado", JOptionPane.PLAIN_MESSAGE);
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: id debe ser numérico", "Consulta de Empleado",
                  JOptionPane.PLAIN_MESSAGE);
              id = -1;
            }
          } while (id == -1);

          buscar = BuscarEmpleado(empleados, id, contE);

          if (buscar.equals("-1")) {
            JOptionPane.showMessageDialog(null, "No se encontró un empleado con el id proporcionado",
                "Consulta de Empleado",
                JOptionPane.PLAIN_MESSAGE);
          } else {
            char tipo = buscar.charAt(0);
            int pos = Integer.parseInt(buscar.substring(1));
            if (tipo == "I".charAt(0)) {
              JOptionPane.showMessageDialog(null, "Empleado encontrado: \n"
                  + empleados[pos].getDatos(), "Consulta de Empleado", JOptionPane.PLAIN_MESSAGE);
                } else {
                  JOptionPane.showMessageDialog(null, "El id ingresado le corresponde a un Gerente",
                      "Baja de Empleado", JOptionPane.PLAIN_MESSAGE);
                }
              }

              break;
            case 7:
              JOptionPane.showMessageDialog(null, "Creado por LÆLÖ. Fin", "Despedida", JOptionPane.PLAIN_MESSAGE);
          break;
      }
    } while (op != 7);
  }

  public static String BuscarEmpleado(Empleado[] empleados, int id, int contE) {
    for (int i = 0; i < contE; i++) {
      if (empleados[i].getIdEmpleado() == id && empleados[i] instanceof Gerente) {
        return "G" + i;
      } else if (empleados[i].getIdEmpleado() == id && empleados[i] instanceof Ingeniero) {
        return "I" + i;
      }
    }
    return "-1";
  }
}
