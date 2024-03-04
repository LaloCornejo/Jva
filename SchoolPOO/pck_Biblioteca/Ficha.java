package SchoolPOO.pck_Biblioteca;

public class Ficha {
  protected String referencia;
  protected String titulo;

  public Ficha(String ref, String titulo) {
    this.referencia = ref;
    this.titulo = titulo;
  }

  public Ficha() {
    this(null, null);
  }

  public void setReferencia(String ref) {
    this.referencia = ref;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getReferencia() {
    return referencia;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDatos() {
    return "Referencia: " + getReferencia() + "\nTitulo: " + getTitulo() + "\n";
  }
}
