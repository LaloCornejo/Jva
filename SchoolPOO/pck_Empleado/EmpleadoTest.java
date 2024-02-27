package SchoolPOO.pck_Empleado;

import javax.swing.JOptionPane;

public class EmpleadoTest {
  public static void main(String args[]){
    Empleado empleado1 = new Empleado(1, "Juan", "Ventas", 2020, new double[]{1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000});

    System.out.println("ID Empleado: " + empleado1.getIdEmpleado());
    System.out.println("Nombre: " + empleado1.getNombre());
    System.out.println("Departamento: " + empleado1.getDepartamento());
    System.out.println("Año de ventas: " + empleado1.getAnioVentas());
    System.out.println("Ventas Anuales: " + empleado1.getVentasAnuales());

    //getDatos
    System.out.println(empleado1.getDatos());

    //JOPTIONPANE
    JOptionPane.showMessageDialog(null, empleado1.getDatos());


    Empleado e2 = new Empleado();

    e2.setIdEmpleado(2);
    e2.setNombre("Pedro");
    e2.setDepartamento("Sistemas");
    e2.setAnioVentas(2020);
    e2.setVentas(1000, 1);
    e2.setVentas(2000, 2);
    e2.setVentas(3000, 3);
    e2.setVentas(4000, 4);
    e2.setVentas(5000, 5);
    e2.setVentas(6000, 6);
    e2.setVentas(-1, 7);
    e2.setVentas(-1, 8);
    e2.setVentas(-1, 9);
    e2.setVentas(-1, 10);
    e2.setVentas(-1, 11);
    e2.setVentas(-1, 12);

    System.out.println(e2.getDatos());

    //JOPTIONPANE
    JOptionPane.showMessageDialog(null, e2.getDatos());

    Empleado e3 = new Empleado();
    // ...

      e3.setIdEmpleado(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado: ")));
      e3.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del empleado: "));
      e3.setDepartamento(JOptionPane.showInputDialog("Ingrese el departamento del empleado: "));
      try {
        e3.setAnioVentas(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de ventas: ")));
        for (int i = 0; i < 12; i++){
          e3.setVentas(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la venta del mes " + (i+1) + ": ")), i+1);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
      }

      System.out.println(e3.getDatos());

      //JOPTIONPANE
      JOptionPane.showMessageDialog(null, e3.getDatos());


      int opcion = JOptionPane.showConfirmDialog(null, "Desea consultar las ventas anuales de los empleados?", "Consulta", JOptionPane.YES_NO_OPTION);
    
    if(opcion == JOptionPane.YES_OPTION){
      int consultar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de venta a consultar: "));
      consultar = consultar - 1;
      if (consultar >= 1 && consultar <= 12){
        if( e3.getVentas(consultar) == -1 ){
          JOptionPane.showMessageDialog(null, "No hay ventas en el mes " + consultar + 1);
        } else {
          JOptionPane.showMessageDialog(null, "Ventas del mes " + consultar + "\n" +
          "Empleado 3: " + e3.getVentas(consultar));
        }
      } else {
        JOptionPane.showMessageDialog(null, "Mes no válido");
      }
    }
  }  
}
