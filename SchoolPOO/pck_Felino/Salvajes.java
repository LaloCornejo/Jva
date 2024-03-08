package SchoolPOO.pck_Felino;

public class Salvajes extends Felino {
  protected String especie;
  protected String region;

  public Salvajes( int idFelino, String color, String tamano, String especie, String region ){
    super( idFelino, color, tamano );
    this.especie = especie;
    this.region = region;
  }

  public Salvajes(){
    this( 0, null, null, null, null );
  }

  public void setEspecie( String especie ){
    this.especie = especie;
  }

  public void setRegion( String region ){
    this.region = region;
  }

  public String getEspecie(){
    return especie;
  }

  public String getRegion(){
    return region;
  }

  @Override
  public String getDatos(){
    return "==- SALVAJES -==\n" + "ID: " + getIDFelino() + "\nColor: " + getColor() + "\nTamanio: " + getTamano() + "\nEspecie: " + getEspecie() + "\nRegion: " + getRegion();
  }
}