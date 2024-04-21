package SchoolPOO.pck_Empresa;

public class Administrativo extends Empleado {
  private double prestaciones;

  public Administrativo(int idEmpleado, String nombre, double salarioBase, int edad, double prestaciones) {
    super(idEmpleado, nombre, salarioBase, edad);
    this.prestaciones = prestaciones;
  }

  public Administrativo() {
    idEmpleado = 0;
    nombre = null;
    salarioBase = 0;
    edad = 0;
    prestaciones = 0;
  }

  public void setPrestaciones(double prestaciones) {
    this.prestaciones = prestaciones;
  }

  public double getPrestaciones() {
    return prestaciones;
  }

  @Override
  public String getDatos() {
    return super.getDatos() + "Prestaciones: " + getPrestaciones() + "\n";
  }
}
