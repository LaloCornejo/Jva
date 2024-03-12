package SchoolPOO.pck_Fecha;

public class Fecha {
  private int dia;
  private int mes;
  private int anio;

  public Fecha(int dia, int mes, int anio) {
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
  }

  public Fecha() {
    this.dia = 1;
    this.mes = 1;
    this.anio = 1900;
  }

  public void setFecha(int dia, int mes, int anio) {
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
  }

  public boolean esBisiesto() {
    if (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0){
      return true;
    }
    return false;
  }

  public boolean fechaCorrecta() {
    switch (mes) {
      case 4:
      case 6:
      case 9:
      case 11:
        if (dia > 30 || dia < 1) {
          return false;
        }
        break;
      case 2:
        if (esBisiesto()) {
          if (dia > 29 || dia < 1) {
            return false;
          }
        } else {
          if (dia > 28 || dia < 1) {
            return false;
          }
        }
        break;
      default:
        if (dia > 31 || dia < 1) {
          return false;
        }
        break;
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
    if( fechaCorrecta() ) {
      return dia + "/" + mes + "/" + anio;
    }
    return "Fecha incorrecta";
  }
}
