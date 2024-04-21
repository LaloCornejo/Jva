//Cornejo clavel Jesus Eduardo
package SchoolPOO.pck_Estacionamiento;

public class Estacionamiento {
  private String nombreEncargado;
  private int anio;
  private String direccion;
  private int[] montoSemana;

  public Estacionamiento() {
    this.nombreEncargado = "";
    this.anio = 0;
    this.direccion = "";
    this.montoSemana = new int[54];
  }

  public Estacionamiento(String nombreEncargado, int anio, String direccion, int[] montoSemana) {
    this.nombreEncargado = nombreEncargado;
    this.anio = anio;
    this.direccion = direccion;
    this.montoSemana = montoSemana;
  }

  public void setNombreEncargado( String nombreEncargado ){
    this.nombreEncargado = nombreEncargado;
  }

  public  void setAnio(int anio) {
    this.anio = anio;
  }
  
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public void setMontoSemana(int[] montoSemana) {
    this.montoSemana = montoSemana;
  }

  public String getNombreEncargado() {
    return nombreEncargado;
  }

  public int getAnio() {
    return anio;
  }

  public int getMontoSemana( int i ) {
      return montoSemana[i];
  }

  public String getDireccion() {
    return direccion;
  }

  public int getMontoAnual() {
    int montoAnual = 0;
    for (int i = 0; i < montoSemana.length; i++) {
      montoAnual += montoSemana[i];
    }
    return montoAnual;
  }
  
  public String getDatos() {
    return "Nombre del encargado: " + getNombreEncargado() + "\nAño: " + getAnio() + "\nDirección: " + getDireccion() + "\nMonto total del anio " + getAnio() + ": "  + getMontoAnual();
  }
}
