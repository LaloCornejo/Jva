package SchoolPOO.pck_Persona;

import java.util.Calendar;
import SchoolPOO.pck_Fecha.Fecha;

public class Persona {
  private String CURP;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private Fecha fechaNacimiento;
  private Fecha fechaN = new Fecha();

  public Persona(String CURP, String nombre, String apellidoPaterno, String apellidoMaterno, Fecha fechaNacimiento ) {
    this.CURP = CURP;
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.fechaNacimiento = fechaNacimiento;
  }

  public Persona() {
    this.CURP = null;
    this.nombre = null;
    this.apellidoPaterno = null;
    this.apellidoMaterno = null;
    this.fechaNacimiento = new Fecha();
  }

  public void setCURP(String CURP) {
    this.CURP = CURP;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public void setFechaNacimiento(Fecha fechaNacimiento) {
    this.fechaNacimiento = fechaN;
  }

  public void setFechaNacimiento(int dia, int mes, int anio) {
    this.fechaNacimiento.setFecha(dia, mes, anio);
  }


  public String getCURP() {
    return CURP;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento.getFecha();
  }

  public String getNombreCompleto() {
    return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
  }

  public String getSexo(){
    return CURP.substring(10, 11).equals("H") ? "Hombre" : "Mujer";
  }

  public String getDatos(){
    return "Nombre: " + getNombreCompleto() + "\n" +
           "Fecha de Nacimiento: " + getFechaNacimiento() + "\n" +
           "Edad: " + calcularEdad() + "\n" +
           "Sexo: " + getSexo();
  }

  public int calcularEdad() {
    int edad = 0;
    Calendar fechaActual = Calendar.getInstance();
    int currentYear = fechaActual.get(Calendar.YEAR);
    int currentMonth = fechaActual.get(Calendar.MONTH) + 1;
    int currentDay = fechaActual.get(Calendar.DAY_OF_MONTH);

    if (fechaNacimiento.getAnio() < currentYear) {
      edad = currentYear - fechaNacimiento.getAnio();
      if (fechaNacimiento.getMes() > currentMonth) {
        edad--;
      } else if (fechaNacimiento.getMes() == currentMonth) {
        if (fechaNacimiento.getDia() > currentDay) {
          edad--;
        }
      }
      return edad;
    }
    return -1;
  }
}