// Jesus Eduardo Cornejo Clavel 3ro 1
package SchoolPOO.ExamenParcial2;

public class Pelicula extends Articulo {
  private String genero;
  private String director;
  private String pais;

  public Pelicula() {
    super();
    this.genero = "";
    this.director = "";
    this.pais = "";
  }

  public Pelicula(int idArticulo, String titulo, String productor, int anio, int duracion, double costo, String genero,
      String director, String pais) {
    super(idArticulo, titulo, productor, anio, duracion, costo);
    this.genero = genero;
    this.director = director;
    this.pais = pais;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getGenero() {
    return genero;
  }

  public String getDirector() {
    return director;
  }

  public String getPais() {
    return pais;
  }

  @Override
  public String getDatos() {
    return super.getDatos() +
        "\nGenero: " + getGenero() +
        "\nDirector: " + getDirector() +
        "\nPais: " + getPais() + "\n";
  }
}
