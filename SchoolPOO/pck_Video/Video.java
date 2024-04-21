// Desarrollado por: Jesus Eduardo Cornejo Clavel
package SchoolPOO.pck_Video;

public class Video {
  private String titulo;
  private String productor;
  private String classification;
  private String genero;
  private float duration;
  private String fechaEstreno;

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setProductor(String productor) {
    this.productor = productor;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public void setDuration(float duration) {
    this.duration = duration;
  }

  public void setFechaEstreno(String fechaEstreno) {
    this.fechaEstreno = fechaEstreno;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public String getProductor() {
    return this.productor;
  }

  public String getClassification() {
    return this.classification;
  }

  public String getGenero() {
    return this.genero;
  }

  public float getDuration() {
    return this.duration;
  }

  public String getFechaEstreno() {
    return this.fechaEstreno;
  }

  public String getDatos() {
    return "Titulo: " + getTitulo() + "\nProductor: " + getProductor() + "\nClassification: " + getClassification()
        + "\nGenero: " + getGenero() + "\nDuration: " + getDuration() + "\nFecha Estreno: " + getFechaEstreno();
  }
}
