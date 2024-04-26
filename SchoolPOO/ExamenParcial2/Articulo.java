// Jesus Eduardo Cornejo Clavel 3ro 1
package SchoolPOO.ExamenParcial2;

import java.io.Serializable;

public class Articulo implements Serializable {
  private int idArticulo;
  private String titulo;
  private String productor;
  private int anio;
  private int duracion;
  private double costo;

  public Articulo() {
    this.idArticulo = 0;
    this.titulo = "";
    this.productor = "";
    this.anio = 0;
    this.duracion = 0;
    this.costo = 0.0;
  }

  public Articulo(int idArticulo, String titulo, String productor, int anio, int duracion, double costo) {
    this.idArticulo = idArticulo;
    this.titulo = titulo;
    this.productor = productor;
    this.anio = anio;
    this.duracion = duracion;
    this.costo = costo;
  }

  public void setIdArticulo(int idArticulo) {
    this.idArticulo = idArticulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setProductor(String productor) {
    this.productor = productor;
  }

  public void setAnioEstreno(int anio) {
    this.anio = anio;
  }

  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }

  public void setCosto(double costo) {
    this.costo = costo;
  }

  public int getIdArticulo() {
    return idArticulo;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getProductor() {
    return productor;
  }

  public int getAnioEstreno() {
    return anio;
  }

  public int getDuracion() {
    return duracion;
  }

  public double getCosto() {
    return costo;
  }

  public String getDatos() {
    return "***** ARTICULO *****" +
      "\nidArticulo: " + getIdArticulo() +
      "\nTitulo: " + getTitulo() +
      "\nProductor: " + getProductor() +
      "\nAño de Estreno: " + getAnioEstreno() +
      "\nDuracion: " + getDuracion() + " minutos" +
      "\nCosto: $" + getCosto();
  }
}
