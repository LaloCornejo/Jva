package SchoolPOO.pck_Tienda;

import SchoolPOO.pck_Fecha.Fecha;
import java.util.Calendar;

public class Articulo {
  private int idArticulo;
  private String description;
  private String marca;
  private String contenido;
  private String categoria;
  private String status;
  private Fecha fechaC = new Fecha();
  private Fecha fechaCaducidad;
  private float precio;


  public Articulo(int idArticulo, String description, String marca, Fecha fechaCaducidad) {
    this.idArticulo = idArticulo;
    this.description = description;
    this.marca = marca;
    this.fechaCaducidad = fechaCaducidad;
  }

  public Articulo() {
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

  public void setPrecio( float precio ) {
    this.precio = precio;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  public void setCategoria( String categoria ){
    this.categoria = categoria;
  }

  public void setStatus( String status ){
    this.status = status;
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

  public float getPrecio(){
    return precio;
  }

  public String getContenido(){
    return contenido;
  }

  public String getCategoria(){
    return categoria;
  }

  public String getStatus() {
    return status;
  }
  
  public boolean Perecedero() {
    Calendar fechaActual = Calendar.getInstance();
    int dia = fechaActual.get(Calendar.DATE);
    int mes = fechaActual.get(Calendar.MONTH) + 1;
    int anio = fechaActual.get(Calendar.YEAR);

    if (fechaCaducidad.getAnio() < anio) {
      return true;
    } else if (fechaCaducidad.getAnio() == anio && fechaCaducidad.getMes() < mes) {
      return true;
    } else if (fechaCaducidad.getAnio() == anio && fechaCaducidad.getMes() == mes && fechaCaducidad.getDia() < dia) {
      return true;
    } else {
      return false;
    }
  }

  public void remove() {
    this.idArticulo = 0;
    this.description = null;
    this.marca = null;
    this.fechaCaducidad = new Fecha();
  }

  public boolean Caducado() {
    Calendar fechaActual = Calendar.getInstance();
    int dia = fechaActual.get(Calendar.DATE);
    int mes = fechaActual.get(Calendar.MONTH) + 1;
    int anio = fechaActual.get(Calendar.YEAR);

    if (fechaCaducidad.getAnio() < anio) {
      return true;
    } else if (fechaCaducidad.getAnio() == anio && fechaCaducidad.getMes() < mes) {
      return true;
    } else if (fechaCaducidad.getAnio() == anio && fechaCaducidad.getMes() == mes && fechaCaducidad.getDia() < dia) {
      return true;
    } else {
      return false;
    }
  }

  String headerString = "\n\nID\tDescription\tMarca\tFecha de caducidad\tPrecio\tContenido\tCategoria\tStatus\n-----------------------------------------------------------------------------------------\n";

  public String getDatos() {
    return headerString + getIdArticulo() + "\t" + getDescription() + "\t\t" + getMarca() + "\t" + getFechaCaducidad() + "\t" + getPrecio() + "\t" + getContenido() + "\t" + getCategoria() + "\t" + getStatus();
  }
}