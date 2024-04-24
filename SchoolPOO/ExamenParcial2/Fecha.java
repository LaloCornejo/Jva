package SchoolPOO.ExamenParcial2;

import java.io.Serializable;

public class Fecha implements Serializable {
  private int dia;
  private int mes;
  private int anio;

  public Fecha() {
    this.dia = 1;
    this.mes = 1;
    this.anio = 2000;
  }

  public Fecha(int dia, int mes, int anio) {
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
  }

  public void setFecha(int dia, int mes, int anio) {
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
  }

  public boolean esBisiesto() {
      return this.anio % 4 == 0 && this.anio % 100 != 0 || this.anio % 400 == 0;
  }

  public boolean fechaCorrecta() {
    if (this.dia < 1 || this.dia > 31) {
      return false;
    }
    if (this.mes < 1 || this.mes > 12) {
      return false;
    }
    if (this.anio < 1900 || this.anio > 2024) {
      return false;
    }
    if (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) {
      if (this.dia > 30) {
        return false;
      }
    }
    if (this.mes == 2) {
      if (esBisiesto()) {
          return this.dia <= 29;
      } else {
          return this.dia <= 28;
      }
    }
    return true;
  }

  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getAnio() {
    return anio;
  }

  public String getFecha() {
    return this.dia + "/" + this.mes + "/" + this.anio;
  }

  
}
