package SchoolPOO.pck_Tienda;

import SchoolPOO.pck_Fecha.Fecha;

public class Perecedero {
  private int idArticulo;
  private String description;
  private String marca;
  private Fecha fechaC = new Fecha();
  private Fecha fechaCaducidad;

  public Perecedero(int idArticulo, String description, String marca, Fecha fechaCaducidad) {
    this.idArticulo = idArticulo;
    this.description = description;
    this.marca = marca;
    this.fechaCaducidad = fechaCaducidad;
  }

  public Perecedero() {
    this.idArticulo = 0;
    this.description = null;
    this.marca = null;
    this.fechaCaducidad = new Fecha();
  }

  public void setIdArticulo(int idArticulo) {
    this.idArticulo = idArticulo;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setFechaCaducidad(Fecha fechaCaducidad) {
    this.fechaCaducidad = fechaC;
  }

  public void setFechaCaducidad(int dia, int mes, int anio) {
    this.fechaCaducidad.setFecha(dia, mes, anio);
  }

  public int getIdArticulo() {
    return idArticulo;
  }

  public String getDescription() {
    return description;
  }

  public String getMarca() {
    return marca;
  }

  public String getFechaCaducidad() {
    return fechaCaducidad.getFecha();
  }

  String perecederoHeaderString = "\n\n\t\t==- Articulo Perecedero ==-\nID\tDescripcion\tMarca\tFecha de Caducidad\n  ------------------------------------------------------------\n";

  public String getDatos() {
    return perecederoHeaderString + idArticulo + "\t" + description + "\t\t" + marca + "\t" + fechaCaducidad.getFecha();
  }
}
