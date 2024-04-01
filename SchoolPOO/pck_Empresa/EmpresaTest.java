package SchoolPOO.pck_Empresa;

import javax.swing.JOptionPane;

public class EmpresaTest {
  public static void main(String[] args) {
    final int num = 10;

    Empleado[] empleados = new Empleado[num];
    int id, edad, op, contE = 0;
    double salario, bono, prest, comi;
    String nombre, esp, depa;

    String menu = "===- EMPRESA -===\n" +
        "1. Alta Gerente\n" +
        "2. Alta Ingeniero\n" +
        "3. Consulta de Gerente\n" +
        "4. Consulta de Ingeniero\n" +
        "5. Consulta de detalle de un Gerente\n" +
        "6. Consulta de detalle de Ingeniero" +
        "7. Salir\n" +
        "Elija una opción:";

    JOptionPane.showMessageDialog(null, menu, "MENU", JOptionPane.PLAIN_MESSAGE);

    do {
      do {
        try {
          op = Integer.parseInt(JOptionPane.showInputDialog("Opción: "));
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Error: opción no valida");
          op = 0;
        }
      } while (op == 0);
      switch (op) {
        case 1:
          do{
            try {
              id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del Gerente"));
              if ( id < 0 )
                id = -1;
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: id debe se numérico", "Alta de Gerente",
                  JOptionPane.PLAIN_MESSAGE);
              id = -1;
            }
          } while (id == -1);

          do {
            try {
              nombre = JOptionPane.showInputDialog("Ingrese el nombre del Gerente;");
            } catch ( NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error", "Alta Gerente", JOptionPane.PLAIN_MESSAGE);
              nombre = null;
            }
          } while ( nombre == null );

          do {
            try {
              salario = Double.parseDouble( JOptionPane.showInputDialog("Salario de Gerente: ") );
              if (salario <= 0.0) {
                JOptionPane.showMessageDialog(null, "Salario debe ser mayor a 0.0");
                salario = -1;
              }
            } catch ( NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Salario debe ser un numero");
              salario = -1;
            }
          } while (salario <= 0);
          
          do {
            try {
              edad = Integer.parseInt(JOptionPane.showInputDialog("Edad Gerente: "));
              if( edad < 30 || edad > 75 ){
                JOptionPane.showMessageDialog(null, "Edad no valida", "Alta Gerente", JOptionPane.PLAIN_MESSAGE);
                edad = -1;
              }
            } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Edad debe ser numero");
              edad = -1;
            }
          } while ( edad == -1);

          do {
            try {
              depa = JOptionPane.showInputDialog("Departamento del Gerente: ");
            } catch ( NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error");
              depa = null;
            }
          } while (depa == null);
          
          do {
            try {
              bono = Double.parseDouble( JOptionPane.showInputDialog("Bono de Gerente: ") );
              if (salario < 0.0) {
                JOptionPane.showMessageDialog(null, "Bono debe ser al menos 0.0");
                salario = -1;
              }
            } catch ( NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Bonos debe ser un numero");
              bono = -1;
            }
          } while (bono == -1);
          
          do {
            try {
              prest = Double.parseDouble( JOptionPane.showInputDialog("Prestaciones de Gerente: ") );
              if (prest < 0.0) {
                JOptionPane.showMessageDialog(null, "Prestaciones no pueden ser negativas");
                prest = -1;
              }
            } catch ( NumberFormatException e) {
              JOptionPane.showMessageDialog(null, "Error: Prestaciones debe ser un numero");
              prest = -1;
            }
          } while (prest == -1);
          
          empleados[contE] = new Gerente(id, nombre, salario, edad, depa, bono, prest);

          contE++;

          break;
        case 2:

          break;
        case 3:

          break;
        case 4:

          break;
        case 5:

          break;
        case 6:

          break;
        case 7:
          JOptionPane.showMessageDialog(null, "Creado por LÆLÖ. Fin", "Despedida", JOptionPane.PLAIN_MESSAGE);
          break;
      }
    } while (op != 7);
  }
}
