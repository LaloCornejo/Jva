package SchoolPOO.pck_Biblioteca;


public class Libro extends Ficha {
  private String autor;
  private String editorial;
  private int noPaginas;
  private int anioPublication;

  public Libro(String ref, String titulo, String autor, String editorial, int noPaginas, int anioPublication) {
    super(ref, titulo);
    this.autor = autor;
    this.editorial = editorial;
    this.noPaginas = noPaginas;
    this.anioPublication = anioPublication;
  }

  public Libro() {
    this(null, null, null, null, 50, 0);
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public void setEditorial(String editorial) {
    this.editorial = editorial;
  }

  public void setNoPaginas(int noPaginas) {
    this.noPaginas = noPaginas;
  }

  public void setAnioPublication(int anioPublication) {
    this.anioPublication = anioPublication;
  }

  public String getAutor() {
    return autor;
  }

  public String getEditorial(){
    return editorial;
  }

  public int getNoPaginas(){
    return noPaginas;
  }

  public int getAnioPublication(){
    return anioPublication;
  }

  @Override
  public String getDatos() {
    return "==- LIBRO -==\n" + super.getDatos() + "Autor: " + getAutor() + "\nEditorial: " + getEditorial() + "\nNo. de paginas: " + getNoPaginas() + "\nAño de publicación: " + getAnioPublication() + "\n";
  }
}
