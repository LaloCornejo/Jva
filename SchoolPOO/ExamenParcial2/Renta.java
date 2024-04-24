package SchoolPOO.ExamenParcial2;

public class Renta {
  private int idRenta;
  private int idArticulo;
  private int idSubscriptor;
  private Fecha fechaRenta;
  private Fecha fechaVencimiento;

  public Renta() {
    this.idRenta = 0;
    this.idArticulo = 0;
    this.idSubscriptor = 0;
    this.fechaRenta = "";
    this.fechaVencimiento = "";
  }

  public Renta(int idRenta, int idArticulo, int idSubscriptor, String fechaRenta, String fechaVencimiento) {
    this.idRenta = idRenta;
    this.idArticulo = idArticulo;
    this.idSubscriptor = idSubscriptor;
    this.fechaRenta = fechaRenta;
    this.fechaVencimiento = fechaVencimiento;
  }

  public void setIdRenta(int idRenta) {
    this.idRenta = idRenta;
  }

  public void setIdArticulo(int idArticulo) {
    this.idArticulo = idArticulo;
  }

  public void setIdSubscriptor(int idSubscriptor) {
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

  public int getIdSubscriptor() {
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
           "Fecha de renta: " + fechaRenta.getFecha() + "\n" +
           "Fecha de vencimiento: " + fechaVencimiento.getFecha();
  }
}
