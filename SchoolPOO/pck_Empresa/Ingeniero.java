package SchoolPOO.pck_Empresa;

public class Ingeniero extends Empleado {
  private String especialidad;
  private double commission;

  public Ingeniero(int idEmpleado, String nombre, double salarioBase, int edad, String especialidad, double commission) {
    super(idEmpleado, nombre, salarioBase, edad);
    this.especialidad = especialidad;
    this.commission = commission;
  }

  public Ingeniero() {
    idEmpleado = 0;
    nombre = null;
    salarioBase = 0.0;
    edad = 0;
    especialidad = null;
    commission = 0.0;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public void setComision(double comission) {
    this.commission = comission;
  }

  public String getEspecialidad() {
    return especialidad;
  }
  
  public double getCommission() {
    return commission;
  }

  @Override
  public String getDatos() {
    return super.getDatos() + "Especialidad: " + getEspecialidad() + "\n" + "Commission: " + getCommission() + "\n";
  }
}
