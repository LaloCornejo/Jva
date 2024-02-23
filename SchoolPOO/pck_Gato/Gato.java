package SchoolPOO.pck_Gato;

public class Gato {
  private int idGato;
  private String nombre;
  private String raza;
  private float edad;
  private String color;
  private String sexo;

  public Gato(int idGato, String nombre, String raza, float edad, String color, String sexo) {
    this.idGato = idGato;
    this.nombre = nombre;
    this.raza = raza;
    this.edad = edad;
    this.color = color;
    this.sexo = sexo;
  }

  public Gato() {
    this.idGato = 0;
    this.nombre = null;
    this.raza = null;
    this.edad = 0.0f;
    this.color = null;
    this.sexo = null;
  }

  public void setIdGato(int idGato) {
    this.idGato = idGato;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setRaza(String raza) {
    this.raza = raza;
  }

  public void setEdad(float edad) {
    this.edad = edad;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public int getIdGato() {
    return idGato;
  }

  public String getNombre() {
    return nombre;
  }

  public String getRaza() {
    return raza;
  }

  public float getEdad() {
    return edad;
  }

  public String getColor() {
    return color;
  }

  public String getSexo() {
    if (sexo.equals("0"))
      return "Hembra";
    else if (sexo.equals("1"))
      return "Macho";
    else
      return "No especificado";
  }

  public String getDatos() {
    return "***** GATO *****\n" +
        "\nID: " + getIdGato() +
        "\nNombre: " + getNombre() +
        "\nRaza: " + getRaza() +
        "\nEdad: " + getEdad() +
        "\nColor: " + getColor() +
        "\nSexo: " + getSexo();
  }
}
