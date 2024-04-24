package SchoolPOO.ExamenParcial2;

public class Serie extends Articulo{
  private String categoria;
  private int temporada;
  private int noCapitulos;

  public Serie() {
    super();
    this.categoria = "";
    this.temporada = 0;
    this.noCapitulos = 0;
  }

  public Serie(int idArticulo, String titulo, String productor, int anio, int duracion, double costo, String categoria,
      int temporada, int noCapitulos) {
    super(idArticulo, titulo, productor, anio, duracion, costo);
    this.categoria = categoria;
    this.temporada = temporada;
    this.noCapitulos = noCapitulos;
  }
  
  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public void setTemporada(int temporada) {
    this.temporada = temporada;
  }

  public void setNoCapitulos(int noCapitulos) {
    this.noCapitulos = noCapitulos;
  }

  public String getCategoria() {
    return categoria;
  }

  public int getTemporada() {
    return temporada;
  }

  public int getNoCapitulos() {
    return noCapitulos;
  }

  @Override
  public String getDatos() {
    return super.getDatos() +
        "Categoria: " + getCategoria() +
        "\nTemporada: " + getTemporada() +
       "\nNo. Capitulos: " + getNoCapitulos() + "\n";
  }
}