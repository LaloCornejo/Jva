package SchoolPOO.ExamenParcial2;

import java.io.Serializable;

public class Renta implements Serializable {
  private int idRenta;
  private int idArticulo;
  private String idSubscriptor;
  private Fecha fechaRenta;
  private Fecha fechaVencimiento;

  public Renta() {
    this.idRenta = 0;
    this.idArticulo = 0;
    this.idSubscriptor = null;
    this.fechaRenta = new Fecha();
    this.fechaVencimiento = new Fecha();
  }

  public Renta(int idRenta, int  articulo, String suscriptor, Fecha fechaRenta, Fecha fechaVencimiento) {
    this.idRenta = idRenta;
    this.idArticulo = articulo;
    this.idSubscriptor = suscriptor;
    this.fechaRenta = fechaRenta ;
    this.fechaVencimiento = fechaVencimiento;
  }

  public void setIdRenta(int idRenta) {
    this.idRenta = idRenta;
  }

  public void setIdArticulo(int idArticulo) {
    this.idArticulo = idArticulo;
  }

  public void setIdSubscriptor(String idSubscriptor) {
    this.idSubscriptor = idSubscriptor;
  }

  public boolean setFechaRenta(int dia, int mes, int anio) {
    if (fechaRenta.fechaCorrecta()) {
      fechaRenta.setFecha(dia, mes, anio);
      return true;
    }
    return false;
  }

  public boolean setFechaVencimiento(int dia, int mes, int anio) {
    if (fechaVencimiento.fechaCorrecta()) {
      fechaVencimiento.setFecha(dia, mes, anio);
      return true;
    }
    return false;
  }

  public int getIdRenta() {
    return idRenta;
  }

  public int getIdArticulo() {
    return idArticulo;
  }

  public String getIdSubscriptor() {
    return idSubscriptor;
  }

  public String getFechaRenta() {
    return fechaRenta.getFecha();
  }

  public String getFechaVencimiento() {
    return fechaVencimiento.getFecha();
  }

  public String getDatos() {
    return "ID Renta: " + getIdRenta() + "\n" +
           "ID Artículo: " + getIdArticulo() + "\n" +
           "ID Subscriptor: " + getIdSubscriptor() + "\n" +
           "Fecha de renta: " + getFechaRenta() + "\n";
  }
}
