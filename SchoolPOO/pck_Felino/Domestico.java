package SchoolPOO.pck_Felino;

public class Domestico extends Felino {
  protected String nombre;
  protected String dueno;
  protected int noVacunas;

  public Domestico( int idFelino, String color, String tamano,  String nombre, String dueno, int noVacunas ){
    super( idFelino , color, tamano);
    this.nombre = nombre;
    this.dueno = dueno;
    this.noVacunas = noVacunas;
  }

  public Domestico(){
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
    return "==- Domestico -==\n" + "ID: " + getIDFelino() + "\nColor: " + getColor() + "\ntamano: " + getTamano() + "\nNombre: " + getNombre() + "\nDueno: " + getDueno() + "\nNo.Vacunas: " + getNoVacunas();
  }
}