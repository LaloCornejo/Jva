package SchoolPOO.pck_Casa;

public class Casa {
  private int noCuartos;
  private int noPisos;
  private float noBanios;
  private static int areasVerdes = 2;

  public Casa(int noCuartos, int noPisos, float noBanios) {
    this.noCuartos = noCuartos;
    this.noPisos = noPisos;
    this.noBanios = noBanios;
  }

  public Casa() {
    this(0, 0, 0.0f);
  }

  public void setDatos(int noCuartos, int noPisos, float noBanios) {
    this.noCuartos = noCuartos;
    this.noPisos = noPisos;
    this.noBanios = noBanios;
  }

  public String getDatos() {
    return "Cuartos: " + noCuartos + "\nPisos: " + noPisos + "\nBaños: " + noBanios;
  }

  public static void setAreasVerdes(int areasVerdes) {
    Casa.areasVerdes = areasVerdes;
  }

  public static String  getAreasVerdes() {
    return "areas verdes: " + areasVerdes;
  }

}
