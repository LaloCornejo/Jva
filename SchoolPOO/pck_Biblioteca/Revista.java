package SchoolPOO.pck_Biblioteca;


public class Revista extends Ficha{
  private int anio;
  private int numero;

  public Revista( String ref, String titulo, int anio, int numero ) {
    super( ref, titulo );
    this.anio = anio;
    this.numero = numero;
  }

  public Revista() {
    this( null, null, 0, 0 );
  }

  public void setAnioPublication( int anio ) {
    this.anio = anio;
  }

  public void setNumero( int numero ) {
    this.numero = numero;
  }

  public int getAnioPublication() {
    return anio;
  }

  public int getNumero() {
    return numero;
  }

  @Override
  public String getDatos() {
    return "Referencia: " + getReferencia() + "\nTitulo: " + getTitulo() + "\nAño de publicación: " + getAnioPublication() + "\nNúmero: " + getNumero() + "\n";
  }
}
