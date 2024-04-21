package SchoolPOO.pck_Empresa;

public class Gerente extends Empleado {
  private String departamento;
  private double bono;
  private double prestaciones;

  public Gerente(int idEmpleado, String nombre, double salarioBase, int edad, String departamento, double bono, double prestaciones) {
    super(idEmpleado, nombre, salarioBase, edad);
    this.departamento = departamento;
    this.bono = bono;
    this.prestaciones = prestaciones;
  }
  
  public Gerente() {
    idEmpleado = 0;
    nombre = null;
    salarioBase = 0;
    edad = 0;
    departamento = null;
    bono = 0;
    prestaciones = 0;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public void setBono(double bono) {
    this.bono = bono;
  }

  public void setPrestaciones(double prestaciones) {
    this.prestaciones = prestaciones;
  }
  
  public String getDepartamento() {
    return departamento;
  }
  
  public double getBono() {
    return bono;
  }

  public double getPrestaciones() {
    return prestaciones;
  }

  @Override
  public String getDatos() {
    return super.getDatos() + "Departamento: " + getDepartamento() + "\n" + "Bono: " + getBono() + "\n" + "Prestaciones: " +getPrestaciones() + "\n";
  }
}
