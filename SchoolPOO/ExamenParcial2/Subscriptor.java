package SchoolPOO.ExamenParcial2;

public class Subscriptor {
  private String idSubscriptor;
  private String nombre;
  private String tipo;
  private String telefono;
  private Fecha fechaNacimiento;
  private String correoElectronico;

  public Subscriptor() {
    this.idSubscriptor = "";
    this.nombre = "";
    this.tipo = "";
    this.telefono = "";
    this.fechaNacimiento = new Fecha();
    this.correoElectronico = "";
  }

  public Subscriptor(String idSubscriptor, String nombre, String tipo, String telefono, int dia, int mes, int anio,
      String correoElectronico) {
    this.idSubscriptor = idSubscriptor;
    this.nombre = nombre;
    this.tipo = tipo;
    this.telefono = telefono;
    this.fechaNacimiento = new Fecha(dia, mes, anio);
    this.correoElectronico = correoElectronico;
  }
  
  public void setIdSubscriptor(String idSubscriptor) {
    this.idSubscriptor = idSubscriptor;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public boolean setFechaNacimiento(int dia, int mes, int anio) {
    if (fechaNacimiento.fechaCorrecta()) {
      fechaNacimiento.setFecha(dia, mes, anio);
      return true;
    }
    return false;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public String getIdSubscriptor() {
    return idSubscriptor;
  }

  public String getNombre() {
    return nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento.getFecha();
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public String getDatos() {
    return "ID Subscriptor: " + getIdSubscriptor() +
        "\nNombre: " + getNombre() +
        "\nTipo: " + getTipo() +
        "\nTeléfono: " + getTelefono() +
        "\nFecha de Nacimiento: " + fechaNacimiento.getFecha() +
         "\nCorreo Electrónico: " + getCorreoElectronico();
  }

}
