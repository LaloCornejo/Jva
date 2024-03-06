package SchoolPOO.pck_Felinos;

public class Domesticos extends Felino {
  protected String nombre;
  protected String dueno;
  protected int noVacunas;

  public Domesticos( int idFelino, String color, String tamanio  String nombre, String dueno, int noVacunas ){
    super( idFelino , color, tamanio)
    this.nombre = nombre;
    this.dueno = dunoe;
    this.noVacunas = noVacunas;
  }

  public Domesticos(){
    this( 0, null, null, null, null, 0 );
  }

  public void setNombre( String nombre ){
    this.nombre = nombre;
  }

  public void setDueno( String dueno ){
    this.dueno = dueno;
  }

  public void setNoVacunas( int noVacunas ){
    this.noVacunas = noVacunas;
  }

  public String getNombre(){
    return nombre;
  }

  public String getDueno(){
    return dueno;
  }

  public int getNoVacunas(){
    return noVacunas;
  }

  @Override
  public String getDatos(){
    return "==- DOMESTICOS -==\n" + "ID: " + getIDFelino() + "\nColor: " + getColor() + "\nTamanio: " + getTamanio() + "\nNombre: " + getNombre() + "\nDueno: " + getDueno() + "\nNo.Vacunas: " + getNoVacunas();
  }
}