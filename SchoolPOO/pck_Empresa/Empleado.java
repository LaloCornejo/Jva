package SchoolPOO.pck_Empresa;

public class Empleado {
  protected int idEmpleado;
  protected String nombre;
  protected double salarioBase;
  protected int edad;

  public Empleado(int idEmpleado, String nombre, double salarioBase, int edad) {
    this.idEmpleado = idEmpleado;
    this.nombre = nombre;
    this.salarioBase = salarioBase;
    this.edad = edad;

  }
  
  public Empleado() {
    this(0, null, 0.0, 0);
  }

  public void setIdEmpleado(int idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setSalarioBase(double salarioBase) {
    this.salarioBase = salarioBase;
  }

  public int getEdad() {
    return edad;
  }

  public int getIdEmpleado() {
    return idEmpleado;
  }

  public String getNombre() {
    return nombre;
  }

  public String getSalarioBase() {
    return "$" + salarioBase;
  }

  public String getDatos() {
    return "ID: " +  getIdEmpleado() + "\n" + "Nombre: " + getNombre() + "\n" + "SalarioBase: " + getSalarioBase() + "\n";
  }
}
